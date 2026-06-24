class TaskManager {

    private class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskManager() {
        this.head = null;
    }

    public void addTask(Task newTask) {
        Node newNode = new Node(newTask);

        if (head == null) {
            head = newNode;
            System.out.println("Added head task: " + newTask.taskName);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("Added task: " + newTask.taskName);
    }

    public Task searchTask(String targetId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId.equals(targetId)) {
                return current.task; 
            }
            current = current.next; 
        }
        return null; 
    }

    public void traverse() {
        System.out.println("--- Task List ---");
        if (head == null) {
            System.out.println("No pending tasks.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(String targetId) {
        if (head == null) {
            System.out.println("Error: List is empty.");
            return;
        }

        if (head.task.taskId.equals(targetId)) {
            System.out.println("Deleting task: " + head.task.taskName);
            head = head.next; 
            return;
        }
        Node current = head;
        Node previous = null;
        while (current != null && !current.task.taskId.equals(targetId)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Error: Task " + targetId + " not found.");
            return;
        }
        System.out.println("Deleting task: " + current.task.taskName);
        previous.next = current.next; 
    }
}