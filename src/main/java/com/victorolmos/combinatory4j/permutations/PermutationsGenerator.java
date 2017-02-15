package com.victorolmos.combinatory4j.permutations;

import com.victorolmos.combinatory4j.CombinatoryGenerator;
import com.victorolmos.combinatory4j.util.ImmutableArrayList;
import com.victorolmos.combinatory4j.util.ImmutableHashSet;
import com.victorolmos.combinatory4j.CombinatoryCallback;

import java.util.List;
import java.util.Set;

public class PermutationsGenerator<T>  implements CombinatoryGenerator<T, Set<T>, List<T>> {

    protected ImmutableHashSet<T> elements;
    protected CombinatoryCallback<T, List<T>> callback;

    @Override
    public void setElements(Set<T> elements) {
        this.elements = new ImmutableHashSet<>(elements);
    }

    @Override
    public void generate(CombinatoryCallback<T, List<T>> callback) {
        this.callback = callback;
        generate(new ImmutableArrayList<T>(), elements);
    }

    protected void generate(final ImmutableArrayList<T> variation, final ImmutableHashSet<T> elements) {
        if (variation.size() == this.elements.size()) {
            callback.onNewGroup(variation);
            return;
        }
        for (T element : elements) {
            final ImmutableArrayList<T> nextVariation = variation.immutableAdd(element);
            final ImmutableHashSet<T> nextVariationElements = elements.immutableRemove(element);
            generate(nextVariation, nextVariationElements);
        }
    }

}
