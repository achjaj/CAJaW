/*
 * Copyright (c) 2021 Jakub Bucko.
 *
 * This file is distributed under the MIT license. The wording of the license can be found here: https://mit-licens.org/
 */

package org.achjaj.cajaw;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Available categories of actions
 */
public enum Category {
    OSLAVYAPODUJATIA("Oslavy a podujatia"),

    @JsonProperty("obchody_a_sluzby")
    OBCHODYASLUZBY("Obchody a služby"),

    @JsonProperty("vzdelvanieakultra")
    VZDELAVANIEAKULTURA("Vzdelávanie a kultúra"),

    @JsonProperty("portavonas")
    SPORTAVOLNYCAS("Šport a voľný čas"),

    @JsonProperty("zkladnopatrenia")
    ZAKLADNEOPATRENIA("Základné opatrenia"),

    DALSIE("Ďalšie");


    private String label;

    Category(String label) {
        this.label = label;
    }

    /**
     * Get the official label of category
     * @return the label
     */
    public String label() {
        return label;
    }
}
