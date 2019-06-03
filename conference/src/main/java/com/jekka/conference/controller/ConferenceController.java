package com.jekka.conference.controller;


import com.jekka.conference.entity.Conference;
import com.jekka.conference.entity.Review;
import com.jekka.conference.entity.StateReview;
import com.jekka.conference.repo.ConferenceRepo;
import com.jekka.conference.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

import static com.jekka.conference.entity.StateReview.CONSIDERATION;


@RestController
@RequestMapping("conference")
public class ConferenceController {

    @Autowired
    private ConferenceRepo conferenceRepo;

    @Autowired
    private ReviewRepo reviewRepo;


    @GetMapping
    public String getListConference(){
        StringBuilder result = new StringBuilder();
        for(Conference conference : conferenceRepo.findAll()) {
            result.append(conference);
            result.append("/n");
        }
        return result.toString();
    }

    @GetMapping("{id}")
    public String getConference(@PathVariable Long id){
        Optional<Conference> conference = conferenceRepo.findById(id);
        if(conference.isPresent()) {
            return conference.get().toString();
        }
        return "not found conference";
    }

    @GetMapping("{id}/review")
    public String getListReview(@PathVariable Long id){
        StringBuilder result = new StringBuilder();
        Optional<Conference> conference = conferenceRepo.findById(id);
        if(conference.isPresent()) {
            for (Review review : conference.get().getReviewList())
                result.append(review);
            return result.toString();
        }
        return "not found review";
    }

    @GetMapping("{id}/review/{review_id}")
    public String getReview(@PathVariable Long id, @PathVariable Long review_id){
        Optional<Conference> conference = conferenceRepo.findById(id);
        if(conference.isPresent()) {
            for (Review review : conference.get().getReviewList()) {
                if (review.getId().equals(review_id))
                    return review.toString();
            }
        }
        return "not found review";
    }

    @PostMapping
    public String createReview(@RequestBody Map<String, String> message){
        Review review = new Review(message.get("topic"), message.get("registered"), Integer.valueOf(message.get("visitors")), message.get("speaker"), CONSIDERATION);
        reviewRepo.save(review);
        Optional<Conference> conference = conferenceRepo.findById(Long.valueOf(message.get("id")));
        conference.ifPresent(value -> value.getReviewList().add(review));
        conferenceRepo.save(conference.get());
        return review + "added";
    }

}
