package com.volmos.combinatory4j.util;

import java.util.*;

public class ImmutableArrayList<T> extends ImmutableCollection<T> implements List<T> {

    private ArrayList<T> arrayList;

    public ImmutableArrayList() {
        arrayList = new ArrayList<>();
    }

    public ImmutableArrayList(Collection<? extends T> c) {
        arrayList = new ArrayList<>(c);
    }

    @Override
    public ImmutableArrayList<T> immutableAdd(T item) {
        final ImmutableArrayList<T> copyList = copyList();
        copyList.arrayList.add(item);
        return copyList;
    }

    @Override
    public ImmutableArrayList<T> immutableAddAll(Collection<? extends T> collection) {
        final ImmutableArrayList<T> copyList = copyList();
        copyList.arrayList.addAll(collection);
        return copyList;
    }

    @Override
    public ImmutableArrayList<T> immutableRemove(T item) {
        final ImmutableArrayList<T> copyList = copyList();
        copyList.arrayList.remove(item);
        return copyList;
    }

    @Override
    public ImmutableArrayList<T> immutableRemoveAll(Collection<? extends T> collection) {
        final ImmutableArrayList<T> copyList = copyList();
        copyList.arrayList.removeAll(collection);
        return copyList;
    }

    private ImmutableArrayList<T> copyList() {
        ImmutableArrayList<T> copy = new ImmutableArrayList<>();
        copy.arrayList.addAll(this);
        return copy;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public T get(int index) {
        return arrayList.get(index);
    }

    @Override
    public T set(int index, T element) {
        throw new NotImmutableMethodException();
    }

    @Override
    public void add(int index, T element) {
        throw new NotImmutableMethodException();
    }

    @Override
    public T remove(int index) {
        throw new NotImmutableMethodException();
    }

    @Override
    public int indexOf(Object o) {
        return arrayList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return arrayList.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return arrayList.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new NotImmutableMethodException();
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return arrayList.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return arrayList.iterator();
    }

    @Override
    public Object[] toArray() {
        return arrayList.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return arrayList.toArray(a);
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
        return arrayList.containsAll(c);
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
