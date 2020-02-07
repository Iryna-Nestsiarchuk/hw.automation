package pvt.java;

public class Person extends Human {
    public int age;
    public String name;

    public Person(int age, String name) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, my name is " + name + "!");
    }

    public void smallTalk() {
        sayHello();
        System.out.println("I am " + age + " years old. What a beautiful weather today!");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        if (person.age != person.age) {
            return false;
        }
        if (null == person.name) {
            return (name == person.name);
        } else {
            if (!name.equals(person.name)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (int) (31 * age + ((null == name) ? 0 : name.hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + "age: " + age + ", name: " + name;
    }
}
