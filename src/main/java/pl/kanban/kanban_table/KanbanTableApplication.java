package pl.kanban.kanban_table;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kanban.kanban_table.model.Task;
import pl.kanban.kanban_table.repository.TaskRepo;

import java.util.stream.Stream;

@SpringBootApplication
public class KanbanTableApplication {

    public static void main(String[] args) {
        SpringApplication.run(KanbanTableApplication.class, args);
    }

    @Bean
    CommandLineRunner init(TaskRepo userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                Task user = new Task(name,"do");
                userRepository.save(user);
            });
            Task task=new Task("hehe","done");
            userRepository.save(task);
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
