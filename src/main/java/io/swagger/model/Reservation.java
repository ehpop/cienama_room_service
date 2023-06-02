package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Reservation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-01T22:20:35.081630147Z[GMT]")


public class Reservation   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("customerEmail")
  private String customerEmail = null;

  @JsonProperty("screeningId")
  private Integer screeningId = null;

  @JsonProperty("seat")
  private Integer seat = null;

  @JsonProperty("date")
  private OffsetDateTime date = null;

  public Reservation id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of a seat
   * @return id
   **/
  @Schema(description = "Unique identifier of a seat")

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Reservation customerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
    return this;
  }

  /**
   * Email of the customer who made the reservation
   * @return customerEmail
   **/
  @Schema(description = "Email of the customer who made the reservation")

  public String getCustomerEmail() {
    return customerEmail;
  }

  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }

  public Reservation screeningId(Integer screeningId) {
    this.screeningId = screeningId;
    return this;
  }

  /**
   * Unique Id of screening
   * @return screeningId
   **/
  @Schema(description = "Unique Id of screening")

  public Integer getScreeningId() {
    return screeningId;
  }

  public void setScreeningId(Integer screeningId) {
    this.screeningId = screeningId;
  }

  public Reservation seat(Integer seat) {
    this.seat = seat;
    return this;
  }

  /**
   * Number of seat reserved
   * @return seat
   **/
  @Schema(description = "Number of seat reserved")

  public Integer getSeat() {
    return seat;
  }

  public void setSeat(Integer seat) {
    this.seat = seat;
  }

  public Reservation date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Date of the reservation
   * @return date
   **/
  @Schema(description = "Date of the reservation")

  @Valid
  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reservation reservation = (Reservation) o;
    return Objects.equals(this.id, reservation.id) &&
            Objects.equals(this.customerEmail, reservation.customerEmail) &&
            Objects.equals(this.screeningId, reservation.screeningId) &&
            Objects.equals(this.seat, reservation.seat) &&
            Objects.equals(this.date, reservation.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customerEmail, screeningId, seat, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reservation {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    customerEmail: ").append(toIndentedString(customerEmail)).append("\n");
    sb.append("    screeningId: ").append(toIndentedString(screeningId)).append("\n");
    sb.append("    seat: ").append(toIndentedString(seat)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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
