package main;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        Container<Integer> intList = new Container<>();
        System.out.println("Enter the size of intList: ");
        int size = scan.nextInt();
        for (int i = 0; i < size; ++i)
            intList.Add(random.nextInt(100));

        Container<String> strList = new Container<>();
        strList.Add("Hello");
        strList.Add("World");

        System.out.println("Int List size: " + intList.size());
        intList.PrintList();

        System.out.println("Str List size: " + strList.size());
        strList.PrintList();

        while (true){
            System.out.println("1. AddByPosition");
            System.out.println("2. RemoveByPosition");
            System.out.println("3. RemoveByValue");
            System.out.println("4. GetValue");
            System.out.println("5. RemoveAll");
            System.out.println("0. Close program");

            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter value and position to add new element in intList: ");
                    int val = scan.nextInt();
                    int id = scan.nextInt();
                    intList.AddByPosition(val, id);

                    System.out.println("Int List size: " + intList.size());
                    intList.PrintList();
                    break;
                case 2:
                    System.out.println("Enter position to remove: ");
                    int pos = scan.nextInt();
                    System.out.println("Removed value: " + intList.RemoveByPosition(pos));

                    System.out.println("Int List size: " + intList.size());
                    intList.PrintList();
                    break;
                case 3:
                    System.out.println("Enter value to remove: ");
                    val = scan.nextInt();
                    intList.RemoveByValue(val);

                    System.out.println("Int List size: " + intList.size());
                    intList.PrintList();
                    break;
                case 4:
                    System.out.println("Enter position to get value: ");
                    pos = scan.nextInt();
                    System.out.println("Got value: " + intList.GetValue(pos));
                    break;
                case 5:
                    intList.RemoveAll();

                    System.out.println("Int List size: " + intList.size());
                    intList.PrintList();
                    break;
                case 0:
                    scan.close();
                    return;
                default:
                    System.out.println("Input error. Please try again.");
                    break;
            }
        }
    }
}