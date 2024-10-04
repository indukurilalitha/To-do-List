package ToDoListManager;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList todoList = new ToDoList();
        String filename = "tasks.txt";

        // Load tasks from file
        try {
            FileManager.loadFromFile(todoList, filename);
            System.out.println("Tasks loaded from file.");
        } catch (IOException e) {
            System.out.println("No existing task file found. Starting fresh.");
        }

        while (true) {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Save and Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    todoList.addTask(taskName);
                    break;
                case 2:
                    todoList.showTasks();
                    break;
                case 3:
                    System.out.print("Enter task index to mark as complete: ");
                    int completeIndex = scanner.nextInt();
                    todoList.markTaskCompleted(completeIndex);
                    break;
                case 4:
                    System.out.print("Enter task index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    todoList.deleteTask(deleteIndex);
                    break;
                case 5:
                    // Save tasks to file
                    try {
                        FileManager.saveToFile(todoList, filename);
                        System.out.println("Tasks saved to file.");
                    } catch (IOException e) {
                        System.out.println("Error saving tasks.");
                    }
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
