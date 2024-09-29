package com.example.onion_with_ddd_sample.controller;

import com.example.onion_with_ddd_sample.usecase.SearchAvailableCarUsecase;
import com.example.onion_with_ddd_sample.usecase.output.SearchAvailableCarOutput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private final SearchAvailableCarUsecase searchAvailableCarUsecase;

    public SearchController(SearchAvailableCarUsecase searchAvailableCarUsecase) {
        this.searchAvailableCarUsecase = searchAvailableCarUsecase;
    }

    @GetMapping("/cars")
    public List<SearchAvailableCarOutput> searchCars() {
        return searchAvailableCarUsecase.execute();
    }

}
