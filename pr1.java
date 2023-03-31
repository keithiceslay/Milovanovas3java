package s3;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class pr1 {
    public static void main(String[] args) {
        // Реализовать алгоритм сортировки слиянием
        Random rnd = new Random();
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        System.out.println("How long do you wish your array to be?");
        int k = scan.nextInt();
        for (int i = 0; i < k; i++){
            arr.add(rnd.nextInt(10));
        }
        System.out.println("New array: " + arr);
        ArrayList<Integer> result = sortArrays(arr);
        System.out.println("Sorted array: " + result);
        scan.close();
    }

    static ArrayList<Integer> mergeArrays (ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        int check = arr1.size() + arr2.size();
        ArrayList<Integer> arr3 = new ArrayList<Integer>(arr1.size() + arr2.size());
        int a = 0;
        int b = 0;
        int arr1Comp = arr1.get(0);
        int arr2Comp = arr2.get(0);
        for (int i = 0; i < check; i++) {
            if (i > 1){
                if (a <= i - 1 && arr1.size() > i - a)
                    arr1Comp = (int) arr1.get(i - a);
                if (b <= i - 1 && arr2.size() > i - b)
                    arr2Comp = (int) arr2.get(i - b);
            }
            if (i >= 1){
                if (a == 1 && arr2.size() > 1)
                    arr2Comp = (int) arr2.get(1);
                if (b == 1 && arr1.size() > 1)
                    arr1Comp = (int) arr1.get(1);
            }
            if (a == arr2.size()) {
                arr3.add(arr1Comp);
                b++;
            }
            else if (b == arr1.size()) {
                arr3.add(arr2Comp);
                a++;
            }
            else if (arr1Comp < arr2Comp) {
                arr3.add(arr1Comp);
                b++;
            }
            else if (arr2Comp < arr1Comp) {
                arr3.add(arr2Comp);
                a++;
            }
            else if (arr2Comp == arr1Comp){
                arr3.add(arr2Comp);
                a++;
            }
        }
        System.out.println(arr3);
        return arr3;
    }

    static ArrayList<Integer> sortArrays (ArrayList<Integer> arr) {
        if (arr == null) {
            System.out.println("Массив пустой");
            return arr;
        }
        if (arr.size() < 2)
            return arr;
        
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        for (int i = 0; i < arr.size(); i++){
            int temp = (int) arr.get(i);
            if (i < arr.size()/2)
                arr1.add(temp);
            else 
                arr2.add(temp);
        }
        arr1 = sortArrays(arr1);
        arr2 = sortArrays(arr2);

        return mergeArrays(arr1, arr2);
    }
}
