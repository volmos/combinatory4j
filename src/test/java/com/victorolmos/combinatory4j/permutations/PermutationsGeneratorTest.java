package com.victorolmos.combinatory4j.permutations;

import com.victorolmos.combinatory4j.Combinatory;
import com.victorolmos.combinatory4j.TestUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class PermutationsGeneratorTest {

    @Test
    public void generate() {
        final HashSet<String> elements = new HashSet<>();
        Collections.addAll(elements, "a", "b", "c");
        final List<String> expectedResult = Arrays.asList("abc", "bca", "cab", "acb", "bac", "cba");
        final List<String> result = TestUtil.joinCollection(Combinatory.generatePermutations(elements));
        System.out.println(result);

        for (String permutation : result) {
            Assert.assertTrue(expectedResult.contains(permutation));
        }

        for (String permutation : expectedResult) {
            Assert.assertTrue(result.contains(permutation));
        }

        Assert.assertEquals(expectedResult.size(), result.size());
    }

}