package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sai on 16-8-7.
 */
@RestController
@RequestMapping("/company")
public class CompanyGatewayController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getCompanyNamesFallback")
    @RequestMapping("/all")
    Collection getCompanyProxy()
    {
        ParameterizedTypeReference<List<Company>> ptr =
                new ParameterizedTypeReference<List<Company>>() {};
        ResponseEntity<List<Company>> responseEntity = this.restTemplate.exchange("http://simple-service/company/all",
                HttpMethod.GET, null, ptr);

        return responseEntity
                .getBody()
                .stream()
                .map(Company::getName)
                .collect(Collectors.toList());
    }

    Collection getCompanyNamesFallback()
    {
        return Collections.emptyList();
    }


}
