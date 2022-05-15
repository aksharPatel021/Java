/**
 * This class is the new quacking behaviour for ducks.
 * 
 * @Assignment1
 * 
 * @author (Akshar Patel: 3090870)
 */
//Italk Implementing Quackbehavior
public class Italk implements QuackBehavior {
    //Overriding abstract method quack() in QuackBehavior.
    public void quack() {
        //Simply printing ...talking.
        System.out.println("I am...talking.");
    }
}