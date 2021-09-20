package org.achjaj.covid;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Icon {
    GREEN,
    @JsonProperty("green-info")
    GREEN_INFO,
    ALERT,
    @JsonProperty("alert-info")
    ALERT_INFO
}
