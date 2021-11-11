package HackerRankEasyProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */
public class SalesByMatch {


    public static int sockMerchant(int n, List<Integer> ar) {
        int pairs = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer elem : ar) {
            if (hashMap.containsKey(elem)) {
                pairs++;
                hashMap.remove(elem);
            } else {
                hashMap.put(elem, 1);
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(sockMerchant(7, Arrays.asList(1,1,3,4,1,5,5)));
    }

}
