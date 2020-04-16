[app](../index.md) / [fi.halmetoja.rssreader](./index.md)

## Package fi.halmetoja.rssreader

### Types

| [MainActivity](-main-activity/index.md) | `class MainActivity : AppCompatActivity, OnNavigationItemSelectedListener` |
| [RSSFragment](-r-s-s-fragment/index.md) | `class RSSFragment : Fragment`<br>[RssItem](-rss-item/index.md) Activity /Fragment |
| [RssFeedFetcher](-rss-feed-fetcher/index.md) | `class RssFeedFetcher : `[`AsyncTask`](https://developer.android.com/reference/android/os/AsyncTask.html)`<`[`URL`](https://developer.android.com/reference/java/net/URL.html)`, `[`Void`](https://developer.android.com/reference/java/lang/Void.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`RssItem`](-rss-item/index.md)`>>`<br>Opens [HttpsURLConnection](https://developer.android.com/reference/javax/net/ssl/HttpsURLConnection.html) to selected [URL](https://developer.android.com/reference/java/net/URL.html) and |
| [RssItem](-rss-item/index.md) | `class RssItem : `[`Comparable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)`<`[`RssItem`](-rss-item/index.md)`>`<br>RSS feed item object model |
| [RssParser](-rss-parser/index.md) | `class RssParser`<br>RSS Feed Parser |
| [ViewAdapter](-view-adapter/index.md) | `class ViewAdapter : Adapter<`[`ViewHolder`](-view-adapter/-view-holder/index.md)`>`<br>View Adapter for [RecyclerView](#) |

