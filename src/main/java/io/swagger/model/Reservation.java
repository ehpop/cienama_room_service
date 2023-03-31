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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-31T21:52:24.625697542Z[GMT]")


public class Reservation   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("customerName")
  private String customerName = null;

  @JsonProperty("screeningInfo")
  private Integer screeningInfo = null;

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

  public Reservation customerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  /**
   * The name of the customer who made the reservation
   * @return customerName
   **/
  @Schema(description = "The name of the customer who made the reservation")
  
    public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public Reservation screeningInfo(Integer screeningInfo) {
    this.screeningInfo = screeningInfo;
    return this;
  }

  /**
   * Unique Id of screening
   * @return screeningInfo
   **/
  @Schema(description = "Unique Id of screening")
  
    public Integer getScreeningInfo() {
    return screeningInfo;
  }

  public void setScreeningInfo(Integer screeningInfo) {
    this.screeningInfo = screeningInfo;
  }

  public Reservation seat(Integer seat) {
    this.seat = seat;
    return this;
  }

  /**
   * Unique Id of seat that was reserved
   * @return seat
   **/
  @Schema(description = "Unique Id of seat that was reserved")
  
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
        Objects.equals(this.customerName, reservation.customerName) &&
        Objects.equals(this.screeningInfo, reservation.screeningInfo) &&
        Objects.equals(this.seat, reservation.seat) &&
        Objects.equals(this.date, reservation.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customerName, screeningInfo, seat, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reservation {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
    sb.append("    screeningInfo: ").append(toIndentedString(screeningInfo)).append("\n");
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
