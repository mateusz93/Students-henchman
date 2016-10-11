package edu.p.lodz.pl.studentshenchman.workers.woeid_dto;

/**
 * Created by Michał on 2016-06-09.
 */
public class Results {
    private Place place;

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Results [place = " + place + "]";
    }
}
