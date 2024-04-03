package abstract_and_interfaces.ducks;

public class Squeek implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Squeek");
    }
}
