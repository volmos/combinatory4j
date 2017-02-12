package com.volmos.combinatory4j.variations;

import com.volmos.combinatory4j.Combinatory;
import com.volmos.combinatory4j.TestUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class VariationsGeneratorTest {

    @Test
    public void variations_4_2_0() {
        final HashSet<String> elements = new HashSet<>();
        Collections.addAll(elements, "a", "b", "c", "d");
        final List<String> expectedResult = Arrays.asList("ab", "ac", "ad", "ba", "bc", "bd", "ca", "cb", "cd", "da", "db", "dc");
        testByElementsGroupSizeExpectedResult(elements, 2, expectedResult);
    }

    @Test
    public void variations_4_3_0() {
        final HashSet<String> elements = new HashSet<>();
        Collections.addAll(elements, "a", "b", "c", "d");
        final List<String> expectedResult = Arrays.asList("abc", "abd", "acb", "acd", "adb", "adc", "bac", "bad", "bca", "bcd", "bda", "bdc", "cab", "cad", "cba", "cbd", "cda", "cdb", "dab", "dac", "dba", "dbc", "dca", "dcb");
        testByElementsGroupSizeExpectedResult(elements, 3, expectedResult);
    }

/*   @Test
    public void variations_4_2_1() {
        final List<String> expectedResult = Arrays.asList("ab", "aa", "ac", "ba", "bc", "ca", "cb");
        final List<String> elements = Arrays.asList("a", "b", "a", "c");
        testByElementsGroupSizeExpectedResult(elements, 2, expectedResult);
    }

    @Test
    public void variations_5_3_2() {
        final List<String> expectedResult = Arrays.asList("aba", "abc", "aab", "aac", "aaa", "acb", "aca", "baa", "bac", "bca", "cab", "caa", "cba");
        final List<String> elements = Arrays.asList("a", "b", "a", "c", "a");
        testByElementsGroupSizeExpectedResult(elements, 3, expectedResult);
    }
*/
    private static void testByElementsGroupSizeExpectedResult(final Set<String> elements, final int groupSize, final List<String> expectedResult) {
        final List<String> result = TestUtil.joinCollection(Combinatory.generateVariations(elements, groupSize));
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