package abstract_and_interfaces.ducks;

public class FlyAsDrone implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Flying as Drone");
    }
}
