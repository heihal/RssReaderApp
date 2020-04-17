# RssReaderApp

RssReaderApp on Kotlin- ohjelmointikielellä kirjoitettu mobiilisovellus Androida- alustalle. Sovelluksen minimivaatimuksena on Android Ice Cream Sandwich 4.0.3-4.0.4.

## Sovelluksen toiminta
Sovellus lukee RSS uutissyötteen seuraavilta sivustoilta:

- [Yle uutiset](https://feeds.yle.fi/uutiset/v1/recent.rss?publisherIds=YLE_UUTISET)
- [HS uutiset](https://www.hs.fi/rss/tuoreimmat.xml)
- [Iltalehti](https://www.iltalehti.fi/rss/rss.xml)

ja listaa uutiset allekkain näyttäen otsikon, uutiskuvan, julkaisuajankohdan
sekä julkaisijan. Uutista voi klikata, jolloin uutinen avautuu uuteen ikkunaan ja sen 
voi lukea kokonaisuudessaan. Päänäkymässä olevasta napista voi päivittää uutislistauksen.
Pyyhkäisemällä vasemmasta sivusta voi avata asetussivuston.

## Release paketin asennus 

Sovelluksen [apk-paketti](https://gitlab.utu.fi/hemhal/RssReaderApp/-/tree/master/app%2Frelease) ladataan ensin puhelimeen ja kun paketin avaa, niin se asentuu.

## Debug asennus

Kloonaa projekti itsellesi ja asenna tai käynnistä haluamassasi ohjelmassa. Sovellus 
käyttää gradlea pakkaamiseen ja asennukseen.
Projektin voi asentaa ja käynnistää esimerkiksi  projektin juuressa komentoriviltä (Linux):

```shell
./gradlew installDebug
```
Sovellus käynnistyy ennalta määriteltyyn emulaattoriin tai kytkettyyn laitteeseen.
Suosittelen avaamaan projekti Android Studiossa ja käyttää sen työkaluja. 
Lisää android- sovellusten [asentamisesta](https://developer.android.com/studio/run).
