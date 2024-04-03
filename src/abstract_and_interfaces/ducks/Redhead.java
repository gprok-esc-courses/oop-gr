package abstract_and_interfaces.ducks;

public class Redhead extends Duck {
    public Redhead() {
        super("Redhead");
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new Quack();
    }


}
