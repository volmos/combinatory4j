package com.victorolmos.combinatory4j.combinations;

import com.victorolmos.combinatory4j.CombinatoryGenerator;
import com.victorolmos.combinatory4j.util.ImmutableArrayList;
import com.victorolmos.combinatory4j.CombinatoryCallback;
import com.victorolmos.combinatory4j.util.ImmutableCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RepeatElementsCombinationsGenerator<T> implements CombinatoryGenerator<T, Collection<T>, Collection<T>> {

    protected Collection<T> elements;
    protected int groupSize;
    protected CombinatoryCallback<T, Collection<T>> callback;

    @Override
    public void setElements(Collection<T> elements) {
        this.elements = new ArrayList<>();
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

    protected void generate(final ImmutableCollection<T> combination, final Collection<T> elements) {
        if (combination.size() == groupSize) {
            callback.onNewGroup(combination);
            return;
        }
        ImmutableArrayList<T> elementsLeft = new ImmutableArrayList<>(elements);
        for (T element : elements) {
            if (elementsLeft.contains(element)){
                final ImmutableCollection<T> newCombination = combination.immutableAdd(element);
                elementsLeft = elementsLeft.immutableRemove(element);
                generate(newCombination, elementsLeft);
                elementsLeft = elementsLeft.immutableRemoveAll(Collections.singleton(element));
            }
        }
    }

}