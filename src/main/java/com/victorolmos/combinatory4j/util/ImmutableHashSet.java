package com.victorolmos.combinatory4j.util;

import java.util.*;

public class ImmutableHashSet<T> extends ImmutableCollection<T> implements Set<T> {

    private HashSet<T> hashSet;

    public ImmutableHashSet() {
        hashSet = new HashSet<>();
    }

    public ImmutableHashSet(Collection<? extends T> c) {
        hashSet = new HashSet<>(c);
    }

    @Override
    public ImmutableHashSet<T> immutableAdd(T item) {
        final ImmutableHashSet<T> copy = copySet();
        copy.hashSet.add(item);
        return copy;
    }

    @Override
    public ImmutableHashSet<T> immutableAddAll(Collection<? extends T> collection) {
        final ImmutableHashSet<T> copy = copySet();
        copy.hashSet.addAll(collection);
        return copy;
    }

    @Override
    public ImmutableHashSet<T> immutableRemove(T item) {
        final ImmutableHashSet<T> copy = copySet();
        copy.hashSet.remove(item);
        return copy;
    }

    @Override
    public ImmutableHashSet<T> immutableRemoveAll(Collection<? extends T> collection) {
        final ImmutableHashSet<T> copy = copySet();
        copy.hashSet.removeAll(collection);
        return copy;
    }

    private ImmutableHashSet<T> copySet() {
        final ImmutableHashSet<T> copy = new ImmutableHashSet<>();
        copy.hashSet.addAll(this);
        return copy;
    }

    @Override
    public int size() {
        return hashSet.size();
    }

    @Override
    public boolean isEmpty() {
        return hashSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return hashSet.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return hashSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return hashSet.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return hashSet.toArray(a);
    }

    @Override
    public boolean add(T t) {
        throw new NotImmutableMethodException();
    }

    @Override
    public boolean remove(Object o) {
        throw new NotImmutableMethodException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return hashSet.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new NotImmutableMethodException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new NotImmutableMethodException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new NotImmutableMethodException();
    }

    @Override
    public void clear() {
        throw new NotImmutableMethodException();
    }
}
