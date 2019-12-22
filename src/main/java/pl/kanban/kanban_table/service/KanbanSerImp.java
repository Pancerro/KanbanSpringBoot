package pl.kanban.kanban_table.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.kanban.kanban_table.model.Task;
import pl.kanban.kanban_table.repository.TaskRepo;

import java.util.List;

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
    public void addTask(Task task) {
        taskRepo.save(task);
    }

    @Override
    public void deleteTask(long id) {
        taskRepo.deleteById(id);
    }
}
