package HackerRankEasyProblems;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
public class RansomNote {


    public static void checkMagazine(List<String> magazine, List<String> note) {
        String flag = "Yes";
     HashMap<String, Integer>  magazineMap = new HashMap<>();
     magazine.forEach(elem->{
         if(magazineMap.containsKey(elem)){
             magazineMap.put(elem, magazineMap.get(elem) + 1);
         }else
         {
             magazineMap.put(elem, 1 );
         }

     });

        for (String s : note) {
            if(magazineMap.containsKey(s)){
                Integer count = magazineMap.get(s);
                if(count == 1 )
                    magazineMap.remove(s);
                else magazineMap.put(s,magazineMap.get(s) - 1 );
            }else
                flag = "No";
        }

        System.out.println(flag);

    }

    public static void main(String[] args) {
        checkMagazine(Arrays.asList("two", "times" ,"three", "is", "not", "four"),
                Arrays.asList("two", "times" ,"two", "is", "four"));
    }
}
