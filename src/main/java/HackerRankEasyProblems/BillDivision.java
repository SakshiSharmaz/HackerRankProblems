package HackerRankEasyProblems;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/bon-appetit/problem
 * * The function accepts following parameters:
 * *  1. INTEGER_ARRAY bill
 * *  2. INTEGER k  an integer representing the zero-based index of the item Anna doesn't eat
 * *  3. INTEGER b  the amount of money that Anna contributed to the bill
 */
public class BillDivision {

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        // Write your code here
        int amount = 0 ;
        for (int i = 0; i < bill.size(); i++) {
            if(i!=k) {
                amount+= bill.get(i);
            }
        }
        int contribution = amount/ 2 ;

        if (contribution == b )
            System.out.println("Bon Appetit");
        else {
            System.out.println(b-contribution);
        }

    }

}
