# combinatory4j

## About

Combinatory4j is a simple java library for calculating variations, permutations and combinations.

## License

MIT licensed.

## Examples

### Variations

```java
HashSet<String> elements = new HashSet<>();
Collections.addAll(elements, "a", "b", "c", "d");
int groupSize = 2;
Collection<List<String>> results = Combinatory.generateVariations(elements, groupSize)
```
results contains:

```
[[a, b], [a, c], [a, d], [b, a], [b, c], [b, d], [c, a], [c, b], [c, d], [d, a], [d, b], [d, c]]
```

### Variations with repetitions

```java
HashSet<String> elements = new HashSet<>();
Collections.addAll(elements, "a", "b", "c", "d");
int groupSize = 2;
Collection<List<String>> results = Combinatory.generateVariationsWithRepetitions(elements, groupSize)
```
results contains:

```
[[a, a], [a, b], [a, c], [a, d], [b, a], [b, b], [b, c], [b, d], [c, a], [c, b], [c, c], [c, d], [d, a], [d, b], [d, c], [d, d]]
```


### Variations of repeated elements

```java
List<String> elements = Arrays.asList("a", "b", "a", "c");
int groupSize = 2;
Collection<List<String>> results = Combinatory.generateVariationsWithRepeatElements(elements, groupSize)
```
results contains:

```
[[a, b], [a, a], [a, c], [b, a], [b, c], [c, a], [c, b]]
```

### Combinations

```java
HashSet<String> elements = new HashSet<>();
Collections.addAll(elements, "a", "b", "c", "d");
int groupSize = 2;
Collection<Collection<String>> results = Combinatory.generateCombinations(elements, groupSize)
```
results contains:

```
[[b, a], [a, c], [a, d], [b, c], [b, d], [c, d]]
```

### Combinations with repetitions

```java
HashSet<String> elements = new HashSet<>();
Collections.addAll(elements, "a", "b", "c", "d");
int groupSize = 2;
Collection<Collection<String>> results = Combinatory.generateCombinationsWithRepetitions(elements, groupSize)
```
results contains:

```
[[b, a], [a, c], [a, d], [b, c], [b, d], [c, d], [a, a], [b, b], [c, c], [d, d]]
```


### Combinations of repeated elements

```java
List<String> elements = Arrays.asList("a", "b", "a", "c");
int groupSize = 2;
Collection<Collection<String>> results = Combinatory.generateCombinationsWithRepeatElements(elements, groupSize)
```
results contains:

```
[[b, a], [a, a], [a, c], [b, c]]
```