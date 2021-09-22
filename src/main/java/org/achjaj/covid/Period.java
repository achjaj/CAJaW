package org.achjaj.covid;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.Serializable;
import java.util.Date;

public class Period implements Serializable {
    private Date validFrom,
                validTo;

    private int semafor,
                covid_automat;

    private Action[] automaticActions;

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public int getSemafor() {
        return semafor;
    }

    public void setSemafor(int semafor) {
        this.semafor = semafor;
    }

    public int getCovid_automat() {
        return covid_automat;
    }

    public void setCovid_automat(int covid_automat) {
        this.covid_automat = covid_automat;
    }

    public Action[] getAutomaticActions() {
        return automaticActions;
    }

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
