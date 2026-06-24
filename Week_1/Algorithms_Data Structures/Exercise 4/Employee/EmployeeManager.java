class EmployeeManager {
    private Employee[] roster;
    private int currentSize; 

    public EmployeeManager(int capacity) {
        roster = new Employee[capacity];
        currentSize = 0;
    }

    public void addEmployee(Employee emp) {
        if (currentSize >= roster.length) {
            System.out.println("Error: Array is at max capacity! Cannot add " + emp.name);
            return;
        }
        roster[currentSize] = emp; 
        currentSize++;
        System.out.println("Added: " + emp.name);
    }

    public Employee searchEmployee(String targetId) {
        for (int i = 0; i < currentSize; i++) {
            if (roster[i].employeeId.equals(targetId)) {
                return roster[i];
            }
        }
        return null;
    }

    public void traverse() {
        System.out.println("--- Employee Roster ---");
        if (currentSize == 0) {
            System.out.println("No employees in the system.");
            return;
        }
        for (int i = 0; i < currentSize; i++) {
            System.out.println("[" + i + "] " + roster[i]);
        }
    }

    public void deleteEmployee(String targetId) {
        int targetIndex = -1;

        for (int i = 0; i < currentSize; i++) {
            if (roster[i].employeeId.equals(targetId)) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex == -1) {
            System.out.println("Error: Employee " + targetId + " not found.");
            return;
        }

        System.out.println("Deleting: " + roster[targetIndex].name);

        for (int i = targetIndex; i < currentSize - 1; i++) {
            roster[i] = roster[i + 1];
        }

        roster[currentSize - 1] = null;
        currentSize--;
    }
}