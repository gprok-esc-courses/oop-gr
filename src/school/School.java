package school;

public class School {
    public static void main(String[] args) {
        Person p = new Student(1, "Mike",
                "mike@school.test", "Computing");

        System.out.println(p);

        p = new Instructor(2, "John", "john@sch.test");
        System.out.println(p);
    }
}
