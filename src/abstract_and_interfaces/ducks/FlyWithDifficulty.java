package abstract_and_interfaces.ducks;

public class FlyWithDifficulty implements  FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("Flying with difficulty");
    }
}
