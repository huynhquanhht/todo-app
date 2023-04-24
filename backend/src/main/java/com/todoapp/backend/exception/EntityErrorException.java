package com.todoapp.backend.exception;

import org.springframework.http.ResponseEntity;

import com.todoapp.backend.payload.response.ApiResponse;

public class EntityErrorException extends RuntimeException {
  private static final long serialVersionUID = -3156815846745801694L;

  private transient ResponseEntity<ApiResponse> apiResponse;

  public EntityErrorException(ResponseEntity<ApiResponse> apiResponse) {
    this.apiResponse = apiResponse;
  }

  public ResponseEntity<ApiResponse> getApiResponse() {
    return apiResponse;
  }
}
