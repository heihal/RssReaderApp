package fi.halmetoja.rssreader



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.net.URL

/**
 * [RssItem] Activity /Fragment
 */

class RSSFragment : Fragment() {
    private val rssFeedLinks by lazy {
        arrayListOf(
            "https://feeds.yle.fi/uutiset/v1/recent.rss?publisherIds=YLE_UUTISET",
            "https://www.hs.fi/rss/tuoreimmat.xml",
            "https://www.iltalehti.fi/rss/rss.xml"
        )
    }
    private var adapter: ViewAdapter? = null
    private var rssItemsAll: MutableList<RssItem> = mutableListOf()
    private lateinit var myView: View
    private var listView: RecyclerView? = null

    /**
     * Inflates [R.layout.rss_frag_list] layout with container
     *
     * Creates [FloatingActionButton] [R.id.fab] and adds listener to it
     *
     * ([reloadRSS] and makes a [Toast] about it)
     *
     * Sets [listView] as RecyclerView which contains [R.layout.rss_frag_row]
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return Rss_frag_list view [myView]
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myView = inflater.inflate(R.layout.rss_frag_list, container, false)
        val fab = myView.findViewById<FloatingActionButton>(R.id.fab)
        fab?.setOnClickListener {
            reloadRSS()
            Toast.makeText(container?.context, "Reloaded", Toast.LENGTH_SHORT).show()
        }

        listView = myView.findViewById(R.id.listView)
        return myView
    }

    /**
     * Sets [LinearLayoutManager] and adapter
     *
     * to [listView] i.e. [RecyclerView]
     *
     * Reloads RSS feed
     *
     * @param savedInstanceState
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = ViewAdapter(rssItemsAll, activity)
        listView?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        listView?.adapter = adapter
        reloadRSS()

    }

    /**
     * Iterates over [rssItemsAll] and
     *
     * feeds the links to [RssFeedFetcher]
     *
     * @see RssFeedFetcher
     */

    private fun reloadRSS() {
        for (link in rssFeedLinks) {
            RssFeedFetcher(this).execute(URL(link))
        }
    }

    /**
     * Updates [listView]'s [rssItemsAll] array and notifies UI
     *
     * TODO RssItems sorting
     *
     * @see RssItem.compareTo to [sort] override
     * @param newRssItemsList
     */

    fun updateRV(newRssItemsList: List<RssItem>) {
        val runOnUiThread = activity?.runOnUiThread {
            if (newRssItemsList.isNotEmpty()) {
                rssItemsAll.addAll(newRssItemsList)
                rssItemsAll.sort()
                //rssItemsAll.sortedByDescending { it.tmptmp }
                adapter?.notifyDataSetChanged()
            }
        }
    }




}