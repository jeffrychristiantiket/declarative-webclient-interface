package com.tiket.tix.hotel.inventory.webclient_interface.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class MovieResponse implements Serializable {

  private static final long serialVersionUID = 2861648434667357724L;

  private Integer page;
  private List<MovieDetail> results;
  private Integer totalPages;
  private Integer totalResults;
  private Map<String, Object> additionalProperties = new LinkedHashMap<>();

}
