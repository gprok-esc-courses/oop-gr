package abstract_and_interfaces.ducks;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        super("Decoy");
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Silent();
    }

}
