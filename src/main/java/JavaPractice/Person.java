package JavaPractice;

public class Person {
    String name;
    int score;
    public Person( String name, int score) {
        this.name=name;
        this.score= score;
    }
    @Override
    public String toString() {
        return name + " " + score;
    }
}
