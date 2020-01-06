package pl.kanban.kanban_table.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.kanban.kanban_table.model.Task;
import pl.kanban.kanban_table.model.User;
import pl.kanban.kanban_table.service.KanbanService;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(KanbanApi.class)
class KanbanApiTest {
    @Autowired
     private MockMvc mockMvc;
    @MockBean
    private KanbanService kanbanService;
    @Test
    void should_get_all_task() throws Exception {
        Task task = new Task("x","do","x","green","hehee");
        List<Task> allTask = Arrays.asList(task);
        given(kanbanService.getAllTask()).willReturn(allTask);
        mockMvc.perform(get("/kanban")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].taskTitle", Is.is(task.getTaskTitle())));
    }

    @Test
    public void should_be_add_task() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String task = objectMapper.writeValueAsString(new Task("Title", "Table", "Text", "Green","1L"));
        mockMvc.perform(post("/kanban")
                .contentType(MediaType.APPLICATION_JSON)
                .content(task)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void should_be_delete_task() throws Exception {
        Task task = new Task("x","do","x","green","hehe");
        List<Task> allTask = Arrays.asList(task);
        mockMvc.perform(MockMvcRequestBuilders.delete("/kanban/{id}",task.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void should_get_user() throws Exception {
        User user = new User("Adrian");
        List<User> allUser = Arrays.asList(user);
        given(kanbanService.getAllUser()).willReturn(allUser);
        mockMvc.perform(get("/kanban/user")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].username", Is.is(user.getUsername())));
    }

    @Test
    void should_add_user() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String user=objectMapper.writeValueAsString(new User("Adrian"));
        mockMvc.perform(post("/kanban/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(user)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getTaskByUser() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Task task = new Task("x","do","x","green","1L");
        List<Task> allTask = Arrays.asList(task);
        String userId=objectMapper.writeValueAsString(task.getTaskUsername());
        given(kanbanService.getAllTask()).willReturn(allTask);
        mockMvc.perform(post("/kanban/user/task")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}