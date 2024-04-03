package abstract_and_interfaces.ducks;

public class FlyNoWay implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Fly no way");
    }
}
