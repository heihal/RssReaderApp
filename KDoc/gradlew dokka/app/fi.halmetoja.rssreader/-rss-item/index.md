[app](../../index.md) / [fi.halmetoja.rssreader](../index.md) / [RssItem](./index.md)

# RssItem

`class RssItem : `[`Comparable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)`<`[`RssItem`](./index.md)`>`

RSS feed item object model

Commented out those parts that can

be implemented later

### Constructors

| [&lt;init&gt;](-init-.md) | `RssItem()`<br>RSS feed item object model |

### Properties

| [category](category.md) | `var category: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [channel](channel.md) | `var channel: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [description](description.md) | `var description: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [enclosure](enclosure.md) | `var enclosure: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [link](link.md) | `var link: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [pubDate](pub-date.md) | `var pubDate: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [title](title.md) | `var title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [tmpDate](tmp-date.md) | `var tmpDate: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [compareTo](compare-to.md) | `fun compareTo(item: `[`RssItem`](./index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>TODO doesn't work like it suppose to |
| [formatPubDate](format-pub-date.md) | `fun formatPubDate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Formatting [pubDate](pub-date.md) and setting it to [RssItem](./index.md)'s text field |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

