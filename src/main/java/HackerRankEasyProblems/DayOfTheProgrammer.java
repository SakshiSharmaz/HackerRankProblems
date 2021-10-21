package HackerRankEasyProblems;

/**
 * https://www.hackerrank.com/challenges/day-of-the-programmer/problem
 */
public class DayOfTheProgrammer {

    static String dayOfTheProgrammer(int year){

        /* 1700 \le y \le 2700
         * Gregorian calendar system occurred in 1918
         * */
        if(year == 1918){
            return   "26.09." + year;
        }
        else if(year<1918 && year%4 ==0 ){
            return  "12.09." + year;
        }
        else if((year%4==0 && year%100!=0) || year%400 ==0 ){
         return  "12.09." + year;
        }else {
           return "13.09." + year;
        }

    }

    public static void main(String[] args) {
        System.out.println( dayOfTheProgrammer(2017));
    }

}
