package cars;

public class CarRental {
    public static void main(String[] args) {
        Car a = new Car(101, "AEE9807", -1980.4);
        Car b = new Car(102, "AXZ9011", 12091.1);
        Car c = new Car();
        Car d = c;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
