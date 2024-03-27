package mysql.statics;

public class RunTest {
    public static void main(String[] args) {
        Test x = new Test();
        Test y = new Test();

        x.a = 10;
        x.b = 20;

        y.a = 1;
        y.b = 2;

        Test.b = 5;

        System.out.println(x.b);
    }
}
