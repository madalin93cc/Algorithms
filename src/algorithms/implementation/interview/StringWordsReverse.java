package algorithms.implementation.interview;

/**You are given a string.
 * You want to reverse the words inside it.
 * Example “this is a string” –> “string a is this”.
 * Design an algorithm and implement it. You are not allowed to use String.Split().
 * After you are done with the code, test it. What will you test? What tests will you write?
 */
public class StringWordsReverse {

    public static String reversePos(String s, int startPos, int endPos){
//        sanity
        assert s != null: "String null in reversePos";
        if ((startPos > endPos)
                || (startPos < 0)
                || (endPos >= s.length())) throw new IllegalArgumentException("indici gresiti");
        if ((startPos == endPos) || (s.length() == 0))return s;

        String s2 = new String();
        int i = 0;
        while (i < startPos){
            s2 += s.charAt(i++);
        }
        for (i = endPos; i >= startPos; i--){
            s2 += s.charAt(i);
        }
        i = endPos + 1;
        while (i < s.length()){
            s2 += s.charAt(i++);
        }
        return s2;
    }

    public static String reverse(String s){
//        sanity
        if (s == null) throw new IllegalArgumentException("String null");
        if (s.length() <= 1) return s;
        if (s.indexOf(" ") == -1) return reversePos(s, 0, s.length() - 1);
        int i = 0, j;

        s = reversePos(s, 0, s.length() - 1);
        while ((j = s.indexOf(" ", i)) != -1){
            s = reversePos(s, i, j - 1);
            i = j + 1;
        }
        s = reversePos(s, i, s.length() - 1);

        return s;
    }
}
