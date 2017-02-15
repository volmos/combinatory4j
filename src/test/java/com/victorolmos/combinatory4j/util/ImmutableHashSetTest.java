package com.victorolmos.combinatory4j.util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class ImmutableHashSetTest {

    @Test
    public void immutableAdd() throws Exception {
        final ImmutableHashSet<String> immutableHashSet = new ImmutableHashSet<>();
        final ImmutableHashSet<String> immutableHashSet2 = immutableHashSet.immutableAdd("hello");
        final ImmutableHashSet<String> immutableHashSet3 = immutableHashSet2.immutableAdd("world");
        assertEquals(0, immutableHashSet.size());
        assertEquals(1, immutableHashSet2.size());
        assertEquals(2, immutableHashSet3.size());
    }

    @Test
    public void immutableAddAll() throws Exception {
        final ImmutableHashSet<String> immutableHashSet = new ImmutableHashSet<>();
        final ImmutableHashSet<String> immutableHashSet2 = immutableHashSet.immutableAddAll(Arrays.asList("hello", "world"));
        assertEquals(0, immutableHashSet.size());
        assertEquals(2, immutableHashSet2.size());
    }

    @Test
    public void immutableRemove() throws Exception {
        final ImmutableHashSet<String> immutableHashSet = new ImmutableHashSet<>(Arrays.asList("hello", "world"));
        final ImmutableHashSet<String> immutableHashSet2 = immutableHashSet.immutableRemove("world");
        assertEquals(2, immutableHashSet.size());
        assertEquals(1, immutableHashSet2.size());
    }

    @Test
    public void immutableRemoveAll() throws Exception {
        final ImmutableHashSet<String> immutableHashSet = new ImmutableHashSet<>(Arrays.asList("hello", "world"));
        final ImmutableHashSet<String> immutableHashSet2 = immutableHashSet.immutableRemoveAll(Arrays.asList("hello", "world"));
        assertEquals(2, immutableHashSet.size());
        assertEquals(0, immutableHashSet2.size());
    }

}