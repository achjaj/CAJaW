/*
 * Copyright (c) 2021 Jakub Bucko.
 *
 * This file is distributed under the MIT license. The wording of the license can be found here: https://mit-licens.org/
 */

package org.achjaj.cajaw;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Available icon IDs
 */
public enum Icon {
    GREEN,
    @JsonProperty("green-info")
    GREEN_INFO,
    ALERT,
    @JsonProperty("alert-info")
    ALERT_INFO
}
