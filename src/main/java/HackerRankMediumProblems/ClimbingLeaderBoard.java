package HackerRankMediumProblems;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 */
public class ClimbingLeaderBoard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> output = new ArrayList<>();
        TreeSet<Integer> rankings = new TreeSet<>(Collections.reverseOrder());
        rankings.addAll(ranked);


        for (Integer elem : player) {
            rankings.add(elem);
            List<Integer> list = new ArrayList<>(rankings);
            output.add(list.indexOf(elem) + 1);
        }
        return output;
    }

}
