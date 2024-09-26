package com.tiket.tix.hotel.inventory.webclient_interface.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class MovieDetail implements Serializable {

  private Boolean adult;
  private String backdropPath;
  private List<Integer> genreIds;
  private Integer id;
  private String originalLanguage;
  private String originalTitle;
  private String overview;
  private Double popularity;
  private String posterPath;
  private String releaseDate;
  private String title;
  private Boolean video;
  private Double voteAverage;
  private Integer voteCount;
  private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
