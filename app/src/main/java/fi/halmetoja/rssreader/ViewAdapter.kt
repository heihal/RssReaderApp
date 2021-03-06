package fi.halmetoja.rssreader


import android.graphics.Color
import android.graphics.Color.GRAY
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * View Adapter for [RecyclerView]
 *
 * [ViewHolder] is an inner class
 *
 * @property rssItems List of [RssItem]s
 * @property context [RSSFragment] activity
 */
class ViewAdapter(
    private val rssItems: MutableList<RssItem> = mutableListOf(),
    private val context: FragmentActivity?


) : RecyclerView.Adapter<ViewAdapter.ViewHolder>() {

    /**
     * Adds [RssItem] to this view
     *
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rss_frag_row, parent, false)
        return ViewHolder(view)
    }

    /**
     * Uses ViewHolder's [ViewHolder.bind] method
     * @see ViewHolder.bind
     *
     * @param holder ViewHolder
     * @param position RSS item's position in Array
     */

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(rssItems[position])

    /**
     * @return RSS Items size
     */
    override fun getItemCount(): Int = rssItems.size

    /**
     * Gets [R.layout.rss_frag_row]'s fields
     *
     * and binds them with [RssItem]'s properties
     *
     * Sets listener for [R.layout.rss_frag_row]
     *
     * Load images with [Glide] from url
     *
     * @property view
     */

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView? = view.findViewById(R.id.otsake)
        private val pubDate: TextView? = view.findViewById(R.id.pvm)
        private val channel: TextView? = view.findViewById(R.id.lehti)
        private val img: ImageView = view.findViewById(R.id.kuva)


        fun bind(item: RssItem) {

            title?.text = item.title
            channel?.text = item.channel
            item.formatPubDate()
            pubDate?.text = item.tmpDate
            val imgLink = item.enclosure



            context?.let {
                Glide.with(it)
                    .load(imgLink)
                    .into(img)
            }

            view.setOnClickListener {
                title?.setTextColor(GRAY)
                openWebView(item)
            }

        }

        /**
         * Opens [RssItem]'s link in [WebView]
         *
         * @param item Selected [RssItem]
         */

        private fun openWebView(item: RssItem) {
            val articleView = WebView(itemView.context)

            articleView.settings.loadWithOverviewMode = true

            articleView.settings.javaScriptEnabled = true
            articleView.isHorizontalScrollBarEnabled = false
            articleView.webChromeClient = WebChromeClient()
            articleView.loadUrl(item.link)



            val alertDialog = AlertDialog.Builder(ContextThemeWrapper(articleView.context, R.style.AlertDialogCustom)).create()
            with(alertDialog){
                setTitle(item.channel)
                setView(articleView)
                setButton(
                    AlertDialog.BUTTON_NEUTRAL, "CLOSE"
                ) { dialog, _ -> dialog.dismiss() }
                show()
            }

           (alertDialog.findViewById<View>(android.R.id.message) as TextView).movementMethod =
                LinkMovementMethod.getInstance()
        }

    }


}

