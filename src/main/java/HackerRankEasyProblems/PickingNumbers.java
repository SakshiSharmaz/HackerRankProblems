package HackerRankEasyProblems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/picking-numbers/problem
 */
public class PickingNumbers {

    public static int pickingNumbers(List<Integer> a) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        TreeSet<Integer> numberSet = new TreeSet<>();
        a.forEach(elem -> {

            if (numbers.containsKey(elem)) {

                numbers.put(elem, numbers.get(elem) + 1);

            } else {
                numbers.put(elem, 1);
            }
            numberSet.add(elem);
        });

        if (numberSet.size() == 1)
            return a.size();

        int max = 0;
        Iterator<Integer> itr = numberSet.iterator();
        int current = 0;
        int previous;
        int count;

        if (itr.hasNext())
            current = itr.next();
        while (itr.hasNext()) {
            previous = current;
            current = itr.next();
            if (Math.abs(previous - current) < 2) {
                count = numbers.get(current) + numbers.get(previous);
                if (max < count)
                    max = count;

            }
            int currentCount = numbers.get(current);
            if (max < currentCount)
                max = currentCount;
        }
        return max;

    }




}
