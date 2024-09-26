package com.tiket.tix.hotel.inventory.webclient_interface;

import com.tiket.tix.hotel.inventory.webclient_interface.model.MovieResponse;
import com.tiket.tix.hotel.inventory.webclient_interface.outbound.api.MovieOutboundService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@Log4j2
@SpringBootApplication
public class WebclientInterfaceApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(WebclientInterfaceApplication.class, args);
  }

  @Value("${themoviedb.access.token}")
  private String accessToken;

  @Autowired
  WebClient movieWebClient;

  @Autowired
  MovieOutboundService movieOutboundService;

  @Override
  public void run(String... args) throws Exception {
    declarativeStyle();
    traditionalStyle();
  }

  private void declarativeStyle() {
    movieOutboundService.getPopularMovie()
        .doOnSuccess(result -> {
          log.info("result: \n");
          log.info(result);
        })
        .subscribe();
  }

  public void traditionalStyle(){
    movieWebClient.get()
        .uri("/3/movie/popular")
        .headers(httpHeaders -> {
          httpHeaders.add("accept", "application/json");
          httpHeaders.add("Authorization", "Bearer ".concat(accessToken));
        })
        .retrieve()
        .bodyToMono(MovieResponse.class)
        .doOnSuccess(result -> {
          log.info("result: \n");
          log.info(result);
        })
        .subscribe();
  }
}
