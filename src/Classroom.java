import java.util.Arrays;

public class Classroom {
    public String className;
    public int uniqueId;

   public Teacher teacher;

    public Student[] students;


    public Classroom(String className, int uniqueId) {
        this.className = className;
        this.uniqueId = uniqueId;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "className='" + className + '\'' +
                ", uniqueId=" + uniqueId +
                '}';
    }
}
