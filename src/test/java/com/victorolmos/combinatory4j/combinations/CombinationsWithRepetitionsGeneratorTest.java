package com.victorolmos.combinatory4j.combinations;

import com.victorolmos.combinatory4j.Combinatory;
import com.victorolmos.combinatory4j.TestUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CombinationsWithRepetitionsGeneratorTest {

    @Test
    public void generate() {
        final HashSet<String> elements = new HashSet<>();
        Collections.addAll(elements, "a", "b", "c", "d");
        final List<String> expectedResult = Arrays.asList("ba", "ac", "ad", "bc", "bd", "cd", "aa", "bb", "cc", "dd");

        final List<String> result = TestUtil.joinCollection(Combinatory.generateCombinationsWithRepetitions(elements, 2));
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