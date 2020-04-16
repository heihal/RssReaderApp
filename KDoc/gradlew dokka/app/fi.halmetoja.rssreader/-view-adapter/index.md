[app](../../index.md) / [fi.halmetoja.rssreader](../index.md) / [ViewAdapter](./index.md)

# ViewAdapter

`class ViewAdapter : Adapter<`[`ViewHolder`](-view-holder/index.md)`>`

View Adapter for [RecyclerView](#)

[ViewHolder](-view-holder/index.md) is an inner class

### Types

| [ViewHolder](-view-holder/index.md) | `inner class ViewHolder : ViewHolder`<br>Gets [R.layout.rss_frag_row](#)'s fields |

### Constructors

| [&lt;init&gt;](-init-.md) | `ViewAdapter(rssItems: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`RssItem`](../-rss-item/index.md)`> = mutableListOf(), context: FragmentActivity?)`<br>View Adapter for [RecyclerView](#) |

### Functions

| [getItemCount](get-item-count.md) | `fun getItemCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`ViewHolder`](-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Uses ViewHolder's [ViewHolder.bind](-view-holder/bind.md) method |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ViewHolder`](-view-holder/index.md)<br>Adds [RssItem](../-rss-item/index.md) to this view |

