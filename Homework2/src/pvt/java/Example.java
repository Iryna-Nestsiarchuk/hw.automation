package pvt.java;

public class Example {
    public static void main(String[] args) {
        Person person = new Person(23, "Iryna");
        person.sayHello();
        person.move();
        person.smallTalk();
        Student harry = new Student(18, "Harry Potter", "seventh", "Griffindor");
        Student harryClone = new Student(18, "Harry Potter", "seventh", "Griffindor");
        Student malfoy = new Student(11, "Draco Malfoy", "first", "Slytherin");
        harry.sayHello();
        harry.smallTalk();
        harry.slogan();
        System.out.println(harry.isAdult() ? "I'm an adult. Please give me some butterbeer!" :
                "I'm not an adult. Please give me a chocolate Dambledor!");
        malfoy.sayHello();
        malfoy.smallTalk();
        malfoy.slogan();
        System.out.println(harry.equals(malfoy));
        System.out.println(harry.equals(harryClone));
        System.out.println(harry.hashCode());
        System.out.println(harry.toString());
    }
}
