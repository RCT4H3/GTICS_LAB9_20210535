package com.example.gtics_lab9_20210535.Daos;

import com.example.gtics_lab9_20210535.Entity.Meal1;
import com.example.gtics_lab9_20210535.Wrappers.ResponseWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MealDao {
    public List<Meal1> listar() {

        List<Meal1> lista = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();

        String endPoint = "https://www.themealdb.com/api/json/v1/1/categories.php";

        ResponseEntity<ResponseWrapper> responseEntity = restTemplate.getForEntity(endPoint, ResponseWrapper.class);

        if(responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null){
            lista = responseEntity.getBody().getCategories();
        }

        return lista;
    }
}
