package pinduoduo.algorithm;

import java.util.Scanner;

/**
 *
 */
public class one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int i = 0;
        candy[] candies = new candy[m];
        while(i < m){
            candies[i] = new candy();
            candies[i].full = scanner.nextInt();
            i++;
        }
        i = 0;
        bear[] bears = new bear[n];
        while(i < n){
            bears[i] = new bear();
            bears[i].fight = scanner.nextInt();
            bears[i].hurry = scanner.nextInt();
            i++;
        }
        for(int j = 0; j < bears.length; j++){
            for(int z=j ; z< bears.length; z++){
                if(bears[j].fight < bears[z].fight){
                    bear temp = bears[j];
                    bears[j] = bears[z];
                    bears[z] = temp;
                }
            }
        }
        for(int j = 0; j < candies.length; j++){
            for(int z = j; z < candies.length; z++) {
                if (candies[j].full < candies[z].full) {
                    candy temp = candies[j];
                    candies[j] = candies[z];
                    candies[z] = temp;
                }
            }
        }
        for(int j = 0; j < bears.length; j++){
            for(int z = 0; z < candies.length; z++){
                if(bears[j].hurry - candies[z].full < 0)
                    continue;
                bears[j].hurry -= candies[z].full;
                candies[z].full = 0;
            }
        }
        for(int j = 0; j < bears.length; j++){
            System.out.println(bears[j].hurry);
        }

    }

}
class bear{
    int fight;
    int hurry;
}
class candy{
    int full;;
}