package com.todoapp.backend.exception;

import com.todoapp.backend.payload.response.ApiResponse;

public class NotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private transient ApiResponse apiResponse;
  private String resourceName;
  private String fieldName;
  private Object fieldValue;

  public NotFoundException(String resourceName, String fieldName, Object fieldValue) {
    super();
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;
  }

  public String getResourceName() {
    return resourceName;
  }

  public String getFieldName() {
    return fieldName;
  }

  public Object getFieldValue() {
    return fieldValue;
  }

  public ApiResponse getApiResponse() {
    return apiResponse;
  }

  private void setApiResponse() {
    String message = String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue);
    apiResponse = new ApiResponse(Boolean.FALSE, message);
  }

}
