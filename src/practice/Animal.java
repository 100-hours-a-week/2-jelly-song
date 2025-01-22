package practice;

abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void speak();

    public abstract void move();

    // 공통 메서드
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}
