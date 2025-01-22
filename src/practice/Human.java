package practice;

class Human extends Animal {
    public Human(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(name + " says: Hello! How are you?");
    }

    @Override
    public void move() {
        System.out.println(name + " is walking.");
    }
}
