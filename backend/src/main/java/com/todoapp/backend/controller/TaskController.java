package com.todoapp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.backend.constants.AppConstants;
import com.todoapp.backend.entity.Task;
import com.todoapp.backend.payload.response.PagedResponse;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
  // @Autowired
  @GetMapping
  public ResponseEntity<PagedResponse<Task>> getAllTasks(
      @RequestParam(value = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
      @RequestParam(value = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
    // return new ResponseEntity<>(response, HttpStatus.OK);
    return null;
  }
}
