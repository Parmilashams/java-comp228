public class Person {
    // declaring instance variables
    private String name;
    private int age;
    private int height;

    // parameterized constructor
    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    // default constructor
    public Person() {
        this.name = "unknown";
        this.age = 0;
        this.height = 0;
    }

    // setters or mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // getters or accessors
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }
}
