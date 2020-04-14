package fi.halmetoja.rssreader


import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ViewAdapter (
    private val mValues: List<RssItem>,
    private val context : FragmentActivity?


) : RecyclerView.Adapter<ViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rss_frag_row, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int)  = holder.bind(mValues[position])

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val titleTV: TextView? = mView.findViewById(R.id.otsake)
        val pubDateTV: TextView? = mView.findViewById(R.id.pvm)
        val channelTV: TextView? = mView.findViewById(R.id.lehti)
        val featuredImg: ImageView = mView.findViewById(R.id.featuredImg);



        fun bind(item: RssItem) {

            titleTV?.text = item.title
            channelTV?.text= item.channel
            item.formatPubDate()
            pubDateTV?.text = item.tmpDate

            var imgLink = item.enclosure

            if(imgLink != null) {
                context?.let {
                    Glide.with(it)
                        .load(imgLink)
                        .into(featuredImg)
                }
            }

            mView.setOnClickListener(View.OnClickListener {
                openWebView(mView,item)

            })

        }



        fun openWebView(view : View, item : RssItem){
        val articleView = WebView(itemView.context)

        articleView.settings.loadWithOverviewMode = true

        articleView.settings.javaScriptEnabled = true
        articleView.isHorizontalScrollBarEnabled = false
        articleView.webChromeClient = WebChromeClient()
        articleView.loadUrl(item.link)

        val alertDialog = androidx.appcompat.app.AlertDialog.Builder(itemView.context).create()
        alertDialog.setTitle(item.title)
        alertDialog.setView(articleView)
        alertDialog.setButton(androidx.appcompat.app.AlertDialog.BUTTON_NEUTRAL, "OK"
        ) { dialog, _ -> dialog.dismiss() }
        alertDialog.show()

        (alertDialog.findViewById<View>(android.R.id.message) as TextView).movementMethod = LinkMovementMethod.getInstance()
    }

    }



}

