package com.tiket.tix.hotel.inventory.webclient_interface.outbound.impl;

import com.tiket.tix.hotel.inventory.webclient_interface.model.MovieResponse;
import com.tiket.tix.hotel.inventory.webclient_interface.outbound.api.MovieOutboundApi;
import com.tiket.tix.hotel.inventory.webclient_interface.outbound.api.MovieOutboundService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MovieOutboundServiceImpl implements MovieOutboundService {

  @Value("${themoviedb.access.token}")
  private String accessToken;

  @Autowired
  private MovieOutboundApi movieOutboundApi;

  @Override
  public Mono<MovieResponse> getPopularMovie() {
    Map<String, Object> headers = getMovieHeaders();
    return movieOutboundApi.getPopularMovie(headers);
  }

  @Override
  public Mono<MovieResponse> getMovies(boolean includeAdult, boolean includeVideo, int page,
      String language, String sortBy) {
    Map<String, Object> headers = getMovieHeaders();
    return movieOutboundApi.getMovies(headers, includeAdult, includeVideo, page, language, sortBy);
  }

  private Map<String, Object> getMovieHeaders() {
    Map<String, Object> headers = new HashMap<>();
    headers.put("Accept", "application/json");
    headers.put("Authorization", "Bearer ".concat(accessToken));
    return headers;
  }
}
