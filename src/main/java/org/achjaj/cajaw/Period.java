/*
 * Copyright (c) 2021 Jakub Bucko.
 *
 * This file is distributed under the MIT license. The wording of the license can be found here: https://mit-licens.org/
*/

package org.achjaj.cajaw;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.Serializable;
import java.util.Date;

/**
 * Has information about the week in which are some actions in active and which actions.
 */
public class Period implements Serializable {
    private Date validFrom,
                validTo;

    private int semafor,
                covid_automat;

    private Action[] automaticActions;

    /**
     * Get the start of the period.
     * @return the start date
     */
    public Date getValidFrom() {
        return validFrom;
    }

    /**
     * Set the start (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param validFrom new date
     */
    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    /**
     * Get the end of the period.
     * @return the end date
     */
    public Date getValidTo() {
        return validTo;
    }

    /**
     * Set the end (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param validTo new date
     */
    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    /**
     * Get the semafor level.
     *
     * Right now it looks like this level is indifferent from covid_automat level.
     * @return the semafor level
     */
    public int getSemafor() {
        return semafor;
    }

    /**
     * Sset the semafor level (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param semafor new level
     */
    public void setSemafor(int semafor) {
        this.semafor = semafor;
    }

    /**
     * Get level of covid automat
     * @return the covid automat level
     */
    public int getCovid_automat() {
        return covid_automat;
    }

    /**
     * Set the covid automat level (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param covid_automat new level
     */
    public void setCovid_automat(int covid_automat) {
        this.covid_automat = covid_automat;
    }

    /**
     * Get array of all actions taken place in this period
     * @return array of actions
     */
    public Action[] getAutomaticActions() {
        return automaticActions;
    }

    /**
     * Set the actions (<a href="https://github.com/FasterXML/jackson-databind/">Jackson</a> requirement)
     * @param automaticActions
     */
    public void setAutomaticActions(Action[] automaticActions) {
        this.automaticActions = automaticActions;
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
