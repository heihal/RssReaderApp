[app](../../index.md) / [fi.halmetoja.rssreader](../index.md) / [RssFeedFetcher](index.md) / [onPostExecute](./on-post-execute.md)

# onPostExecute

`protected fun onPostExecute(result: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`RssItem`](../-rss-item/index.md)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Updates [RSSFragment.rssItemsAll](#) if

[RSSFeedFetcher](#) got the [HttpsURLConnection](https://developer.android.com/reference/javax/net/ssl/HttpsURLConnection.html) open

and [RssParser](../-rss-parser/index.md) parsed the [stream](#)

### Parameters

`result` - list of RSS items

**See Also**

[RSSFragment.updateRV](../-r-s-s-fragment/update-r-v.md)

