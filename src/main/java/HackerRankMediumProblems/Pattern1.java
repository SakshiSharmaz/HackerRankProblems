package HackerRankMediumProblems;

/**
 * https://www.hackerrank.com/challenges/printing-pattern-2/problem
 * Print pattern :
 *                             4 4 4 4 4 4 4  
 *                             4 3 3 3 3 3 4   
 *                             4 3 2 2 2 3 4   
 *                             4 3 2 1 2 3 4   
 *                             4 3 2 2 2 3 4   
 *                             4 3 3 3 3 3 4   
 *                             4 4 4 4 4 4 4
 *                             //gets distorted after 9
 *
 */
public class Pattern1 {

   public static void printPattern(int n ){

       int left, right, top, bottom;
       int rc = n*2-1;
       for(int i =0; i <rc; i++){

           for(int j =0; j <rc; j++){

               left = j+1;
               right = rc-j;
               top = i+1;
               bottom = rc-i;

               int min = Math.min(right, left);
               if(top<min)
                   min = top;
               if(bottom<min)
                   min = bottom;

               System.out.printf("%d ", n- min + 1 );


           }

           System.out.print("\n");

       }

   }

    public static void main(String[] args) {
        printPattern(25);
    }

}
