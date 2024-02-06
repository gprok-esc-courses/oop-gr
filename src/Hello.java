import java.util.Random;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int a = 1;
        String s = "Hello World!";
        char c = 'A';
        double f = 6.43;
        boolean b = false;

        if(a == 5) {
            System.out.println("a is 5");
        }
        else if(a < 5) {
            System.out.println("a less than 5");
        }
        else {
            System.out.println("a greater than 5");
        }

        if(a == 5 || c == 'A') {

        }

        switch(a) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("other");
                break;
        }

//        for i in range(10):
//            print(i)

        for(int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int i = 0;
        while(i < 10) {
            System.out.println(i);
            i++;
        }

        i = 0;
        do {
            System.out.println(i);
            i++;
        } while(i < 10);

        int [] data = {10, 20, 30, 40, 50};

        for(int p = 0; p < data.length; p++) {
            System.out.println(data[p]);
        }

        for(int value : data) {
            System.out.println(value);
        }

        Random rnd = new Random();
        int r = rnd.nextInt(100);

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
    }
}
