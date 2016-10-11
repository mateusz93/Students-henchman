package edu.p.lodz.pl.studentshenchman.workers.woeid_dto;

/**
 * Created by Michał on 2016-06-09.
 */
public class Query {
    private Results results;

    private String count;

    private String created;

    private String lang;

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Query [results = " + results + ", count = " + count + ", created = " + created + ", lang = " + lang + "]";
    }
}
