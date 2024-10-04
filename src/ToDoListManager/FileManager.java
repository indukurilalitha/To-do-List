package ToDoListManager;
import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static void saveToFile(ToDoList todoList, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (Task task : todoList.getTasks()) {
            writer.write(task.getName() + "," + task.isCompleted() + "\n");
        }
        writer.close();
    }

    public static void loadFromFile(ToDoList todoList, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String taskName = parts[0];
            boolean isCompleted = Boolean.parseBoolean(parts[1]);
            Task task = new Task(taskName);
            if (isCompleted) {
                task.markCompleted();
            }
            todoList.addTask(taskName);
        }
        reader.close();
    }
}
