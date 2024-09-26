package com.tiket.tix.hotel.inventory.webclient_interface.outbound.api;

import com.tiket.tix.hotel.inventory.webclient_interface.model.MovieResponse;
import reactor.core.publisher.Mono;

public interface MovieOutboundService {

  Mono<MovieResponse> getPopularMovie();
  Mono<MovieResponse> getMovies(
      boolean includeAdult, boolean includeVideo, int page, String language, String sortBy);
}
