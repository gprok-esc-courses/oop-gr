package abstract_and_interfaces.ducks;

public class RubberDuck extends Duck {
    public RubberDuck() {
        super("Rubber");
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Squeek();
    }


}
