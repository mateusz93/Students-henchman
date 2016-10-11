package edu.p.lodz.pl.studentshenchman.workers.woeid_dto;

/**
 * Created by Michał on 2016-06-09.
 */
public class WOEID {

    private Query query;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "WOEID [query = " + query + "]";
    }

}
