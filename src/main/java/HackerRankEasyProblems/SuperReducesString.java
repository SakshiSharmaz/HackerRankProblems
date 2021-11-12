package HackerRankEasyProblems;

import java.util.Objects;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/reduced-string/problem
 * Other ways to solve:
 * - Regex
 * - simple for loop (without recursion)
 */
public class SuperReducesString {


    public static String superReducedStringWithForLoop(String s){

        for(int i =1; i <s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                s = s.substring(0,i-1) + s.substring(i+1);
                i = 0;
            }
        }
        if (s.length() == 0) {
            return "Empty String" ;
        } else {
            return s;
        }

    }

    public static String superReducedString(String s) {
        String previous = "", current = "";
        StringBuilder finalString = new StringBuilder();
        for (String s1 : s.split("")) {
            previous = current;
            current = s1;
            if (!previous.equals("") && Objects.equals(current, previous)) {
                current = "";
            } else if (!previous.equals("") && !Objects.equals(current, previous)) {
                finalString.append(previous);
            }
        }
        if (!current.isEmpty())
            finalString.append(current);

        if (finalString.length() == 0)
            return "Empty String";
        if (checkIfRepeatedStingExists(finalString.toString()))
            return superReducedString(finalString.toString());
        else
            return finalString.toString();

    }

    private static boolean checkIfRepeatedStingExists(String toString) {

        String current = "", previous = "";
        boolean flag = false;
        String[] split = toString.split("");
        for (String s : split) {
            previous = current;
            current = s;
            if (Objects.equals(previous, current)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(superReducedStringWithForLoop("aaabccddd"));
    }


}
