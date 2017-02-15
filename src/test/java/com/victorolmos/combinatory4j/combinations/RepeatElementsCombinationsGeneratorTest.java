package com.victorolmos.combinatory4j.combinations;

import com.victorolmos.combinatory4j.TestUtil;
import com.victorolmos.combinatory4j.Combinatory;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class RepeatElementsCombinationsGeneratorTest {

    @Test
    public void combinationsFourElementsWithRepetitions() {
        final List<String> elements = Arrays.asList("a", "b", "a", "c");
        final List<String> expectedResult = Arrays.asList("ba", "aa", "ac", "bc");
        testByElementsGroupSizeExpectedResult(elements, 2, expectedResult);
    }

    @Test
    public void combinationsFiveElementsWithRepetitionsAndGroupSizeThree() {
        final List<String> elements = Arrays.asList("a", "b", "a", "c", "a");
        final List<String> expectedResult = Arrays.asList("aba", "abc", "aca", "aaa");
        testByElementsGroupSizeExpectedResult(elements, 3, expectedResult);
    }

    private static void testByElementsGroupSizeExpectedResult(final Collection<String> elements, final int groupSize, final List<String> expectedResult) {
        final List<String> result = TestUtil.joinCollection(Combinatory.generateCombinationsWithRepeatElements(elements, groupSize));
        System.out.println(result);

        for (String combination : result) {
            Assert.assertTrue(TestUtil.listContainsStringCombination(expectedResult, combination));
        }

        for (String combination : expectedResult) {
            Assert.assertTrue(TestUtil.listContainsStringCombination(result, combination));
        }

        Assert.assertEquals(expectedResult.size(), result.size());
    }

}