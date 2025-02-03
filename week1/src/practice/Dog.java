package practice;

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(name + " says: Woof! Woof!");
    }

    @Override
    public void move() {
        System.out.println(name + " is running happily.");
    }
}
