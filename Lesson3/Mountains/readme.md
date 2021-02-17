# Mountains

## Tasks

FranskeBjerge.csv er en semikolon-separeret tekst fil, hvor hver linje giver oplysninger om de bjerge i Frankrig, som
har en topographic prominence højere end 1000 meter (topographic prominence er den relative højde af en bjergtop, se
figuren, som er oversat fra en.wikipedia.org):

I filen er et bjerg beskrevet ved:

- `name` - Bjergets navn
- `height` - Højde over havets overflade
- `prominence` - Relativ højde (fig. 1)
- `latitude` - Breddegrad i Grader°Minutter’Sekunder”
- `longitude` - Længdegrad i Grader°Minutter’Sekunder”
- `range` - Bjergkæde

Som eksempel er her linjen for Mount Ventoux:
> Mont Ventoux;1909;1148;44°10'26";05°16'42";Alps

I denne opgave skal filen indlæses og oplysningerne indsættes i en datastruktur I opgaverne 1 og 2 skal der
implementeres en klasse med signaturen `public class Mountain implements Comparable`. Instanser af klassen kan holde
informationerne om ét bjerg. Det udleverede kodeskelet indeholder en `main`-metode, som kan bruges til at teste klassen
med.

### Eksempel

![mountain](assets/mountain.png)

- De lodrette linjer viser den topografiske prominence af 3 bjergtoppe på en ø.
- De stiplede vandrette linjer angiver den laveste højdekurve, som ikke omslutter en højere bjergtop.

### Task 1 - Oprettelse af Mountain klassen

I constructoren til `Mountain`, skal de 6 felter initialiseres og `public String toString() overskrives`, så testkørsel
af programmet giver et output, som ligner følgende:

> Mont Ventoux h=1909, pro=1148, lat=44°10'26", lon=05°16'42", ran=Alps

### Task 2 - compareTo()-metode

Implementer `public int compareTo(Mountain o)`, så instanser af Mountain kan ordnes efter `prominence`. Hvis flere
bjergtoppe har samme `prominence`, skal disse ordnes efter `height`.

Ved at fjerne udkommenteringen af koden i main-metoden, skal der opnås et output som ligner dette:

```
Usorteret:
[Pica d'Estats h=3143, pro=1281, lat=42°42'43", lon=00°57'23", ran=Pyrenees
, Mont Chaberton h=3131, pro=1281, lat=44°57'53", lon=06°45'06", ran=Alps
, Pic de Bure h=2709, pro=1268, lat=44°37'38", lon=05°56'07", ran=Alps
, Pic du Midi d'Ossau h=2886, pro=1092, lat=42°48'22", lon=-00°25'05", ran=Pyrenees
]
Sorteret:
[Pic du Midi d'Ossau h=2886, pro=1092, lat=42°48'22", lon=-00°25'05", ran=Pyrenees
, Pic de Bure h=2709, pro=1268, lat=44°37'38", lon=05°56'07", ran=Alps
, Mont Chaberton h=3131, pro=1281, lat=44°57'53", lon=06°45'06", ran=Alps
, Pica d'Estats h=3143, pro=1281, lat=42°42'43", lon=00°57'23", ran=Pyrenees
]
```

### Task 3 - Indlæsning af bjerge fra tekstfil

Implementer en java main klasse med signaturen `public class MountainSet`.

Klassen skal indeholde:

- En datastruktur af typen `Set<Mountain>`
- En constructor, som initialiserer datastrukturen, så den altid er sorteret vha. `compareTo()` metoden i klassen
  Mountain.
- En `get()`-metode, som returnerer settet.
- En `public static void main(String[] args)`-metode, hvori der:
    - erklæres og initialiseres en instans af `MountainSet`
    - _FranskeBjerge.csv_ læses en linje ad gangen
    - for hver linje oprettes en instans af `Mountain`, som indsættes vha. `add(Mountain m)`
    - til slut udskrives settet på `System.out`.

De første 7 linjer af usdkriften bør nu ligne dette:

```
[Mont Blanc h=4808, pro=4695, lat=45°49'57", lon=06°51'52", ran=Alps
, Barre des Écrins h=4102, pro=2045, lat=44°55'21", lon=06°21'36", ran=Alps
, Chamechaude h=2082, pro=1771, lat=45°17'17", lon=05°47'24", ran=Alps
, Arcalod h=2217, pro=1713, lat=45°40'54", lon=06°13'42", ran=Alps
, Pointe Percée h=2750, pro=1643, lat=45°57'20", lon=06°33'22", ran=Alps
, Puy de Sancy h=1885, pro=1575, lat=45°31'42", lon=02°48'51", ran=Massif
Central, Grande Tête de l'Obiou h=2790, pro=1542, lat=44°46'32", lon=05°50'23",
ran=Alps]
```

### Task 4 - Sorteret Set med Comparator

Implementer en klasse med signaturen

`public class MountainRangeComparator implements Comparator<Mountain>` som kan benyttes til at sortere objekter af
klassen `Mountain` efter hvilken bjergkæde (`Range`) de ligger i. Indenfor bjergkæderne, skal der sorteres
med `compareTo()`-metoden i `Mountain`.

Nb: _Det kan være en fordel at tilføje en_ `public int getRange()` -_metode til_ `Mountain` _klassen_.

Tilføj en metode til `MountainSet`-klassen:
`public Set<Mountain> sortByRange(Comparator comp)` som danner og returnerer et Set, som er sorteret med en instance
af `MountainRangeComparator`.

Med linjen `System.out.println(mSet.sortByRange(new MountainRangeComparator()));`
tilføjet til `MountainSet`’s `main()`-metode, bør udskriften nu begynde med alle bjerge i Alperne:

```
Sorted by range:
[Mont Blanc h=4808, pro=4695, lat=45°49'57", lon=06°51'52", ran=Alps
, Barre des Écrins h=4102, pro=2045, lat=44°55'21", lon=06°21'36", ran=Alps
, Chamechaude h=2082, pro=1771, lat=45°17'17", lon=05°47'24", ran=Alps
, Arcalod h=2217, pro=1713, lat=45°40'54", lon=06°13'42", ran=Alps
, Pointe Percée h=2750, pro=1643, lat=45°57'20", lon=06°33'22", ran=Alps
, Grande Tête de l'Obiou h=2790, pro=1542, lat=44°46'32", lon=05°50'23",ran=Alps
- - - o.s.v- - -
```

og slutte med de andre bjergkæder:

```
- - - o.s.v- - -
, Crêt de la Neige h=1720, pro=1267, lat=46°16'49", lon=05°57'16", ran=Jura
, Puy de Sancy h=1885, pro=1575, lat=45°31'42", lon=02°48'51", ran=Massif Central
, Puigmal h=2909, pro=1331, lat=42°29'47", lon=02°05'37", ran=Pyrenees
, Pica d'Estats h=3143, pro=1281, lat=42°42'43", lon=00°57'23", ran=Pyrenees
, Pic du Midi d'Ossau h=2886, pro=1092, lat=42°48'22", lon=-00°25'05", ran=Pyrenees
, Vignemale h=3298, pro=1025, lat=42°42'16, lon=-00°03'50", ran=Pyrenees
, Soularac h=2368, pro=1007, lat=42°45'58", lon=01°51'05", ran=Pyrenees
, Puig Carlitte h=2921, pro=1001, lat=42°33'39", lon=01°48'37", ran=Pyrenees
, Grand Ballon h=1424, pro=1072, lat=47°54'04", lon=07°05'53", ran=Vosges
]
```