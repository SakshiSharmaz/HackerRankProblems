package HackerRankEasyProblems;

public class RepeatedString {

    public static long repeatedString(String s, long n) {

        long numberOfA = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'a')
                numberOfA++;

        }
        long loops = n / s.length();
        numberOfA = numberOfA * loops;
        long remainingCounts = n % s.length();
        for (int i = 0; i < remainingCounts; i++) {
            if (s.charAt(i) == 'a')
                numberOfA++;

        }
        return numberOfA;

    }
}
