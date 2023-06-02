package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-01T22:20:35.081630147Z[GMT]")


public class User   {
  @JsonProperty("email")
  private String email = null;

  @JsonProperty("joinDate")
  private OffsetDateTime joinDate = null;

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email of user
   * @return email
   **/
  @Schema(description = "Email of user")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User joinDate(OffsetDateTime joinDate) {
    this.joinDate = joinDate;
    return this;
  }

  /**
   * Date when the user joined
   * @return joinDate
   **/
  @Schema(description = "Date when the user joined")
  
    @Valid
    public OffsetDateTime getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(OffsetDateTime joinDate) {
    this.joinDate = joinDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.email, user.email) &&
        Objects.equals(this.joinDate, user.joinDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, joinDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    joinDate: ").append(toIndentedString(joinDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
