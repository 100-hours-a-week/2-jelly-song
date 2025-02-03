package practice;

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(name + " says: Meow! Meow!");
    }

    @Override
    public void move() {
        System.out.println(name + " is jumping gracefully.");
    }
}

