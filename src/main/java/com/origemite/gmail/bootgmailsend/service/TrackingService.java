package com.origemite.gmail.bootgmailsend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RequiredArgsConstructor
@Service
public class TrackingService {

    @Value("${api.key.smart-tracking}")
    private String tracking;

    public void tracking(String number, String number1) {
        String url = UriComponentsBuilder
                .fromHttpUrl("https://info.sweettracker.co.kr/api/v1/trackingInfo")
                .queryParam("t_key", tracking)
                .queryParam("t_code", number)
                .queryParam("t_invoice", number1)
                .toUriString();
        RestClient  rc = RestClient.create();
        ResponseEntity<String> response = rc.get()
                .uri(url)
                .retrieve()
                .toEntity(String.class);

        log.info(response.getBody());
    }
}
