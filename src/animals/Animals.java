package animals;

import java.util.ArrayList;

public class Animals {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Duck("Donald"));
        animals.add(new Cat("Sylvester"));
        animals.add(new Dog("Pluto"));
        animals.add(new Snake("Diamomd"));

        for(Animal a : animals) {
            a.sound();
        }
    }
}
