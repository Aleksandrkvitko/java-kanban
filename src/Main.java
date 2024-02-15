import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Epic epic1 = new Epic("epic1","epic1",TaskStatus.NEW,new ArrayList<>());
        Epic epic2 = new Epic("epic2","epic2",TaskStatus.NEW,new ArrayList<>());

        Subtask subtask1 =new Subtask("subtask1","subtask1",TaskStatus.NEW,epic1);
        Subtask subtask2 =new Subtask("subtask2","subtask2",TaskStatus.NEW,epic1);
        Subtask subtask3 =new Subtask("subtask3","subtask3",TaskStatus.NEW,epic2);

        epic1.getSubtasks().add(subtask1);
        epic1.getSubtasks().add(subtask2);
        epic2.getSubtasks().add(subtask3);

        Task task1 = new Task("task1","task1",TaskStatus.NEW);
        Task task2 = new Task("task2","task2",TaskStatus.NEW);
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(epic1);
        taskManager.addTask(epic2);
        taskManager.addTask(subtask1);
        taskManager.addTask(subtask2);
        taskManager.addTask(subtask3);

        Subtask subtask4 =new Subtask("subtask2","subtask2",6,TaskStatus.DONE,epic1);
        taskManager.updateTask(subtask4);
        System.out.println("subtask");

        System.out.println("  ");
        for (Task task : taskManager.getAllTask()) {
            System.out.println(task);
        }
    }
}
