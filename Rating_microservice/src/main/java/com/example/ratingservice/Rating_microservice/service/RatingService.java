package com.example.ratingservice.Rating_microservice.service;

import com.example.ratingservice.Rating_microservice.entities.Rating;

import java.util.List;

public interface RatingService {
    //create
    Rating create(Rating rating);

    //get all ratings
    List<Rating> getAll();

    //get all rating by userId
    List<Rating> getRatingByUserId(String userId);


    //get all rating by hotel
    List<Rating> getRatingByHotelId(String hotelId);
}
