package pl.kanban.kanban_table.service;
import pl.kanban.kanban_table.model.Task;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface KanbanService {
    List<Task> getAllTask();
    void addTask(Task task);
    void deleteTask(long id);
}
