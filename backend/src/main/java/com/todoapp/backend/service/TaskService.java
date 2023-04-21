package com.todoapp.backend.service;

import com.todoapp.backend.entity.Task;
import com.todoapp.backend.payload.response.PagedResponse;

public interface TaskService {

  PagedResponse<Task> getAllTask(int page, int size);

  PagedResponse<Task> getPostsByCreatedBy(String username, int page, int size);

  // Task updateTask(Long id, TaskRequest newTaskRequest);
}
