package pl.kanban.kanban_table.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kanban.kanban_table.model.Task;
import pl.kanban.kanban_table.service.KanbanService;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://kanban-springboot.herokuapp.com")
//@CrossOrigin(origins = "http://localhost:4200")
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
    public void addTask(@RequestBody Task task) {
    kanbanService.addTask(task);
    }
    @DeleteMapping("/kanban/{id}")
    public void deleteTask(@PathVariable long id) {
        kanbanService.deleteTask(id);
    }
}
