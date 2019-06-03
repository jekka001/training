package com.jekka.conference.repo;

import com.jekka.conference.entity.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepo extends JpaRepository<Conference, Long> {
}
