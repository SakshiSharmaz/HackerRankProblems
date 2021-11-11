package HackerRankEasyProblems;

import java.util.List;

public class JumpingOnTheClouds {

    public static int jumpingOnClouds(List<Integer> c) {
            int jumps = 0;

            for (int i = 0; i < c.size(); i++) {

                if ( i+2 < c.size() && c.get(i + 2) == 0) {
                    i++;
                }
                jumps++;

            }
            return jumps-1;
    }
}
