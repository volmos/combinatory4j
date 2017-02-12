package com.volmos.combinatory4j.combinations;

import com.volmos.combinatory4j.util.ImmutableCollection;
import com.volmos.combinatory4j.util.ImmutableHashSet;

import java.util.Set;

public class CombinationsWithRepetitionsGenerator<T> extends CombinationsGenerator<T>  {

    @Override
    protected void generate(final ImmutableCollection<T> combination, final Set<T> elements) {
        if (combination.size() == groupSize) {
            callback.onNewGroup(combination);
            return;
        }
        ImmutableHashSet<T> elementsLeft = new ImmutableHashSet<>(elements);
        for (T element : elements) {
            final ImmutableCollection<T> newCombination = combination.immutableAdd(element);
            generate(newCombination, elementsLeft);
            elementsLeft = elementsLeft.immutableRemove(element);
        }
    }

}
