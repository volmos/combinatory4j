package com.victorolmos.combinatory4j;

import com.victorolmos.combinatory4j.combinations.CombinationsWithRepetitionsGenerator;
import com.victorolmos.combinatory4j.combinations.RepeatElementsCombinationsGenerator;
import com.victorolmos.combinatory4j.variations.VariationsGenerator;
import com.victorolmos.combinatory4j.variations.VariationsWithRepetitionsGenerator;
import com.victorolmos.combinatory4j.combinations.CombinationsGenerator;
import com.victorolmos.combinatory4j.permutations.PermutationsGenerator;
import com.victorolmos.combinatory4j.variations.RepeatElementsVariationsGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Class with static methods for calculate different combinatory groups.
 * This methods retunrs the results without use callback.
 * Prevent to use this methods when the number of results groups has very
 * large to reduce memory usage.
 */
public class Combinatory {

    /**
     * Generates permutations of a set of elements
     *
     * @param elements set containig elements to calculate permutations
     * @return the collection of permutations
     */
    public static <T> Collection<List<T>> generatePermutations(final Set<T> elements) {
        final ArrayList<List<T>> permutationsResults = new ArrayList<>();
        final PermutationsGenerator<T> permutationsGenerator = new PermutationsGenerator<>();
        permutationsGenerator.setElements(elements);
        permutationsGenerator.generate(new CombinatoryCallback<T, List<T>>() {
            @Override
            public void onNewGroup(List<T> group) {
                permutationsResults.add(group);
            }
        });
        return permutationsResults;
    }

    /**
     * Generates variations of a set of elements
     *
     * @param elements set containig elements to calculate variations
     * @param groupSize size of result variations
     * @return the collection of variations
     */
    public static <T> Collection<List<T>> generateVariations(final Set<T> elements, final int groupSize) {
        final ArrayList<List<T>> variationsResults = new ArrayList<>();
        final VariationsGenerator<T> variationsGenerator = new VariationsGenerator<>();
        variationsGenerator.setElements(elements);
        variationsGenerator.setGroupSize(groupSize);
        variationsGenerator.generate(new CombinatoryCallback<T, List<T>>() {
            @Override
            public void onNewGroup(List<T> group) {
                variationsResults.add(group);
            }
        });
        return variationsResults;
    }

    /**
     * Generates variations with repetitions of a set of elements
     *
     * @param elements set containig elements to calculate variations
     * @param groupSize size of result variations
     * @return the collection of variations with repetitions
     */
    public static <T> Collection<List<T>> generateVariationsWithRepetitions(final Set<T> elements, final int groupSize) {
        final ArrayList<List<T>> variationsResults = new ArrayList<>();
        final VariationsWithRepetitionsGenerator<T> variations = new VariationsWithRepetitionsGenerator<>();
        variations.setElements(elements);
        variations.setGroupSize(groupSize);
        variations.generate(new CombinatoryCallback<T, List<T>>() {
            @Override
            public void onNewGroup(List<T> group) {
                variationsResults.add(group);
            }
        });
        return variationsResults;
    }

    /**
     * Generates variations of a collection of elements. The collection may have repeated elements
     *
     * @param elements collection containing elements to calculate variations
     * @param groupSize size of result variations
     * @return the collection of variations
     */
    public static <T> Collection<List<T>> generateVariationsWithRepeatElements(final Collection<T> elements, final int groupSize) {
        final ArrayList<List<T>> variationsResults = new ArrayList<>();
        final RepeatElementsVariationsGenerator<T> variationsGenerator = new RepeatElementsVariationsGenerator<>();
        variationsGenerator.setElements(elements);
        variationsGenerator.setGroupSize(groupSize);
        variationsGenerator.generate(new CombinatoryCallback<T, List<T>>() {
            @Override
            public void onNewGroup(List<T> group) {
                variationsResults.add(group);
            }
        });
        return variationsResults;
    }

    /**
     * Generates combinations of a set of elements
     *
     * @param elements set containig elements to calculate combinations
     * @param groupSize size of result combinations
     * @return the collection of combinations
     */
    public static <T> Collection<Collection<T>> generateCombinations(final Set<T> elements, final int groupSize) {
        final ArrayList<Collection<T>> combinationsResults = new ArrayList<>();
        final CombinationsGenerator<T> combinationsGenerator = new CombinationsGenerator<>();
        combinationsGenerator.setElements(elements);
        combinationsGenerator.setGroupSize(groupSize);
        combinationsGenerator.generate(new CombinatoryCallback<T, Collection<T>>() {
            @Override
            public void onNewGroup(Collection<T> group) {
                combinationsResults.add(group);
            }
        });
        return combinationsResults;
    }

    /**
     * Generates combinations with repetitions of a set of elements
     *
     * @param elements set containig elements to calculate combinations
     * @param groupSize size of result combinations
     * @return the collection of combinations with repetitions
     */
    public static <T> Collection<Collection<T>> generateCombinationsWithRepetitions(final Set<T> elements, final int groupSize) {
        final ArrayList<Collection<T>> combinationsResults = new ArrayList<>();
        final CombinationsWithRepetitionsGenerator<T> combinationsWithRepetitionsGenerator = new CombinationsWithRepetitionsGenerator<>();
        combinationsWithRepetitionsGenerator.setElements(elements);
        combinationsWithRepetitionsGenerator.setGroupSize(groupSize);
        combinationsWithRepetitionsGenerator.generate(new CombinatoryCallback<T, Collection<T>>() {
            @Override
            public void onNewGroup(Collection<T> group) {
                combinationsResults.add(group);
            }
        });
        return combinationsResults;
    }

    /**
     * Generates combinations of a collection of elements. The collection may have repeated elements
     *
     * @param elements collection containing elements to calculate combinations
     * @param groupSize size of result combinations
     * @return the collection of combinations
     */
    public static <T> Collection<Collection<T>> generateCombinationsWithRepeatElements(final Collection<T> elements, final int groupSize) {
        final ArrayList<Collection<T>> combinationsResults = new ArrayList<>();
        final RepeatElementsCombinationsGenerator<T> combinationsGenerator = new RepeatElementsCombinationsGenerator<>();
        combinationsGenerator.setElements(elements);
        combinationsGenerator.setGroupSize(groupSize);
        combinationsGenerator.generate(new CombinatoryCallback<T, Collection<T>>() {
            @Override
            public void onNewGroup(Collection<T> group) {
                combinationsResults.add(group);
            }
        });
        return combinationsResults;
    }

}
