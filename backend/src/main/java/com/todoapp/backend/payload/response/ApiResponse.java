import java.io.Serializable;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({
    "success",
    "message"
})
public class ApiResponse implements Serializable {
  @JsonIgnore
  private static final long serialVersionUID = 77L;

  @JsonProperty("success")
  private Boolean success;

  @JsonProperty("message")
  private String message;

  @JsonIgnore
  private HttpStatus status;

  public ApiResponse() {
  }

  public ApiResponse(Boolean success, String message) {
    this.success = success;
    this.message = message;
  }

  public ApiResponse(Boolean success, String message, HttpStatus httpStatus) {
    this.success = success;
    this.message = message;
    this.status = httpStatus;
  }
}