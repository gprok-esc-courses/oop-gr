package java_bultin_classes;


import com.github.javafaker.Faker;

import java.util.ArrayList;

public class ListExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        Faker faker = new Faker();
//        System.out.println(faker.name().fullName());
//        System.out.println(faker.name().bloodGroup());
//        System.out.println(faker.name().title());
//        System.out.println(faker.name().username());
//        System.out.println(faker.educator().course());

        for(int i = 0; i < 50; i++) {
            names.add(faker.name().fullName());
        }

        for(String name : names) {
            System.out.println(name);
        }

//        for(int i = 0; i < names.size(); i++) {
//            System.out.println(names.get(i));
//        }

        ArrayList<Integer> values = new ArrayList<>();
        values.add(6);
        values.add(12);

        for(Integer i : values) {
            System.out.println(i);
        }
    }
}
