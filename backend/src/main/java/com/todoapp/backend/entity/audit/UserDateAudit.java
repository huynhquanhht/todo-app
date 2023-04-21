package com.todoapp.backend.entity.audit;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.Column;

public class UserDateAudit extends DateAudit {
  private static final long serialVersionUID = 1L;

  @CreatedBy
  @Column(updatable = false)
  private Long createdBy;

  @LastModifiedBy
  private Long updatedBy;
}
