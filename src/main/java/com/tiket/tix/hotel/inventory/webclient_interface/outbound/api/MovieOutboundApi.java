package com.tiket.tix.hotel.inventory.webclient_interface.outbound.api;

import com.tiket.tix.hotel.inventory.webclient_interface.model.MovieResponse;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

@HttpExchange
public interface MovieOutboundApi {

  @GetExchange("/3/movie/popular")
  Mono<MovieResponse> getPopularMovie(@RequestHeader Map<String, ?> headers);

  @GetExchange("/3/discover/movie")
  Mono<MovieResponse> getMovies(
      @RequestHeader Map<String, ?> headers,
      @RequestParam("include_adult") boolean includeAdult,
      @RequestParam("include_video") boolean includeVideo,
      @RequestParam("page") int page,
      @RequestParam("language") String language,
      @RequestParam("sort_by") String sortBy
  );

}
