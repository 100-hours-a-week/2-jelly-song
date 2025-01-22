package practice;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Whiskers");
        Animal human = new Human("Jelly");

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(cat);
        animals.add(human);

        for (Animal animal : animals) {
            animal.speak();
            animal.move();
            animal.sleep();
            System.out.println();
        }
    }
}