package pvt.java;

public abstract class Human implements ICreature {
    public static final int NUMBER_OF_LIMBS = 4;

    @Override
    public void move() {
        System.out.println("I am moving using all my " + NUMBER_OF_LIMBS + " limbs!");
    }

    public abstract void sayHello();
}
