package fi.halmetoja.rssreader

import android.os.AsyncTask
import java.io.IOException
import java.io.InputStream
import java.lang.ref.WeakReference
import java.net.URL
import javax.net.ssl.HttpsURLConnection

/**
 * TODO
 *
 * @constructor
 * TODO
 *
 * @param context
 */
class RssFeedFetcher(context: RSSFragment) : AsyncTask<URL, Void, List<RssItem>>() {
    private val reference = WeakReference(context)
    private var stream: InputStream? = null
    override fun doInBackground(vararg params: URL?): List<RssItem>? {
        val connect = params[0]?.openConnection() as HttpsURLConnection
        connect.readTimeout = 8000
        connect.connectTimeout = 8000
        connect.requestMethod = "GET"
        connect.connect()

        val responseCode: Int = connect.responseCode
        val rssItems: List<RssItem>? = null
        if (responseCode == 200) {
            stream = connect.inputStream
            try { onPostExecute(RssParser().parse(stream!!))
            } catch (e: IOException) { e.printStackTrace()}
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