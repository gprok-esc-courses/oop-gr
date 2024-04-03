package abstract_and_interfaces.ducks;

public class Mallard extends Duck {
    public Mallard() {
        super("Mallard");
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new Quack();
    }


}
