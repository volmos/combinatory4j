package com.victorolmos.combinatory4j.variations;

import com.victorolmos.combinatory4j.Combinatory;
import com.victorolmos.combinatory4j.TestUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class RepeatElementsVariationsGeneratorTest {

    @Test
    public void variations_4_2_1() {
        final List<String> elements = Arrays.asList("a", "b", "a", "c");
        final List<String> expectedResult = Arrays.asList("ab", "aa", "ac", "ba", "bc", "ca", "cb");
        testByElementsGroupSizeExpectedResult(elements, 2, expectedResult);
    }

    @Test
    public void variations_5_3_2() {
        final List<String> elements = Arrays.asList("a", "b", "a", "c", "a");
        final List<String> expectedResult = Arrays.asList("aba", "abc", "aab", "aac", "aaa", "acb", "aca", "baa", "bac", "bca", "cab", "caa", "cba");
        testByElementsGroupSizeExpectedResult(elements, 3, expectedResult);
    }

    private static void testByElementsGroupSizeExpectedResult(final Collection<String> elements, final int groupSize, final List<String> expectedResult) {
        final List<String> result = TestUtil.joinCollection(Combinatory.generateVariationsWithRepeatElements(elements, groupSize));
        System.out.println(result);

        for (String variation : result) {
            Assert.assertTrue(expectedResult.contains(variation));
        }

        for (String variation : expectedResult) {
            Assert.assertTrue(result.contains(variation));
        }

        Assert.assertEquals(expectedResult.size(), result.size());
    }

}