package com.volmos.combinatory4j.util;

import java.util.Collection;

public abstract class ImmutableCollection<T> implements Collection<T> {

    public abstract ImmutableCollection<T> immutableAdd(T item);

    public abstract ImmutableCollection<T> immutableAddAll(Collection<? extends T> collection);

    public abstract ImmutableCollection<T> immutableRemove(T item);

    public abstract ImmutableCollection<T> immutableRemoveAll(Collection<? extends T> collection);

}
