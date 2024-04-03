package abstract_and_interfaces.ducks;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Duck> ducks = new ArrayList<>();
        ducks.add(new Mallard());
        ducks.add(new Redhead());
        RubberDuck r = new RubberDuck();
        r.flyBehaviour = new FlyAsDrone();
        ducks.add(r);
        Mallard m = new Mallard();
        m.flyBehaviour = new FlyWithDifficulty();
        ducks.add(m);
        ducks.add(new Redhead());
        ducks.add(new DecoyDuck());

        for(Duck duck : ducks) {
            duck.fly();
            duck.quack();
            System.out.println();
        }
    }
}
