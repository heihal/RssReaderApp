package fi.halmetoja.rssreader.remote

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream


class RssParser {
    private val rssItems = ArrayList<RssItem>()
    private var rssItem : RssItem ?= null
    private var text: String? = null

    fun parse(inputStream: InputStream):ArrayList<RssItem> {
        try {
            val factory = XmlPullParserFactory.newInstance()
            //factory.isNamespaceAware = true
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            var foundItem = false
            var otsake = false
            var otsakeString : String = ""



            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagname = parser.name
                when (eventType) {

                    XmlPullParser.START_TAG -> if (tagname.equals("item", ignoreCase = true)) {

                        foundItem = true
                        rssItem = RssItem()
                    }
                    else if (tagname.equals("channel", ignoreCase = true)) {
                    otsake = true
                    }

                        XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> if (tagname.equals("item", ignoreCase = true)) {

                        rssItem?.let { rssItems.add(it) }
                        foundItem = false
                    } else if (foundItem && tagname.equals("title", ignoreCase = true)) {
                        rssItem!!.title = text.toString()
                        rssItem!!.channel = otsakeString
                    }
                    else if (otsake && tagname.equals("title", ignoreCase = true)) {
                        otsakeString= text.toString()
                    } else if (!otsake && tagname.equals("channel", ignoreCase = true)) {
                        otsake= false
                    }
                    else if (foundItem && tagname.equals("link", ignoreCase = true)) {
                        rssItem!!.link = text.toString()
                    } else if (foundItem && tagname.equals("pubDate", ignoreCase = true)) {
                        rssItem!!.pubDate = text.toString()
                    } else if (foundItem && tagname.equals("category", ignoreCase = true)) {
                        rssItem!!.category = text.toString()
                    } else if (foundItem && tagname.equals("description", ignoreCase = true)) {
                        rssItem!!.description = text.toString()
                    } else if (foundItem && tagname.equals("enclosure", ignoreCase = true)) {
                        rssItem!!.enclosure = parser.getAttributeValue(null, "url");

                    }  else if (tagname.equals("content:encoded", ignoreCase = true)) {

                        /* TODO kaappaa content ja siirrä se toisessa threadissä RSSitemiin
                        *  saa CDATAn ja kääntää sen html:ksi, mutta aiheuttaa valkosen näytön
                        *  datan käsittely asynkronisesti?
                        *  tekstien parserointi siten, että näkyy WebViewssä
                         */
                       /*var token = parser.nextToken()
                        while (token != XmlPullParser.CDSECT) {
                            token = parser.nextToken()
                        }
                        val data = parser.text

                        //val doc: Document = Jsoup.parse(data)

                   rssItem!!.content = doc.toString()*/

                }
                }
                eventType = parser.next()
            }

        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return rssItems
    }
}