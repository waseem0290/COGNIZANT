public class Main {
    public static void main(String[] args) {
        TaskManager board = new TaskManager();

        board.addTask(new Task("T1", "Setup Database", "In Progress"));
        board.addTask(new Task("T2", "Write API Endpoints", "Pending"));
        board.addTask(new Task("T3", "Design UI", "Pending"));

        board.traverse();

        System.out.println("\nSearching for T2: " + board.searchTask("T2"));

        System.out.println("\nExecuting deletion...");
        board.deleteTask("T2"); 

        board.traverse();
    }
}