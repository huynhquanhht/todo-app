package com.todoapp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.backend.constants.AppConstants;
import com.todoapp.backend.entity.Task;
import com.todoapp.backend.payload.response.ApiResponse;
import com.todoapp.backend.payload.response.PagedResponse;
import com.todoapp.backend.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
  @Autowired
  private TaskService taskService;

  @GetMapping
  public ResponseEntity<PagedResponse<Task>> getAllTasks(
      @RequestParam(value = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
      @RequestParam(value = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
    PagedResponse<Task> response = taskService.getAllTask(page, size);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Task> addTask(@Validated @RequestBody Task task) {
    Task newTask = taskService.addTask(task);
    return new ResponseEntity<>(newTask, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Task> getById(@PathVariable(value = "id") Long id) {
    Task task = taskService.getById(id);

    return new ResponseEntity<>(task, HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Task> updateTask(@PathVariable(value = "id") Long id, @Validated @RequestBody Task newTask) {
    Task updatedTask = taskService.updateTask(id, newTask);
    return new ResponseEntity<>(updatedTask, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse> deleteTask(Long id) {
    ApiResponse apiResponse = taskService.deleteTask(id);
    return new ResponseEntity<>(apiResponse, HttpStatus.OK);
  }

}
