package com.victorolmos.combinatory4j.variations;

import com.victorolmos.combinatory4j.Combinatory;
import com.victorolmos.combinatory4j.TestUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class VariationsWithRepetitionsGeneratorTest {

    @Test
    public void generate() {
        final HashSet<String> elements = new HashSet<>();
        Collections.addAll(elements, "a", "b", "c", "d");
        final List<String> expectedResult = Arrays.asList("aa", "ab", "ac", "ad", "ba", "bb", "bc", "bd", "ca", "cb", "cc", "cd", "da", "db", "dc", "dd");

        final List<String> result = TestUtil.joinCollection(Combinatory.generateVariationsWithRepetitions(elements, 2));
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