[app](../../index.md) / [fi.halmetoja.rssreader](../index.md) / [RssFeedFetcher](./index.md)

# RssFeedFetcher

`class RssFeedFetcher : `[`AsyncTask`](https://developer.android.com/reference/android/os/AsyncTask.html)`<`[`URL`](https://developer.android.com/reference/java/net/URL.html)`, `[`Void`](https://developer.android.com/reference/java/lang/Void.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`RssItem`](../-rss-item/index.md)`>>`

Opens [HttpsURLConnection](https://developer.android.com/reference/javax/net/ssl/HttpsURLConnection.html) to selected [URL](https://developer.android.com/reference/java/net/URL.html) and

feeds the [stream](#) to [RssParser](../-rss-parser/index.md)

### Constructors

| [&lt;init&gt;](-init-.md) | `RssFeedFetcher(context: `[`RSSFragment`](../-r-s-s-fragment/index.md)`)`<br>empty |

### Functions

| [doInBackground](do-in-background.md) | `fun doInBackground(vararg params: `[`URL`](https://developer.android.com/reference/java/net/URL.html)`?): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`RssItem`](../-rss-item/index.md)`>?` |
| [onPostExecute](on-post-execute.md) | `fun onPostExecute(result: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`RssItem`](../-rss-item/index.md)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Updates [RSSFragment.rssItemsAll](#) if |

