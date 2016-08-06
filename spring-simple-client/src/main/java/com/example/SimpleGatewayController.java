package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by sai on 16-8-5.
 */
@RestController
@RequestMapping("/position")
public class SimpleGatewayController
{

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/names")
    Collection<String> getPositionProxy()
    {
        ParameterizedTypeReference<Resources<Position>> ptr =
                new ParameterizedTypeReference<Resources<Position>>() {};
        ResponseEntity<Resources<Position>> responseEntity =
                this.restTemplate.exchange("http://localhost:8080/simple-service/api/position/all",
                    HttpMethod.GET, null, ptr);

        return responseEntity
                .getBody()
                .getContent()
                .stream()
                .map(Position::getName)
                .collect(Collectors.toList());
    }

}
