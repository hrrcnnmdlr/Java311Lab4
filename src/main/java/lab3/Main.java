package lab3;

import lab3.Class.Dog;
import lab3.Class.Duck;
import lab3.Class.Wolf;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        Dog mom = new Dog.Builder().withName("Nataly").withAge(11).withSex("female").isMongrel(false).build();
        Dog dad = new Dog.Builder().withName("Fred").withAge(12).withSex("male").isMongrel(false).build();
        Dog son = new Dog.Builder().withName("Fred").withAge(1).withSex("male").isMongrel(false).
                withParents(Arrays.asList(mom, dad)).build();

        Duck momDuck = new Duck.Builder().withName("Mary").withAge(7).withSex("female").build();
        Duck dadDuck = new Duck.Builder().withName("Donald").withAge(9).withSex("male").build();
        Duck sonDuck = new Duck.Builder().withName("Scrudge").withAge(5).withSex("male").
                withParents(Arrays.asList(momDuck, dadDuck)).build();

        Wolf momWolf = new Wolf.Builder().withName("Virginia").withAge(15).withSex("female").build();
        Wolf dadWolf = new Wolf.Builder().withName("Sam").withAge(14).withSex("male").build();
        Wolf daughterWolf = new Wolf.Builder().withName("Laura").withAge(3).withSex("female").
                withParents(Arrays.asList(momWolf, dadWolf)).build();

        System.out.println(son);
        son.sortDogParentsByName();
        System.out.println(son);

        System.out.println(daughterWolf);
        daughterWolf.sortParentsByAge();
        System.out.println(daughterWolf);

        System.out.println(sonDuck);
        sonDuck.sortParentsByAgeComparator();
        System.out.println(sonDuck);
    }
}
