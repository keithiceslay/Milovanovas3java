package s3;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.xml.transform.Templates;
public class pr3 {
    public static void main(String[] args) {
        // Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
        Random rnd = new Random();
        ArrayList arr = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        System.out.println("How long do you wish your array to be?");
        int k = scan.nextInt();
        for (int i = 0; i < k; i++){
            arr.add(rnd.nextInt());
        }
        System.out.println("New array: " + arr);
        int max = (int) arr.get(0);
        int min = (int) arr.get(0);
        int sum = 0;
        for (int i = 0; i < k; i++){
            int temp = (int) arr.get(i);
            if (temp > max) 
                max = temp;
            else if (temp < min)
                min = temp;
            sum += temp;
        }
        int mean = sum / k;
        System.out.printf("Array qualities: \n Min = %d \n Mean = %d \n Max = %d", min, mean, max);
        scan.close();
    }
}
