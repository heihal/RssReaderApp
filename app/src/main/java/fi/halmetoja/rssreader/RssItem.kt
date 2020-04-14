package fi.halmetoja.rssreader

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*



class RssItem : Comparable<RssItem> {
    var enclosure= ""
    var title = ""
    var link = ""
    //var guid = ""
   // var author = ""
    //var thumbnail = ""
    var pubDate = ""
    var description = ""
    var category = ""
   var content = ""
    var channel= ""
    var pubDateForArray: Date? = null
    var tmpDate=""
    var tmptmp:Int=0


    private fun getPubTime(): Date? {
        return this.pubDateForArray
    }

    private fun setPubDate(date:Date){
        this.pubDateForArray = date
    }

    override fun compareTo(item: RssItem): Int {
        val compDate: Date? = item.getPubTime()
        if( this.pubDateForArray!=null){
        return if(this.pubDateForArray!!.after(compDate)){
            1
        } else -1}


    return 0

    }

    fun formatPubDate(){
        val pubDateString = try {
            val sDString = this.pubDate
            //Fri, 10 Apr 2020 10:00:00 +0300
            val sourceSdf = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH)
            val date = sourceSdf.parse(sDString)
            setPubDate(date)

            val sdf = SimpleDateFormat("yyyyMMdd")
           val tmp = SimpleDateFormat("HHmm")

            val local = Calendar.getInstance().time
            val ekaInt=   Integer.parseInt(sdf.format(local))
            val tokaInt = Integer.parseInt(sdf.format(date))

            tokaInt-ekaInt

        } catch (e: ParseException) {
            e.printStackTrace()

        }
        val kello = try {
            val sourceDateString = this.pubDate
            //Fri, 10 Apr 2020 10:00:00 +0300
            val sourceSdf = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH)
            val date = sourceSdf.parse(sourceDateString)

            val sdf = SimpleDateFormat("HH:mm")
            sdf.format(date)


        } catch (e: ParseException) {
            e.printStackTrace()

        }
        if (pubDateString == 0){
            this.tmpDate = "Tänään $kello"
        } else{this.tmpDate = "eilen $kello"}

    }


    override fun toString(): String {
        return "RssItem(title='$title', link='$link', pubDate='$pubDate', description='$description', categories='$category', enclosure = '$enclosure, content = '$content', channel='$channel')"
    }
}


