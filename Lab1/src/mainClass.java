import java.util.ArrayList;
import java.util.Scanner;

public class mainClass {
    private static boolean threeChecker(int number) {
        return number % 3 == 0;
    }

    private static boolean nineChecker(int number) {
        return number % 9 == 0;
    }

    public static void main(String args[]) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Hello, my friend! This is the first lab");
        System.out.print("For start to working please input num of number you want to put in array: ");
        int num = myObj.nextInt();
        System.out.println("\nNice! Now, let's create our array:");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            System.out.print("Add number: ");
            int newEl = myObj.nextInt();
            arrayList.add(newEl);
        }
        System.out.println("\nOur array:");
        System.out.println(arrayList);
        System.out.println("\nAnd now let's look which elements can be divided by 3 or 9:");
        for (int i = 0; i < num; i++) {
            if (threeChecker(arrayList.get(i))) {
                System.out.println(arrayList.get(i) + ", can be divided by 3");
            }
            if (nineChecker(arrayList.get(i))) {
                System.out.println(arrayList.get(i) + ", can be divided by 9");
            }
        }
    }
}
