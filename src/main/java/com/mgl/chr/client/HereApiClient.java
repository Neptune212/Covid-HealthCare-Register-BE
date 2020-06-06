package com.mgl.chr.client;

import com.mgl.chr.dto.GeocodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HereApiClient {

    private final WebClient webClient;

    @Value("${chr.here.bearer}")
    private String bearerToken;

    public Mono<GeocodeResponse> sendGeocodeRequest(String address) {
        return webClient.get()
                .uri("geocode?q=" + address + "&apikey=" + bearerToken)
                .retrieve()
                .bodyToMono(GeocodeResponse.class);
    }
}
