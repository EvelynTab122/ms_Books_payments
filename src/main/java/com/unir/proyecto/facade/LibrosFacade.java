package com.unir.proyecto.facade;

import com.unir.proyecto.facade.model.libro;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
@Slf4j
public class LibrosFacade {

  @Value("${getProduct.url}")
  private String getLibroUrl;

  private final WebClient.Builder webClient;

  public libro getLibro(String id) {

    try {
      String url = String.format(getLibroUrl, id);
      log.info("Getting Libro with ID {}. Request to {}", id, url);
      return webClient.build()
              .get()
              .uri(url)
              .retrieve()
              .bodyToMono(libro.class)
              .block();
    } catch (HttpClientErrorException e) {
      log.error("Client Error: {}, Libro with ID {}", e.getStatusCode(), id);
      return null;
    } catch (HttpServerErrorException e) {
      log.error("Server Error: {}, Libro with ID {}", e.getStatusCode(), id);
      return null;
    } catch (Exception e) {
      log.error("Error: {}, Libro with ID {}", e.getMessage(), id);
      return null;
    }
  }

}
