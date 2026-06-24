public class Main {
    public static void main(String[] args) {
        Student model = fetchStudentFromDatabase();
        StudentView view = new StudentView();
        
        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("Alice Johnson");
        controller.setStudentGrade("A+");

        controller.updateView();
    }

    private static Student fetchStudentFromDatabase() {
        return new Student("10425", "Alice J.", "B");
    }
}