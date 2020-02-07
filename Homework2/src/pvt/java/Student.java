package pvt.java;

public class Student extends Person {
    public String grade;
    public String faculty;

    public Student(int age, String name, String grade, String faculty) {
        super(age, name);
        this.grade = grade;
        this.faculty = faculty;
    }

    @Override
    public void smallTalk() {
        sayHello();
        System.out.println("I am " + age + " years old." + " I love study in Hogwarts! My faculty is " + faculty + "!");
    }

    protected void slogan() {
        System.out.println("Go ahead " + faculty + "! " + "We are the first, " + faculty + "!!!");
    }

    boolean isAdult() {
        int adulthood = 18;
        return age >= adulthood;
    }

    private void openMarauderMap() {
        if (name == "Harry Potter") {
            System.out.println("I solemnly swear I'm planning a prank, and only a prank!");
        } else {
            System.out.println("I'm empty");
        }
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
        if (!super.equals(obj)) {
            return false;
        }
        Student student = (Student) obj;
        if (null == student.grade) {
            return (grade == student.grade);
        } else {
            if (!grade.equals(student.grade)) {
                return false;
            }
        }
        if (null == student.faculty) {
            return (faculty == student.faculty);
        } else {
            if (!faculty.equals(student.faculty)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (int) (31 * super.hashCode() + ((null == faculty) ? 0 : faculty.hashCode()) +
                ((null == grade) ? 0 : grade.hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + "age: " + age + ", name: " + name + ", grade: " + grade + ", faculty: " + faculty;
    }
}
