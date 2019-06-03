package com.jekka.conference.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "conference")
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Timestamp timeConduction;
    private String venue;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "conference_id")
    private List<Review> reviewList;


    public Conference() {
    }

    public Conference(String title, Timestamp timeConduction, String venue, List<Review> reviewList) {
        this.title = title;
        this.timeConduction = timeConduction;
        this.venue = venue;
        this.reviewList = reviewList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conference that = (Conference) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(timeConduction, that.timeConduction) &&
                Objects.equals(venue, that.venue) &&
                Objects.equals(reviewList, that.reviewList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, timeConduction, venue, reviewList);
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", timeConduction=" + timeConduction +
                ", venue='" + venue + '\'' +
                ", reviewList=" + reviewList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getTimeConduction() {
        return timeConduction;
    }

    public void setTimeConduction(Timestamp timeConduction) {
        this.timeConduction = timeConduction;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
