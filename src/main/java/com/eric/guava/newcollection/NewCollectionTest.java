package com.eric.guava.newcollection;

import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.HashMultiset;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * User: nanxing
 * Date: 07/11/2017
 */
public class NewCollectionTest {
    List<String> wordDict;

    @Before
    public void before() {
        wordDict = new ArrayList<String>();
        wordDict.add("a");
        wordDict.add("b");
        wordDict.add("c");
        wordDict.add("a");
        wordDict.add("a");
        wordDict.add("a");
    }

    @Test
    public void testHashMultiset() {
        HashMultiset<Object> hashMultiset = HashMultiset.create();

        for (String word : wordDict) {
            hashMultiset.add(word);
        }

        Assert.assertEquals(hashMultiset.count("a"), 4);

        hashMultiset.add("a");

        Assert.assertEquals(hashMultiset.count("a"), 5);

        // 还是一个Set
        Set<Object> set = hashMultiset.elementSet();
        Assert.assertEquals(set.size(), 3);
    }

    public void testConcurrentHashMultiset() {
        ConcurrentHashMultiset<Object> concurrentHashMultiset = ConcurrentHashMultiset.create();




    }
}
