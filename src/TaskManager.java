import java.util.*;

public class TaskManager {
    HashMap<Integer, Task> tasks = new HashMap<>();
    int idCounter = 1;

    public void addTask(Task task) {
        task.setId(idCounter);
        tasks.put(idCounter++, task);
    }

    public List<Task> getAllTask() {
        List<Task> list = new ArrayList<>();
        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    public void removeAllTask() {
        tasks.clear();
    }

    public void removeTaskById(Integer id) {
        tasks.remove(id);
    }

    public Task getTask(Integer id) {
        return tasks.get(id);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
        if (task instanceof Subtask) {
            Epic epic = (Epic) getTask(((Subtask) task).getEpic().getId());
            for (int i = 0; i < epic.getSubtasks().size(); i++) {
                if (epic.getSubtasks().get(i).getId() == task.getId()) {
                    epic.getSubtasks().set(i, (Subtask) task);
                }
            }
            updateEpicStatus(task, epic);
        }
    }

    public List<Subtask> getSubtaskByEpic(Epic epic) {
        Epic epic1 = (Epic) tasks.get(epic.getId());
        return epic1.getSubtasks();
    }

    private void updateEpicStatus(Task task, Epic epic) {
        List<Subtask> subtasks = epic.getSubtasks();

        if (subtasks.isEmpty()) {
            task.setStatus(TaskStatus.NEW);
            return;
        }

        int countNew = 0;
        int countDone = 0;

        for (int i = 0; i < subtasks.size(); i++) {
            if (TaskStatus.NEW == subtasks.get(i).getStatus()) {
                countNew++;
            } else if (TaskStatus.DONE == subtasks.get(i).getStatus()) {
                countDone++;
            }
        }

        if (countNew == subtasks.size()) {
            epic.setStatus(TaskStatus.NEW);
        } else if (countDone == subtasks.size()) {
            epic.setStatus(TaskStatus.DONE);
        } else {
            epic.setStatus(TaskStatus.IN_PROGRESS);
        }
    }
}

