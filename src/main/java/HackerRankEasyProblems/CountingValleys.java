package HackerRankEasyProblems;

/**
 * https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&page=42031&h_r=next-challenge&h_v=zen
 */
public class CountingValleys {

    public static int countingValleys(int steps, String path) {
        int currentLevel = 0;
        int valleys = 0;
        for (int i = 0; i < path.length(); i++) {

            char elem = path.charAt(i);
            if (currentLevel == -1 && elem == 'U') {
                valleys++;
            }
            if (elem == 'D')
                currentLevel -= 1;
            else currentLevel += 1;

        }
        return valleys;
    }
}
