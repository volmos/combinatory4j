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