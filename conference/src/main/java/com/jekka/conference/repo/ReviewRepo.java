package com.jekka.conference.repo;

import com.jekka.conference.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Long> {

}
