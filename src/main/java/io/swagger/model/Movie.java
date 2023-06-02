package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Movie
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-02T08:09:53.657307486Z[GMT]")


public class Movie   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("ageCategory")
  private Integer ageCategory = null;

  @JsonProperty("director")
  private String director = null;

  @JsonProperty("duration")
  private Integer duration = null;

  @JsonProperty("posterUrl")
  private String posterUrl = null;

  @JsonProperty("description")
  private String description = null;

  public Movie id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique indetifier for a movie
   * @return id
   **/
  @Schema(description = "Unique indetifier for a movie")

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Movie title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Title of the movie
   * @return title
   **/
  @Schema(description = "Title of the movie")

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Movie ageCategory(Integer ageCategory) {
    this.ageCategory = ageCategory;
    return this;
  }

  /**
   * Minimal age requierd to view a movie
   * @return ageCategory
   **/
  @Schema(description = "Minimal age requierd to view a movie")

  public Integer getAgeCategory() {
    return ageCategory;
  }

  public void setAgeCategory(Integer ageCategory) {
    this.ageCategory = ageCategory;
  }

  public Movie director(String director) {
    this.director = director;
    return this;
  }

  /**
   * Director of the movie
   * @return director
   **/
  @Schema(description = "Director of the movie")

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public Movie duration(Integer duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Duration of the movie in minutes
   * @return duration
   **/
  @Schema(description = "Duration of the movie in minutes")

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public Movie posterUrl(String posterUrl) {
    this.posterUrl = posterUrl;
    return this;
  }

  /**
   * URL to the poster of the movie
   * @return posterUrl
   **/
  @Schema(description = "URL to the poster of the movie")

  public String getPosterUrl() {
    return posterUrl;
  }

  public void setPosterUrl(String posterUrl) {
    this.posterUrl = posterUrl;
  }

  public Movie description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the movie
   * @return description
   **/
  @Schema(description = "Description of the movie")

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Movie movie = (Movie) o;
    return Objects.equals(this.id, movie.id) &&
            Objects.equals(this.title, movie.title) &&
            Objects.equals(this.ageCategory, movie.ageCategory) &&
            Objects.equals(this.director, movie.director) &&
            Objects.equals(this.duration, movie.duration) &&
            Objects.equals(this.posterUrl, movie.posterUrl) &&
            Objects.equals(this.description, movie.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, ageCategory, director, duration, posterUrl, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Movie {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    ageCategory: ").append(toIndentedString(ageCategory)).append("\n");
    sb.append("    director: ").append(toIndentedString(director)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    posterUrl: ").append(toIndentedString(posterUrl)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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