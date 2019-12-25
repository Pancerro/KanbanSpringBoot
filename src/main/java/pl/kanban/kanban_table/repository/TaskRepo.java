package pl.kanban.kanban_table.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.kanban.kanban_table.model.Task;

import java.util.List;

@Repository
@CrossOrigin(origins = "https://kanban-springboot.herokuapp.com")
//@CrossOrigin(origins = "http://localhost:4200")
public interface TaskRepo extends JpaRepository<Task,Long> {
}
