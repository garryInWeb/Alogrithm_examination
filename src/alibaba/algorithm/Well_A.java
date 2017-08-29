package alibaba.algorithm;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/***
 * 国外进口箱子一件不能超过 2000，假设商品为立方体。
 * 输入：
 *      箱子规格
 *      用户商品数
 *      每件商品的价格，规格
 * 输出：
 *      最小箱子数
 */
public class Well_A {

    private static int MAX_PRICE = 2000;
    public static void main(String[] args) {
        System.out.print("Please Enter your dimension:");
        Scanner in = new Scanner(System.in);
        //Box Object
        int boxLength = in.nextInt();
        int boxWidth = in.nextInt();
        int boxHeight = in.nextInt();
        BoxTemplate boxTemplate = new BoxTemplate(boxLength,boxWidth,boxHeight);

        System.out.print("Please enter numers of goods:");
        int count = in.nextInt();
        int temp = 0;
        System.out.print("Enter every goods's information:");
        Goods[] goodsArrays = new Goods[count];
        while(temp < count){
            int goodsPrice = in.nextInt();
            int goodsLength = in.nextInt();
            int goodsWidth = in.nextInt();
            int goodsHeight = in.nextInt();
            Goods goods = new Goods(goodsPrice,goodsLength,goodsWidth,goodsHeight);
            goodsArrays[temp] = goods;
            temp ++;
        }
        System.out.println( process(goodsArrays,boxTemplate));
    }
    public static int process(Goods[] goodsArray,BoxTemplate boxTemplate){
        int count = 0;
        sort(goodsArray);
        for(int i = 0; i < goodsArray.length; i++){
            if(goodsArray[i] == null)
                continue;
            int minus_volume = boxTemplate.volume - goodsArray[i].volume;
            int temp_price = goodsArray[i].price;
            for(int j = i + 1; j < goodsArray.length; j++){
                if(goodsArray[j].volume < minus_volume){
                    if(temp_price + goodsArray[j].price <= MAX_PRICE){
                        temp_price += goodsArray[j].price;
                        minus_volume -= goodsArray[j].volume;
                        goodsArray[j] = null;
                    }
                }
            }
            count ++;
        }

        return count;
    }
    public static void sort(Goods[] goodsArray){
        for(int i = 0; i < goodsArray.length; i++){
            for(int j = i+1; j < goodsArray.length; j++){
                if(goodsArray[i].volume > goodsArray[j].volume){
                    Goods temp = goodsArray[i];
                    goodsArray[i] = goodsArray[j];
                    goodsArray[j] = temp;
                }
            }
        }

    }
}
class BoxTemplate{
    int length;
    int width;
    int height;
    int volume;

    public BoxTemplate(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = length * width * height;
    }
}
class Goods{
    int length;
    int width;
    int height;
    int volume;
    int price;

    public Goods(int price,int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.price = price;
        volume = length * width * height;
    }
}
