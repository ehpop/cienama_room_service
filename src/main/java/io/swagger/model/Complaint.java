package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Complaint
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-02T09:34:19.571377996Z[GMT]")

public class Complaint {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("issueDate")
  private OffsetDateTime issueDate = null;

  @JsonProperty("complaintMsg")
  private String complaintMsg = null;

  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("responseContact")
  private String responseContact = null;

  /**
   * Status of complaint
   */
  public enum StatusEnum {
    NEW("new"),

    ANSWERED("answered"),

    WAITING("waiting"),

    CLOSED("closed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  public Complaint id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique ID
   * 
   * @return id
   **/
  @Schema(description = "Unique ID")

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Complaint issueDate(OffsetDateTime issueDate) {
    this.issueDate = issueDate;
    return this;
  }

  /**
   * Date when issue was created
   * 
   * @return issueDate
   **/
  @Schema(description = "Date when issue was created")

  @Valid
  public OffsetDateTime getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(OffsetDateTime issueDate) {
    this.issueDate = issueDate;
  }

  public Complaint complaintMsg(String complaintMsg) {
    this.complaintMsg = complaintMsg;
    return this;
  }

  /**
   * Complaint content
   * 
   * @return complaintMsg
   **/
  @Schema(description = "Complaint content")

  public String getComplaintMsg() {
    return complaintMsg;
  }

  public void setComplaintMsg(String complaintMsg) {
    this.complaintMsg = complaintMsg;
  }

  public Complaint userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Email of the user that created complained
   * 
   * @return userId
   **/
  @Schema(description = "Email of the user that created complained")

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Complaint responseContact(String responseContact) {
    this.responseContact = responseContact;
    return this;
  }

  /**
   * Email that user provided for contact
   * 
   * @return responseContact
   **/
  @Schema(description = "Email that user provided for contact")

  public String getResponseContact() {
    return responseContact;
  }

  public void setResponseContact(String responseContact) {
    this.responseContact = responseContact;
  }

  public Complaint status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Status of complaint
   * 
   * @return status
   **/
  @Schema(description = "Status of complaint")

  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Complaint complaint = (Complaint) o;
    return Objects.equals(this.id, complaint.id) &&
        Objects.equals(this.issueDate, complaint.issueDate) &&
        Objects.equals(this.complaintMsg, complaint.complaintMsg) &&
        Objects.equals(this.userId, complaint.userId) &&
        Objects.equals(this.responseContact, complaint.responseContact) &&
        Objects.equals(this.status, complaint.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, issueDate, complaintMsg, userId, responseContact, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Complaint {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    issueDate: ").append(toIndentedString(issueDate)).append("\n");
    sb.append("    complaintMsg: ").append(toIndentedString(complaintMsg)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    responseContact: ").append(toIndentedString(responseContact)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
