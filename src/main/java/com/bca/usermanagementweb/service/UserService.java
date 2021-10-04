package com.bca.usermanagementweb.service;

import java.util.List;

import com.bca.usermanagementweb.model.Response;
import com.bca.usermanagementweb.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    
    @Value("${api.host}/users")
    private String usersApi;

    @Autowired
    private RestTemplate restTemplate;

    public List<User> getUsers() {
        ResponseEntity<Response<List<User>>> response = restTemplate.exchange(usersApi, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<Response<List<User>>>(){});
        List<User> users = response.getBody().getPayload();
        return users;
    }
}
