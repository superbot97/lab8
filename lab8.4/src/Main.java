public class Main {

    public static void main(String[] args) {

        Learner student = new Student(new Сollective());
        student.study();
        Learner schoolboy = new Schoolboy(new Individual());
        schoolboy.study();
    }
}

abstract class Learner {
    protected Method method;

    public Learner(Method method) {
        this.method = method;
    }

    public abstract void study();
}

class Student extends Learner {

    public Student(Method method) {
        super(method);
    }

    @Override
    public void study() {
        System.out.println("Studying student");
        method.studyMethod();
    }
}

class Schoolboy extends Learner {

    public Schoolboy(Method method) {
        super(method);
    }

    @Override
    public void study() {
        System.out.println("Studying schoolboy");
        method.studyMethod();
    }
}

interface Method {
    void studyMethod();
}

class Individual implements Method {
    @Override
    public void studyMethod() {
        System.out.println("Study by individual");
    }
}

class Group implements Method {
    @Override
    public void studyMethod() {
        System.out.println("Study by group");
    }
}

class Сollective implements Method {
    @Override
    public void studyMethod() {
        System.out.println("Study by collective");
    }
}