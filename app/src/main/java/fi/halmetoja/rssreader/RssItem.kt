package fi.halmetoja.rssreader

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * RSS feed item object model
 * Commented out parts of could be implemented later
 *
 */

class RssItem : Comparable<RssItem> {
    var enclosure = ""
    var title = ""
    var link = ""
    //var guid = ""
    //var author = ""
    //var thumbnail = ""
    var pubDate = ""
    var description = ""
    var category = ""
    private var content = ""
    var channel = ""
    private var pubDateForArray: Date? = null
    var tmpDate = ""


    /**
     * Get pub date
     *
     * @return Date object of Rss item
     */
    private fun getPubTime(): Date? {
        return this.pubDateForArray
    }

    /**
     * Set pub date
     *
     * @param date Type of Date object
     */

    private fun setPubDate(date: Date) {
        this.pubDateForArray = date
    }

    /**
     * TODO doesn't work like it suppose to (compDate is null most of the time)
     * overrides compareTo in Comparable Interface
     * @param item Compares item's pub date to another item
     * @return integer to use in sort function
     */

    override fun compareTo(item: RssItem): Int {
        val compDate: Date? = item.getPubTime()
        if (this.pubDateForArray != null) {
            return if (this.pubDateForArray!!.after(compDate)) {
                -1
            } else 1
        }
        return 0

    }

    /**
     * Formatting RSS pub date and setting it to Rss item's text field
     *
     */

    @SuppressLint("SimpleDateFormat")
    fun formatPubDate() {
        var tmp: Date? = null
        val pubDateString = try {
            val sDString = this.pubDate
            val sourceSdf = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH)
            val date = sourceSdf.parse(sDString)

            tmp = date
            val sdf = SimpleDateFormat("yyyyMMdd")
            val local = Calendar.getInstance().time
            val ekaInt = Integer.parseInt(sdf.format(local))
            val tokaInt = Integer.parseInt(sdf.format(date))

            tokaInt - ekaInt

        } catch (e: ParseException) {
            e.printStackTrace()

        }
        val kello = try {
            val sourceDateString = this.pubDate
            val sourceSdf = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH)
            val date = sourceSdf.parse(sourceDateString)

            val sdf = SimpleDateFormat("HH:mm")
            sdf.format(date)


        } catch (e: ParseException) {
            e.printStackTrace()

        }
        this.pubDateForArray= tmp
        if (pubDateString == 0) {
            this.tmpDate = "Tänään $kello"
        } else {
            this.tmpDate = "eilen $kello"
        }

    }

    /**
     *
     *
     * @return RSS item properties as a string
     */


    override fun toString(): String {
        return "RssItem(title='$title', link='$link', pubDate='$pubDate', description='$description', categories='$category', enclosure = '$enclosure, content = '$content', channel='$channel')"
    }
}




