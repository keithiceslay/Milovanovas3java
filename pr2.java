package s3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class pr2 {
    public static void main(String[] args) {
        // Пусть дан произвольный список целых чисел, удалить из него чётные числа
        Random rnd = new Random();
        Scanner scan = new Scanner(System.in);
        ArrayList arr = new ArrayList<Integer>();
        System.out.println("How long do you wish your array to be?");
        int k = scan.nextInt();
        for (int i = 0; i < k; i++){
            arr.add(rnd.nextInt());
        }
        System.out.println("New array: " + arr);
        for (int i = 0; i < k; i++){
            Integer b = (Integer) arr.get(i);
            if (b % 2 == 0) {
                arr.remove(i);
                i --;
                k --;
            }
        }
        System.out.println("New array without even numbers: " + arr);
        scan.close();
    }
}
