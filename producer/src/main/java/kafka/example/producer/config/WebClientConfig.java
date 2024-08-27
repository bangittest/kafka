package kafka.example.producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
  public WebClient.Builder webClientBuilder() {
    return WebClient.builder();
  }
//  @Bean
//  public WebClient webClient() {
//    return WebClient.builder()
//        .codecs(configurer -> configurer
//            .defaultCodecs()
//            .maxInMemorySize(16 * 1024 * 1024)) // Tăng giới hạn lên 16MB
//        .build();
//  }

}
