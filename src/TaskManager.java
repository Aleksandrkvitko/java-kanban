import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final HashMap<Integer, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void addSubtask(Subtask task) {
        tasks.put(task.getId(), task);
    }

    public void addEpic(Epic task) {
        tasks.put(task.getId(), task);
    }

    public List<Task> getAllTask() {
        return new ArrayList<>(tasks.values());
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

    public void updateSubtask(Subtask subtask) {
        tasks.put(subtask.getId(), subtask);
        Epic epic = (Epic) getTask(subtask.getEpic().getId());
        for (int i = 0; i < epic.getSubtasks().size(); i++) {
            if (epic.getSubtasks().get(i).getId() == subtask.getId()) {
                epic.getSubtasks().set(i, subtask);
            }
        }
        updateEpic(epic);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateEpic(Epic epic) {
        tasks.put(epic.getId(), epic);
        epic.setStatus(epicGetStatus(epic));
    }

    public List<Subtask> getSubtaskByEpic(Epic epic) {
        Epic epic1 = (Epic) tasks.get(epic.getId());
        return epic1.getSubtasks();
    }

    public TaskStatus epicGetStatus(Epic epic){
        List<Subtask> subtasks = epic.getSubtasks();
        if (subtasks.isEmpty()) {
            return TaskStatus.NEW;
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
            return TaskStatus.NEW;
        } else if (countDone == subtasks.size()) {
            return TaskStatus.DONE;
        } else {
            return TaskStatus.IN_PROGRESS;
        }
    }
}