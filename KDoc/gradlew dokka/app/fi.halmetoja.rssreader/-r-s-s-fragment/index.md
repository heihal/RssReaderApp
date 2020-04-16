[app](../../index.md) / [fi.halmetoja.rssreader](../index.md) / [RSSFragment](./index.md)

# RSSFragment

`class RSSFragment : Fragment`

[RssItem](../-rss-item/index.md) Activity /Fragment

### Constructors

| [&lt;init&gt;](-init-.md) | `RSSFragment()`<br>[RssItem](../-rss-item/index.md) Activity /Fragment |

### Functions

| [onActivityCreated](on-activity-created.md) | `fun onActivityCreated(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets [LinearLayoutManager](#) and adapter |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?`<br>Inflates [R.layout.rss_frag_list](#) layout with container |
| [updateRV](update-r-v.md) | `fun updateRV(newRssItemsList: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`RssItem`](../-rss-item/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Updates [listView](#)'s [rssItemsAll](#) array and notifies UI |

