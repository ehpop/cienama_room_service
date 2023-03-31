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
 * Screening
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-31T21:52:24.625697542Z[GMT]")


public class Screening   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("movie")
  private Integer movie = null;

  @JsonProperty("room")
  private Integer room = null;

  @JsonProperty("startTime")
  private OffsetDateTime startTime = null;

  @JsonProperty("endTime")
  private OffsetDateTime endTime = null;

  public Screening id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the screening
   * @return id
   **/
  @Schema(description = "Unique identifier for the screening")
  
    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Screening movie(Integer movie) {
    this.movie = movie;
    return this;
  }

  /**
   * Unique Id of the movie
   * @return movie
   **/
  @Schema(description = "Unique Id of the movie")
  
    public Integer getMovie() {
    return movie;
  }

  public void setMovie(Integer movie) {
    this.movie = movie;
  }

  public Screening room(Integer room) {
    this.room = room;
    return this;
  }

  /**
   * Unique Id of the screening
   * @return room
   **/
  @Schema(description = "Unique Id of the screening")
  
    public Integer getRoom() {
    return room;
  }

  public void setRoom(Integer room) {
    this.room = room;
  }

  public Screening startTime(OffsetDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Time the movie starts
   * @return startTime
   **/
  @Schema(description = "Time the movie starts")
  
    @Valid
    public OffsetDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(OffsetDateTime startTime) {
    this.startTime = startTime;
  }

  public Screening endTime(OffsetDateTime endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Time the movie ends
   * @return endTime
   **/
  @Schema(description = "Time the movie ends")
  
    @Valid
    public OffsetDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(OffsetDateTime endTime) {
    this.endTime = endTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Screening screening = (Screening) o;
    return Objects.equals(this.id, screening.id) &&
        Objects.equals(this.movie, screening.movie) &&
        Objects.equals(this.room, screening.room) &&
        Objects.equals(this.startTime, screening.startTime) &&
        Objects.equals(this.endTime, screening.endTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, movie, room, startTime, endTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Screening {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    movie: ").append(toIndentedString(movie)).append("\n");
    sb.append("    room: ").append(toIndentedString(room)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
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
