package fi.halmetoja.rssreader


import android.os.AsyncTask
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import fi.halmetoja.rssreader.remote.*
import java.io.IOException
import java.io.InputStream
import java.lang.ref.WeakReference
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class RSSFragment : Fragment() {
    private val RSSFeedLinks =
        arrayListOf<String>(
            "https://feeds.yle.fi/uutiset/v1/recent.rss?publisherIds=YLE_UUTISET",
            "https://www.hs.fi/rss/tuoreimmat.xml",
        "https://www.iltalehti.fi/rss/rss.xml"
        )
    private var adapter: ViewAdapter? = null
    private var rssItemsAll: MutableList<RssItem> = mutableListOf<RssItem>()
    private lateinit var myView :View
    private var listV : RecyclerView ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myView = inflater.inflate(R.layout.rss_frag_list, container, false)
        val fab =myView?.findViewById<FloatingActionButton>(R.id.fab)
        fab?.setOnClickListener {
            reloadRSS()

  Toast.makeText(container?.context,"Reloaded", Toast.LENGTH_SHORT).show()
        }

        listV = myView.findViewById(R.id.listV)
        return myView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = ViewAdapter(rssItemsAll, activity)
        listV?.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        listV?.adapter = adapter
        reloadRSS()

    }

    fun reloadRSS(){
        for(x in RSSFeedLinks) {
            RssFeedFetcher(this).execute(URL(x))
        }

    }

    fun updateRV(rssItemsL: List<RssItem>) {
        getActivity()?.runOnUiThread(java.lang.Runnable {
            if (rssItemsL != null && !rssItemsL.isEmpty()) {
                rssItemsAll.addAll(rssItemsL)
                //rssItemsAll.sort()
                rssItemsAll.sortedByDescending { it.tmptmp }
                adapter?.notifyDataSetChanged()
            }
        })
    }


    class RssFeedFetcher(val context: RSSFragment) : AsyncTask<URL, Void, List<RssItem>>() {
        val reference = WeakReference(context)
        private var stream: InputStream? = null;
        override fun doInBackground(vararg params: URL?): List<RssItem>? {
            val connect = params[0]?.openConnection() as HttpsURLConnection
            connect.readTimeout = 8000
            connect.connectTimeout = 8000
            connect.requestMethod = "GET"
            connect.connect();

            val responseCode: Int = connect.responseCode;
            var rssItems: List<RssItem>? = null
            if (responseCode == 200) {
                stream = connect.inputStream;


                try { onPostExecute(RssParser().parse(stream!!)) }
                catch (e: IOException) { e.printStackTrace() }


            }

            return rssItems

        }




        override fun onPostExecute(result: List<RssItem>?) {
            super.onPostExecute(result)
            if (result != null && result.isNotEmpty()) {
                reference.get()?.updateRV(result)
            }

        }

    }



}