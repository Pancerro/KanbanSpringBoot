package pl.kanban.kanban_table.model;


import javax.persistence.*;

@Entity
@Table(name="Kanban")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String taskTitle,taskTable,taskText,taskPriority,taskUsername;
    public Task() {
    }

    public Task(String taskTitle, String taskTable, String taskText, String taskPriority, String taskUsername) {
        this.taskTitle = taskTitle;
        this.taskTable = taskTable;
        this.taskText = taskText;
        this.taskPriority = taskPriority;
        this.taskUsername = taskUsername;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskTable() {
        return taskTable;
    }

    public void setTaskTable(String taskTable) {
        this.taskTable = taskTable;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getTaskUsername() {
        return taskUsername;
    }

    public void setTaskUsername(String taskUsername) {
        this.taskUsername = taskUsername;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskTable='" + taskTable + '\'' +
                ", taskText='" + taskText + '\'' +
                ", taskPriority='" + taskPriority + '\'' +
                ", taskUsername='" + taskUsername + '\'' +
                '}';
    }
}
