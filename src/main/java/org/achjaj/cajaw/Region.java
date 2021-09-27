/*
 * Copyright (c) 2021 Jakub Bucko.
 *
 * This file is distributed under the MIT license. The wording of the license can be found here: https://mit-licens.org/
 */

package org.achjaj.covid;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.Serializable;

public class Region implements Serializable {
    private String region,
                    lang;

    private int code;
    private Period currentPeriod,
                    nextPeriod;

    /**
     * Get name of this region;
     * @return name of this region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Set the name (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param region new name
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Get the language in which the information is returned.
     *
     * Right now the API works only in Slovak language
     * @return "sk"
     */
    public String getLang() {
        return lang;
    }

    /**
     * Set the language (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param lang new language
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * Get the API code of this region.
     * @return the API code
     */
    public int getCode() {
        return code;
    }

    /**
     * Set the code (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param code new code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Get the current period.
     *
     * It should be the current week. This should never be null
     * @return current period
     */
    public Period getCurrentPeriod() {
        return currentPeriod;
    }

    /**
     * Set current period (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param currentPeriod new period
     */
    public void setCurrentPeriod(Period currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    /**
     * Get the next period.
     *
     * The next period should be the next week. May be NULL if the data are not public yet.
     * @return the next period or NULL
     */
    public Period getNextPeriod() {
        return nextPeriod;
    }

    /**
     * Set the next period (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param nextPeriod new period
     */
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
