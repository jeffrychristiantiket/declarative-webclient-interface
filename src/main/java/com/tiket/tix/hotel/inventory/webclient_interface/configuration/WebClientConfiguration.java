package com.tiket.tix.hotel.inventory.webclient_interface.configuration;

import com.tiket.tix.hotel.inventory.webclient_interface.outbound.api.MovieOutboundApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfiguration {

  @Value("${movie.api.base-url}")
  private String movieApiBaseUrl;

  @Bean
  public WebClient movieWebClient(){
    return WebClient.builder()
        .baseUrl(movieApiBaseUrl)
        .build();
  }

  @Bean
  public MovieOutboundApi movieOutboundApi(WebClient movieWebClient){
    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder()
        .exchangeAdapter(WebClientAdapter.create(movieWebClient))
        .build();
    return factory.createClient(MovieOutboundApi.class);
  }
}
