package com.volmos.combinatory4j.variations;

import com.volmos.combinatory4j.CombinatoryCallback;
import com.volmos.combinatory4j.CombinatoryGenerator;
import com.volmos.combinatory4j.util.ImmutableArrayList;
import com.volmos.combinatory4j.util.ImmutableCollection;

import java.util.Collection;
import java.util.List;

public class RepeatElementsVariationsGenerator<T> implements CombinatoryGenerator<T, Collection<T>, List<T>> {

    protected ImmutableCollection<T> elements;
    protected int groupSize;
    protected CombinatoryCallback<T, List<T>> callback;

    @Override
    public void setElements(final Collection<T> elements) {
        this.elements = new ImmutableArrayList<>();
        for (T element : elements) {
            this.elements.add(element);
        }
    }

    public void setGroupSize(final int groupSize) {
        this.groupSize = groupSize;
    }

    @Override
    public void generate(final CombinatoryCallback<T, List<T>> callback) {
        this.callback = callback;
        generate(new ImmutableArrayList<T>(), elements);
    }

    private void generate(final ImmutableArrayList<T> variation, final ImmutableCollection<T> elements) {
        if (variation.size() == groupSize) {
            callback.onNewGroup(variation);
            return;
        }
        final ImmutableArrayList<T> usedElements = new ImmutableArrayList<>();
        for (T element : elements) {
            if (!usedElements.contains(element)) {
                final ImmutableArrayList<T> nextVariation = variation.immutableAdd(element);
                final ImmutableCollection<T> nextVariationElements = elements.immutableRemove(element);
                generate(nextVariation, nextVariationElements);
                usedElements.add(element);
            }
        }
    }

}
