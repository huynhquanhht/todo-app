package com.todoapp.backend.service;

import com.todoapp.backend.entity.Task;
import com.todoapp.backend.payload.response.ApiResponse;
import com.todoapp.backend.payload.response.PagedResponse;

public interface TaskService {

  PagedResponse<Task> getAllTask(int page, int size);

  Task addTask(Task newTask);

  Task updateTask(Long id, Task newTask);

  Task getById(Long id);

  ApiResponse deleteTask(Long id);
}
