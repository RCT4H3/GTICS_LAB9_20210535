package com.example.gtics_lab9_20210535.Wrappers;

import com.example.gtics_lab9_20210535.Entity.Meal1;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ResponseWrapper {
    private List<Meal1> categories;

}
