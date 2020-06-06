package com.mgl.chr.services;

import com.mgl.chr.client.HereApiClient;
import com.mgl.chr.dto.GeocodeResponse;
import com.mgl.chr.dto.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeolocationService {

    private final HereApiClient hereApiClient;

    public Map<String, Double> getLatLong(String address) {
        GeocodeResponse geocodeResponse = hereApiClient.sendGeocodeRequest(address).block();

        Map<String, Double> positionMap = new HashMap<>();
        Position position = null;
        if (Optional.of(geocodeResponse).isPresent())
            position = geocodeResponse.getItems().get(0).getPosition();
        else
            position = new Position();
        positionMap.put("lat", position.getLat());
        positionMap.put("lng", position.getLng());

        return positionMap;
    }
}
