package ru.yandex.practicum.tasktracker;

import ru.yandex.practicum.tasktracker.realization.TaskManager;
import ru.yandex.practicum.tasktracker.status.TaskStatus;
import ru.yandex.practicum.tasktracker.typesoftasks.Epic;
import ru.yandex.practicum.tasktracker.typesoftasks.Subtask;
import ru.yandex.practicum.tasktracker.typesoftasks.Task;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Epic epic1 = new Epic("epic1","epic1",1, TaskStatus.NEW,new ArrayList<>());
        Epic epic2 = new Epic("epic2","epic2",2,TaskStatus.NEW,new ArrayList<>());

        Subtask subtask1 =new Subtask("subtask1","subtask1",3,TaskStatus.NEW,epic1);
        Subtask subtask2 =new Subtask("subtask2","subtask2",4,TaskStatus.NEW,epic1);
        Subtask subtask3 =new Subtask("subtask3","subtask3",5,TaskStatus.NEW,epic2);

        epic1.getSubtasks().add(subtask1);
        epic1.getSubtasks().add(subtask2);
        epic2.getSubtasks().add(subtask3);

        Task task1 = new Task("task1","task1",6,TaskStatus.NEW);
        Task task2 = new Task("task2","task2",7,TaskStatus.NEW);
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addEpic(epic1);
        taskManager.addEpic(epic2);
        taskManager.addSubtask(subtask1);
        taskManager.addSubtask(subtask2);
        taskManager.addSubtask(subtask3);

        Subtask subtask4 = new Subtask("subtask2","subtask2",4,TaskStatus.DONE,epic1);
        taskManager.updateSubtask(subtask4);
        System.out.println("subtask");

        System.out.println("  ");
        for (Task task : taskManager.getTasks()) {
            System.out.println(task);
        }
        for (Subtask task : taskManager.getSubtasks()) {
            System.out.println(task);
        }
        for (Epic task : taskManager.getEpics()) {
            System.out.println(task);
        }
    }
}
