package HackerRankEasyProblems;

/**
 * https://www.hackerrank.com/challenges/drawing-book/problem
 */
public class DrawingBook {

    public static int pageCount(int n, int p) {


        if (!(p <= n / 2)) {
            //Start from back
            p = n - p + 1;
            if (n % 2 == 0) {
                return p / 2;
            } else {
                if (p % 2 == 0)
                    return p / 2 - 1;
                else
                    return p / 2;
            }
        } else {
            //Start from front
            return p / 2;
        }


    }

    public static int pageCountBetter(int n, int p) {
        //Better Solution :

        int pageTurns = p/2;
        int totalTurns = n/2;
       return   Math.min(pageTurns, totalTurns-pageTurns);


    }


}
