package com.todoapp.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoapp.backend.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
