package com.example.ratingservice.Rating_microservice.service.impl;

import com.example.ratingservice.Rating_microservice.entities.Rating;
import com.example.ratingservice.Rating_microservice.repository.RatingRepository;
import com.example.ratingservice.Rating_microservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating create(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        Rating rating1 = ratingRepository.save(rating);

        return rating1;
    }

    @Override
    public List<Rating> getAll() {
        List<Rating> ratings = ratingRepository.findAll();
        return ratings;
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        List<Rating> ratings = ratingRepository.findByUserId(userId);
        return ratings;
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        List<Rating> ratings = ratingRepository.findByHotelId(hotelId);
        return ratings;
    }
}
