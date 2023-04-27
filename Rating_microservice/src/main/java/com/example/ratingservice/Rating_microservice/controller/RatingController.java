package com.example.ratingservice.Rating_microservice.controller;

import com.example.ratingservice.Rating_microservice.entities.Rating;
import com.example.ratingservice.Rating_microservice.service.RatingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        Rating rating1 = ratingService.create(rating);
        return new ResponseEntity<>(rating1, HttpStatus.CREATED);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId)
    {
        List<Rating>ratings = ratingService.getRatingByUserId(userId);
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
    {
        List<Rating> ratings = ratingService.getRatingByHotelId(hotelId);
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }

}
