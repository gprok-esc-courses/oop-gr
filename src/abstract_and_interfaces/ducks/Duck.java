package abstract_and_interfaces.ducks;

public class Duck {
    protected String breed;
    protected FlyBehaviour flyBehaviour;
    protected QuackBehaviour quackBehaviour;

    public Duck(String breed) {
        this.breed = breed;
    }

    public void fly() {
        System.out.print(breed + " ");
        flyBehaviour.fly();
    }

    public void quack() {
        System.out.print(breed + " ");
        quackBehaviour.quack();
    }
}
