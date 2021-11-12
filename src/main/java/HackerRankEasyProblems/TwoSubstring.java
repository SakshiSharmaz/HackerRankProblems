package HackerRankEasyProblems;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://www.hackerrank.com/challenges/two-strings/problem
 */
public class TwoSubstring {

    public static String twoStrings(String s1, String s2) {
            String flag = "NO";
            HashSet<String> s1Set = new HashSet<>();
            for (String s : s1.split("")) {
                s1Set.add(s);
            }

            for (String s : s2.split("")) {
                if (s1Set.contains(s)) {
                    flag = "YES";
                    break;
                }
            }

            return flag;
    }


}
