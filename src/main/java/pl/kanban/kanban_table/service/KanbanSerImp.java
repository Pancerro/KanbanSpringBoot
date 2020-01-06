package pl.kanban.kanban_table.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import pl.kanban.kanban_table.model.Task;
import pl.kanban.kanban_table.model.User;
import pl.kanban.kanban_table.repository.TaskRepo;
import pl.kanban.kanban_table.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class KanbanSerImp implements KanbanService {
    private TaskRepo taskRepo;
    private UserRepo userRepo;
    @Autowired
    public KanbanSerImp(TaskRepo taskRepo, UserRepo userRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }


    @Override
    public List<Task> getAllTask() {
        return taskRepo.findAll();
    }

    @Override
    public void addTask(Task task) {
        Optional<Task> oldTask = taskRepo.findById(task.getId());
        if(oldTask.isPresent()){
            Task updateTask=oldTask.get();
            updateTask.setTaskTitle(task.getTaskTitle());
            updateTask.setTaskTable(task.getTaskTable());
            updateTask.setTaskText(task.getTaskText());
            updateTask.setTaskPriority(task.getTaskPriority());
            updateTask.setTaskUsername(task.getTaskUsername());
            taskRepo.save(updateTask);
        }
        else taskRepo.save(task);
    }
    @Override
    public void deleteTask(long id) {
        Optional<Task> deleteTask = taskRepo.findById(id);
        if(deleteTask.isPresent()) taskRepo.deleteById(id);
    }

    @Override
    public List<User> getAllUser() {
        return  userRepo.findAll();
    }

    @Override
    public void addUser(User user) {
        Optional<User> oldUser=userRepo.findById(user.getId());
        if(!oldUser.isPresent()){
         userRepo.save(user);
        }
    }

    @Override
    public List<Task> searchTaskByUserName(String username) {
        return taskRepo.findAllByTaskUsername(username);
    }

}
