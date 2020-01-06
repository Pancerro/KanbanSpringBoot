package pl.kanban.kanban_table.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kanban.kanban_table.model.Task;
import pl.kanban.kanban_table.model.User;
import pl.kanban.kanban_table.service.KanbanService;
import java.util.List;

@RestController
//@CrossOrigin(origins = "https://kanban-springboot.herokuapp.com")
@CrossOrigin(origins = "http://localhost:4200")
public class KanbanApi {
    private KanbanService kanbanService;
    @Autowired
    public KanbanApi(KanbanService kanbanService) {
        this.kanbanService = kanbanService;
    }
    @GetMapping("/kanban")
    public ResponseEntity<List<Task>> getTask() {
        List<Task> taskList = kanbanService.getAllTask();
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }
    @PostMapping("/kanban")
    public ResponseEntity<List<Task>> addTask(@RequestBody Task task) {
        kanbanService.addTask(task);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/kanban/{id}")
    public ResponseEntity<List<Task>> deleteTask(@PathVariable long id) {
        kanbanService.deleteTask(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/kanban/user")
    public ResponseEntity<List<User>> getUser() {
        List<User> userList = kanbanService.getAllUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping("/kanban/user/add")
    public ResponseEntity<List<User>> addUser(@RequestBody User user) {
        kanbanService.addUser(user);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/kanban/user/task")
    public ResponseEntity<List<Task>> getTaskByUser(@RequestBody String  username) {
        List<Task> taskList = kanbanService.searchTaskByUserName(username);
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }
}
