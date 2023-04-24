package com.todoapp.backend.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.todoapp.backend.constants.AppConstants;
import com.todoapp.backend.entity.Task;
import com.todoapp.backend.exception.BadRequestException;
import com.todoapp.backend.exception.NotFoundException;
import com.todoapp.backend.payload.response.ApiResponse;
import com.todoapp.backend.payload.response.PagedResponse;
import com.todoapp.backend.repository.TaskRepository;
import com.todoapp.backend.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
  @Autowired
  private TaskRepository taskRepository;

  @Override
  public PagedResponse<Task> getAllTask(int page, int size) {
    validatePageNumberAndSize(page, size);
    PageRequest pageable = PageRequest.of(page, size);
    Page<Task> tasks = taskRepository.findAll(pageable);
    List<Task> content = tasks.getNumberOfElements() == 0 ? Collections.emptyList() : tasks.getContent();

    return new PagedResponse<>(content, tasks.getNumber(), tasks.getSize(), tasks.getTotalElements(),
        tasks.getTotalPages(), tasks.isLast());
  }

  @Override
  public Task addTask(Task newTask) {
    return taskRepository.save(newTask);
  }

  private void validatePageNumberAndSize(int page, int size) {
    if (page < 0) {
      throw new BadRequestException("Page number cannot be less than zero");
    }

    if (size < 0) {
      throw new BadRequestException("Size number cannot be less than zero.");
    }

    if (size > AppConstants.MAX_PAGE_SIZE) {
      throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
    }
  }

  @Override
  public Task updateTask(Long id, Task newTask) {
    Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("TASK", "ID", id));
    task.setName(newTask.getName());
    return taskRepository.save(task);
  }

  @Override
  public Task getById(Long id) {
    Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("TASK", "ID", id));
    return task;
  }

  @Override
  public ApiResponse deleteTask(Long id) {
    Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("TASK", "ID", id));
    taskRepository.deleteById(id);
    return new ApiResponse(Boolean.TRUE, "You successfully deleted todo");
  }
}
