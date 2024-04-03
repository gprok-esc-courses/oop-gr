package abstract_and_interfaces.ducks;

public class Silent implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("No sound");
    }
}
