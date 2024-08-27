package kafka.example.producer.stream;

import kafka.example.producer.producer.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikimediaStreamConsumer {
  private final WebClient webClient;
  private final WikimediaProducer producer;


  public WikimediaStreamConsumer(WebClient.Builder  webClientBuilder, WikimediaProducer producer) {
    this.webClient = webClientBuilder.baseUrl("https://dog.ceo/api/breeds").build();
    this.producer = producer;
  }

  public void consumeStreamAndPublish() {
    webClient.get()
       .uri("/image/random")
    //   .accept(MediaType.APPLICATION_JSON)
       .retrieve()
       .bodyToMono(String.class)
       .subscribe(log::info);
  }
}
