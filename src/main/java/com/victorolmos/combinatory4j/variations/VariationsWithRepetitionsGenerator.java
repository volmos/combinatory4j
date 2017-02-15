package com.victorolmos.combinatory4j.variations;

import com.victorolmos.combinatory4j.util.ImmutableArrayList;
import com.victorolmos.combinatory4j.util.ImmutableHashSet;

public class VariationsWithRepetitionsGenerator<T> extends VariationsGenerator<T> {

    @Override
    protected void generate(final ImmutableArrayList<T> variation, final ImmutableHashSet<T> elements) {
        if (variation.size() == groupSize) {
            callback.onNewGroup(variation);
            return;
        }
        for (T element : elements) {
            final ImmutableArrayList<T> newVariation = variation.immutableAdd(element);
            generate(newVariation, elements);
        }
    }

}
