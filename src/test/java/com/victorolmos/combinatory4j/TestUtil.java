package com.victorolmos.combinatory4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestUtil {

    public static String join(final Collection<String> collection) {
        String joinString = "";
        for (String element : collection) {
            joinString += element;
        }
        return joinString;
    }

    public static boolean listContainsStringCombination(final List<String> combinationsList, final String combination) {
        for (String onListCombination : combinationsList) {
            if (isEqualStringCombinations(combination, onListCombination)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEqualStringCombinations(final String firstCombination, final String secondCombination) {
        for (int i=0;i<firstCombination.length();i++) {
            final char firstCombinationChar = firstCombination.charAt(i);
            if (numTimesCharacterInString(firstCombination, firstCombinationChar) != numTimesCharacterInString(secondCombination, firstCombinationChar)) {
                return false;
            }
        }
        return firstCombination.length() == secondCombination.length();
    }

    private static int numTimesCharacterInString(final String string, final char character) {
        int count = 0;
        for (int i=0;i<string.length();i++) {
            if (character == string.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static List<String> joinCollection(final Collection<? extends Collection<String>> combinationLists) {
        final ArrayList<String> joinList = new ArrayList<>();
        for (Collection<String> unJoinCombination : combinationLists) {
            joinList.add(join(unJoinCombination));
        }
        return joinList;
    }

}
