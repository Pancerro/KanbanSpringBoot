package pl.kanban.kanban_table.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.kanban.kanban_table.model.Task;
import pl.kanban.kanban_table.repository.TaskRepo;
import java.util.List;
import java.util.Optional;

@Controller
public class KanbanSerImp implements KanbanService {
    private TaskRepo taskRepo;
    @Autowired
    public KanbanSerImp(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepo.findAll();
    }

    @Override
    public void deleteTask(long id) {
        Optional<Task> deleteTask = taskRepo.findById(id);
        if(deleteTask.isPresent()) taskRepo.deleteById(id);
    }
    @Override
    public void addTask(Task task) {
        Optional<Task> oldTask = taskRepo.findById(task.getId());
        if(oldTask.isPresent()){
            Task updateTask=oldTask.get();
            updateTask.setTaskTitle(task.getTaskTitle());
            updateTask.setTaskTable(task.getTaskTable());
            taskRepo.save(updateTask);
        }
        else taskRepo.save(task);
    }
}
