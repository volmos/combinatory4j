package com.volmos.combinatory4j.combinations;

import com.volmos.combinatory4j.CombinatoryCallback;
import com.volmos.combinatory4j.CombinatoryGenerator;
import com.volmos.combinatory4j.util.ImmutableArrayList;
import com.volmos.combinatory4j.util.ImmutableCollection;
import com.volmos.combinatory4j.util.ImmutableHashSet;

import java.util.*;

public class CombinationsGenerator<T> implements CombinatoryGenerator<T, Set<T>, Collection<T>> {

    protected Set<T> elements;
    protected int groupSize;
    protected CombinatoryCallback<T, Collection<T>> callback;

    @Override
    public void setElements(Set<T> elements) {
        this.elements = new HashSet<>();
        for (T element : elements) {
            this.elements.add(element);
        }
    }

    public void setGroupSize(final int groupSize) {
        this.groupSize = groupSize;
    }

    @Override
    public void generate(CombinatoryCallback<T, Collection<T>> callback) {
        this.callback = callback;
        generate(new ImmutableArrayList<T>(), elements);
    }

    protected void generate(final ImmutableCollection<T> combination, final Set<T> elements) {
        if (combination.size() == groupSize) {
            callback.onNewGroup(combination);
            return;
        }
        ImmutableHashSet<T> elementsLeft = new ImmutableHashSet<>(elements);
        for (T element : elements) {
            final ImmutableCollection<T> newCombination = combination.immutableAdd(element);
            elementsLeft = elementsLeft.immutableRemove(element);
            generate(newCombination, elementsLeft);
        }
    }

}
