package edu.p.lodz.pl.studentshenchman.workers.woeid_dto;

/**
 * Created by Michał on 2016-06-09.
 */
public class Place {
    private String woeid;

    public String getWoeid() {
        return woeid;
    }

    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }

    @Override
    public String toString() {
        return "Place [woeid = " + woeid + "]";
    }
}
