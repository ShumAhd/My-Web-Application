package ro.shum.MyWebApplication;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping
  public List<Task> getAllTask() {
    return taskService.getAllTasks();
  }

  @GetMapping("/{id}")
  public Task getById(@PathVariable UUID id) {
    return taskService.getTask(id);
  }

  @PostMapping
  public Task addById(@RequestBody Task task) {
    return taskService.addTask(task);
  }

  @PutMapping("/{id}")
  public Task getById(@PathVariable UUID id, @RequestBody Task task) {
    return taskService.updateTask(id, task);
  }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable UUID id) {
    taskService.deleteTask(id);
  }
}
