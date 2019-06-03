package com.jekka.conference.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String topic;
    private String registered;
    private int visitors;
    private String speaker;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private StateReview state;



    public Review() {
    }



    public Review(String topic, String registered, int visitors, String speaker, StateReview state) {
        this.topic = topic;
        this.registered = registered;
        this.visitors = visitors;
        this.speaker = speaker;
        this.state = state;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return visitors == review.visitors &&
                Objects.equals(id, review.id) &&
                Objects.equals(topic, review.topic) &&
                Objects.equals(registered, review.registered) &&
                Objects.equals(speaker, review.speaker) &&
                state == review.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, registered, visitors, speaker, state);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", registered='" + registered + '\'' +
                ", visitors=" + visitors +
                ", speaker='" + speaker + '\'' +
                ", state=" + state +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getVisitors() {
        return visitors;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public StateReview getState() {
        return state;
    }

    public void setState(StateReview state) {
        this.state = state;
    }
}
