package test.interview;

import algorithms.implementation.interview.StringWordsReverse;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Madalin.Colezea on 9/8/2015.
 */
public class StringWordsReverseTest {

    String s = null, r = null;

    @Test
    public void test_reverse_pos(){
        s = "a";
        s = StringWordsReverse.reversePos(s,0, 0);
        Assert.assertTrue(s.equals("a"));
        s = "abcd";
        s = StringWordsReverse.reversePos(s, 0, s.length() - 1);
        Assert.assertTrue(s.equals("dcba"));
        s = StringWordsReverse.reversePos(s, 1, 2);
        Assert.assertTrue(s.equals("dbca"));
        s = "This is a word";
        r = StringWordsReverse.reversePos(s, 0, s.length() - 1);
        Assert.assertTrue(r.equals(new StringBuilder(s).reverse().toString()));

        s = "sdasdasdad   809182jdaljsd  asdkljaldj 9 2e akjdakjdhasdaf wd3";
        r = StringWordsReverse.reversePos(s, 0, s.length() - 1);
        Assert.assertTrue(r.equals(new StringBuilder(s).reverse().toString()));

        r = StringWordsReverse.reversePos(s, 0, 4);
        Assert.assertTrue(r.equals("dsadsasdad   809182jdaljsd  asdkljaldj 9 2e akjdakjdhasdaf wd3"));
    }

    @Test
    public void test_reverse(){
        s = "a";
        r = StringWordsReverse.reverse(s);
        Assert.assertTrue(r.equals(s));

        s = "This";
        r = StringWordsReverse.reverse(s);
        Assert.assertTrue(r.equals("sihT"));

        s = "This is a word";
        r = StringWordsReverse.reverse(s);
        Assert.assertTrue(r.equals("word a is This"));

        s = "a b c d e f g";
        r = StringWordsReverse.reverse(s);
        Assert.assertTrue(r.equals("g f e d c b a"));

        s = "ag bf ce dd ec fb ga";
        r = StringWordsReverse.reverse(s);
        Assert.assertTrue(r.equals("ga fb ec dd ce bf ag"));
    }

}
