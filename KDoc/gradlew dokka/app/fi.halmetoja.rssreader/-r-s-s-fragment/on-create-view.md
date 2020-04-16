[app](../../index.md) / [fi.halmetoja.rssreader](../index.md) / [RSSFragment](index.md) / [onCreateView](./on-create-view.md)

# onCreateView

`fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?`

Inflates [R.layout.rss_frag_list](#) layout with container

Creates [FloatingActionButton](#) and adds listener to it

([reloadRSS](#) and makes a [Toast](https://developer.android.com/reference/android/widget/Toast.html) about it)

Sets [listView](#) as RecyclerView which contains [R.layout.rss_frag_row](#)

### Parameters

`inflater` -

`container` -

`savedInstanceState` -

**Return**
Rss_frag_list view [myView](#)

