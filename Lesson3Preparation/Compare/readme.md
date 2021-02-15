# Compare

## Tasks

### Task 1a - Comparator interface

Open `vop.People.Person.java` and implement the `compareTo()` method, so instances of `Person` can be sorted by their surname (`lName` in the file). If they are the same, sort on first name (`fName`). If still the same, sort by _birthday_.

Study cp. 20.6 (`Comparator`) carefully.

### Task 1b - Comparator interface

Implement the `Comparator` (anonymous inner class in the main()-method of Person), so Persons can be sorted by their `height`.

### Task 2 - Reading material

- From cp. 21.2, study all about `HashSet` and `TreeSet` carefully (21.2.2 `LinkedHashSet` can be skipped).
- Cp 21.3 can be skipped.
- Test (and try to understand) 21.4 Case Study: _Counting Keywords_.
- From cp. 21.5, study all about `HashMap` and `TreeMap` carefully (`LinkedHashMap` can be skipped).

### Task 3 - (partly based on cp. 21.6 Case Study: Occurrences of Words)

- Open `vop.TextAnalyzer.TextAnalyzer.java`.
- It’s about 3 ways to analyse the novel Alice in Wonderland (see Alice30.txt in the project map).
- Instructions are written as comments to the tree public methods. In `main()` you can test the individual part, by uncommenting the needed lines.
- **Nb**.: The parameter sorted, decides if you will use Hash- or Tree- implementations. The `clean()` method gets rid of a lot of strange characters and makes all letters lower case