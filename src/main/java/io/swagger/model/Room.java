package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Room
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-01T22:20:35.081630147Z[GMT]")


public class Room   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("capacity")
  private Integer capacity = null;

  @JsonProperty("rows")
  private Integer rows = null;

  public Room id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the room
   * @return id
   **/
  @Schema(description = "Unique identifier for the room")

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Room name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the room
   * @return name
   **/
  @Schema(description = "Name of the room")

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Room capacity(Integer capacity) {
    this.capacity = capacity;
    return this;
  }

  /**
   * Maximum number of people that can fit in the room
   * @return capacity
   **/
  @Schema(description = "Maximum number of people that can fit in the room")

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public Room rows(Integer rows) {
    this.rows = rows;
    return this;
  }

  /**
   * Number of rows available in room
   * @return rows
   **/
  @Schema(description = "Number of rows available in room")

  public Integer getRows() {
    return rows;
  }

  public void setRows(Integer rows) {
    this.rows = rows;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Room room = (Room) o;
    return Objects.equals(this.id, room.id) &&
            Objects.equals(this.name, room.name) &&
            Objects.equals(this.capacity, room.capacity) &&
            Objects.equals(this.rows, room.rows);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, capacity, rows);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Room {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
    sb.append("    rows: ").append(toIndentedString(rows)).append("\n");
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
