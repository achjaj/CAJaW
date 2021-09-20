package org.achjaj.covid;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Region {
    private String region,
                    lang;

    private int code;
    private Period currentPeriod,
                    nextPeriod;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Period getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Period currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public Period getNextPeriod() {
        return nextPeriod;
    }

    public void setNextPeriod(Period nextPeriod) {
        this.nextPeriod = nextPeriod;
    }

    @Override
    public String toString() {
        try {
            return CovidAutomat.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
