import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);

    static School school = new School();
    static Classroom[] classrooms;
    static Student[] students;

    public static void main(String[] args) {

        howMuchClass();
        addClassroom();

        while (true) {
            menu();
            System.out.print("Prosesi secin: ");
            int proses = sc.nextInt();

            switch (proses) {
                case 1:
                    showAllClass();
                    break;
                case 2:
                    showAllTeacher();
                    break;
                case 3:
                    showAllStudent();
                    break;
                case 4:
                    getClassIdShowStudent();
                    break;
                case 5:
                    addTeacher();
                    break;
                case 6:
                    addStudent();
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("1 -Butun Sinifleri gor.");
        System.out.println("2 -Butun Mellimleri gor.");
        System.out.println("3 -Butun Telebeleri gor.");
        System.out.println("4 -ClassId-ye gore sinifdeki telebeleri gor.");
        System.out.println("5 -Sinife mellim elave et.");
        System.out.println("6 -Sinife telebe elave et.");
    }

    public static void howMuchClass() {
        System.out.print("Nece sinif daxil edilsin: ");
        int classCount = sc.nextInt();
        sc.nextLine();
        classrooms = new Classroom[classCount];

    }

    public static void addClassroom() {
        for (int i = 0; i < classrooms.length; i++) {
            if (classrooms[i] == null) {
                System.out.print("Sinifin adini daxil edin: ");
                String className = sc.nextLine();
                System.out.print("Sinifin unique Id sini daxil edin: ");
                int uniqueId = sc.nextInt();
                sc.nextLine();

                classrooms[i] = new Classroom(className, uniqueId);
            }
        }
    }

    public static void addTeacher() {

        System.out.print("Mellim elave edeceyiniz sinifin Id-sini secin: ");
        int chooseClass = sc.nextInt();
        sc.nextLine();
        for (Classroom classroom : classrooms) {
            if (classroom.uniqueId == chooseClass) {

                System.out.print("Mellimin adini daxil edin: ");
                String teacherName = sc.nextLine();
                System.out.print("Mellimin soyadini daxil edin: ");
                String teacherSurname = sc.nextLine();
                System.out.print("Mellimin yasini daxil edin: ");
                int teacherAge = sc.nextInt();
                System.out.print("Mellimin maasini daxil edin: ");
                int teacherSalary = sc.nextInt();

                Teacher teacher = new Teacher(teacherName, teacherSurname, teacherAge, teacherSalary);

                classroom.teacher = teacher;
            } else
                System.out.println("Sinif tapilmadi.");
        }
    }

    public static void addStudent() {

        System.out.print("Telebe elave edeceyiniz sinifin Id-sini secin: ");
        int chooseClass = sc.nextInt();
        sc.nextLine();
        for (Classroom classroom : classrooms) {
            if (classroom.uniqueId == chooseClass) {

                System.out.print("Nece telebe elave etmek isteyirsiz? ");
                int studentCount = sc.nextInt();
                sc.nextLine();
                students = new Student[studentCount];

                for (int i = 0; i < studentCount; i++) {
                    System.out.print("Telebenin adini daxil edin: ");
                    String studentName = sc.nextLine();
                    System.out.print("Telebenin soyadini daxil edin: ");
                    String studentSurname = sc.nextLine();
                    System.out.print("Telebenin yasini daxil edin: ");
                    int studentAge = sc.nextInt();
                    System.out.print("Telebenin balini daxil edin: ");
                    int studentPoint = sc.nextInt();
                    sc.nextLine();
                    students[i] = new Student(studentName, studentSurname, studentAge, studentPoint);
                }
            } else
                System.out.println("Sinif tapilmadi.");
        }
    }

    public static void showAllClass() {
        for (Classroom classroom : classrooms) {
            if (classroom != null) {
                System.out.println(classroom.toString());
            }
        }
    }

    public static void showAllTeacher() {
        for (Classroom classroom : classrooms) {
            if (classroom != null && classroom.teacher != null) {
                System.out.println(classroom.teacher.toString());
            }
        }
    }

    public static void showAllStudent() {
        for (Classroom classroom : classrooms) {
            if (classroom != null && students != null) {
                for (var st : students) {
                    System.out.println(st.toString());
                }
            }
        }
    }

    public static void getClassIdShowStudent() {
        System.out.print("Sinifin Id-sini daxil edin: ");
        int sinifId = sc.nextInt();
        for (Classroom classroom : classrooms) {
            if (classroom != null && students != null && classroom.uniqueId == sinifId) {
                for (var st : students) {
                    System.out.println(st.toString());
                }
            }
        }
    }
}