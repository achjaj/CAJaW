package org.achjaj.covid;

import com.fasterxml.jackson.annotation.JsonProperty;

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
}
