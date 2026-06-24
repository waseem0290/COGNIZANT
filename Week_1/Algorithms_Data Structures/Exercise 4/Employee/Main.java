public class Main {
    public static void main(String[] args) {
        EmployeeManager hrSystem = new EmployeeManager(5);

        hrSystem.addEmployee(new Employee("E01", "Alice", "Developer", 80000));
        hrSystem.addEmployee(new Employee("E02", "Bob", "Manager", 95000));
        hrSystem.addEmployee(new Employee("E03", "Charlie", "Analyst", 65000));

        hrSystem.traverse();

        Employee found = hrSystem.searchEmployee("E02");
        System.out.println("\nSearch Result: " + (found != null ? found.name : "Not Found"));

        System.out.println("\nInitiating termination protocol...");
        hrSystem.deleteEmployee("E02"); 

        hrSystem.traverse();
    }
}