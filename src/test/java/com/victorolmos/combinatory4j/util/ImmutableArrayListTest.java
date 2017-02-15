package com.victorolmos.combinatory4j.util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class ImmutableArrayListTest {

    @Test
    public void immutableAdd() throws Exception {
        final ImmutableArrayList<String> immutableArrayList = new ImmutableArrayList<>();
        final ImmutableArrayList<String> immutableArrayList2 = immutableArrayList.immutableAdd("hello");
        final ImmutableArrayList<String> immutableArrayList3 = immutableArrayList2.immutableAdd("world");
        assertEquals(0, immutableArrayList.size());
        assertEquals(1, immutableArrayList2.size());
        assertEquals(2, immutableArrayList3.size());
    }

    @Test
    public void immutableAddAll() throws Exception {
        final ImmutableArrayList<String> immutableArrayList = new ImmutableArrayList<>();
        final ImmutableArrayList<String> immutableArrayList2 = immutableArrayList.immutableAddAll(Arrays.asList("hello", "world"));
        assertEquals(0, immutableArrayList.size());
        assertEquals(2, immutableArrayList2.size());
    }

    @Test
    public void immutableRemove() throws Exception {
        final ImmutableArrayList<String> immutableArrayList = new ImmutableArrayList<>(Arrays.asList("hello", "world"));
        final ImmutableArrayList<String> immutableArrayList2 = immutableArrayList.immutableRemove("world");
        assertEquals(2, immutableArrayList.size());
        assertEquals(1, immutableArrayList2.size());
    }

    @Test
    public void immutableRemoveAll() throws Exception {
        final ImmutableArrayList<String> immutableArrayList = new ImmutableArrayList<>(Arrays.asList("hello", "world"));
        final ImmutableArrayList<String> immutableArrayList2 = immutableArrayList.immutableRemoveAll(Arrays.asList("hello", "world"));
        assertEquals(2, immutableArrayList.size());
        assertEquals(0, immutableArrayList2.size());
    }

}