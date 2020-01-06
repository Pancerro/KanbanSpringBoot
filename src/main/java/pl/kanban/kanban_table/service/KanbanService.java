package pl.kanban.kanban_table.service;
import org.springframework.stereotype.Service;
import pl.kanban.kanban_table.model.Task;
import pl.kanban.kanban_table.model.User;

import java.util.List;
@Service
public interface KanbanService {
    List<Task> getAllTask();
    void addTask(Task task);
    void deleteTask(long id);
    List<User> getAllUser();
    void addUser(User user);
    List<Task> searchTaskByUserName(String username);
}
