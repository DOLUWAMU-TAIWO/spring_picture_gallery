package dev.dolu.picture.Picture;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PictureService {

    private final WebClient webClient;

    public PictureService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.unsplash.com").build();
    }

    public PictureToSend getRandomPicture() {
        String accessKey = "0vDKn5-zz-kLnkwEZIWUGS21vbHlGxDhL80ICxhFrEs";  // Replace with your Unsplash access key

        // Fetch the full response from Unsplash (containing id and urls)
        Picture fullResponse = this.webClient.get()
                .uri("/photos/random?client_id=" + accessKey)
                .retrieve()
                .bodyToMono(Picture.class)  // Map to Picture class with full data
                .block();

        // Extract the id and regular URL, and return a PictureToSend object
        return new PictureToSend(fullResponse.id(), fullResponse.urls().regular());
    }
}