/*
 * Copyright (c) 2021 Jakub Bucko.
 *
 * This file is distributed under the MIT license. The wording of the license can be found here: https://mit-licens.org/
 */

package org.achjaj.cajaw;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;


/**
 * Main library class.
 *
 * Use object of this class to call the API.
 */
public class CovidAutomat {
    protected static final ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
    }

    /**
     * Official colors (in hex) assigned to different stages.
     *
     * The array is ordered, this means that the color of 1st level is at index 0 and so on.
     * There is no official color for 0th level.
     */
    public static final String[] colors = new String[]{"#74b643", "#ff8b02", "#e40017", "#830029", "#000000"};

    /**
     * Official names for different levels.
     *
     * The array is ordered, this means that the name of 1st level is at index 0 and so on.
     * There is no official name for 0th level.
     */
    public static final String[] levels = new String[]{"Monitoring", "Ostražitosť", "1. stupeň ohrozenia", "2. stupeň ohrozenia", "3. stupeň ohrozenia"};

    private final String baseUrl = "https://automat.gov.sk/api/automat/code/%d";
    private final HashMap<String, Integer> regions = new HashMap<>();
    private String userAgent;

    /**
     * Constructor
     * @param userAgent string to use as User Agent
     */
    public CovidAutomat(String userAgent) {
        this.userAgent = userAgent;

        Arrays.stream(listOfRegions)
            .map(str -> str.split(";"))
            .forEach(pair ->
                regions.put(pair[0], Integer.parseInt(pair[1]))
            );
    }

    /**
     * Constructor with default User Agent.
     *
     * The default User Agent is "org.achjaj.org.achjaj.CovidAutomat.CovidAutomat:$version"
     */
    public CovidAutomat() {
        this("org.achjaj.org.achjaj.CovidAutomat.CovidAutomat:" + version());
    }


    /**
     * Get the version of the library in use.
     * @return the version string
     */
    public static String version() {
        InputStream stream = CovidAutomat.class.getResourceAsStream("version");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Parse response of GET request from the URL.
     * @param url destination of GET request
     * @return new instance of {@link org.achjaj.cajaw.Region} class
     * @throws IOException thrown if error occurred while reading or parsing the response
     */
    private Region readURL(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", userAgent);

        String result = new BufferedReader(new InputStreamReader(connection.getInputStream()))
            .lines().collect(Collectors.joining("\n"));

        return mapper.readValue(result, Region.class);
    }

    /**
     * Check region name validity
     * @param name string to check
     * @return true if the given string is in the key set of "regions" HashMap
     */
    private boolean validRegion(String name) {
        for (String region : regions.keySet())
            if (region.equals(name))
                return true;

        return false;
    }

    /**
     * Get the region data by region code.
     *
     * The code is an integer from 1 to 79.
     * @param code the region code
     * @return new instance of {@link org.achjaj.cajaw.Region} class filled with the data
     * @throws IOException thrown if the code was invalid or if there was parse error
     */
    public Region getRegionByCode(int code) throws IOException {
        if (code < 1 || code > 79)
            throw new IOException("Invalid code: " + code);

        URL url = new URL(String.format(baseUrl, code));

        return readURL(url);
    }

    /**
     * Get the region data by the region name.
     *
     * @see CovidAutomat#getRegions()
     * @param name string with the name of a region
     * @return new instance of {@link org.achjaj.cajaw.Region} class filled with the data
     * @throws IOException thrown if the name was invalid or if there was parse error
     */
    public Region getRegionByName(String name) throws IOException {
        if (!validRegion(name))
            throw new IOException("Unknown region: " + name);

        return getRegionByCode(regions.get(name));
    }

    /**
     * Get the name of regions and their codes.
     * @return map with the names and codes
     */
    public HashMap<String, Integer> getRegions() {
        return regions;
    }

    private final String[] listOfRegions = {
        "Lučenec;1",
        "Rimavská Sobota;2",
        "Galanta;3",
        "Kežmarok;4",
        "Bardejov;5",
        "Turčianske Teplice;6",
        "Prešov;7",
        "Trenčín;8",
        "Humenné;9",
        "Trebišov;10",
        "Nitra;11",
        "Senec;12",
        "Dunajská Streda;13",
        "Komárno;14",
        "Liptovský Mikuláš;15",
        "Nové Zámky;16",
        "Stará Ľubovňa;17",
        "Topoľčany;18",
        "Rožňava;19",
        "Levice;20",
        "Spišská Nová Ves;21",
        "Vranov nad Topľou;22",
        "Námestovo;23",
        "Zvolen;24",
        "Bytča;25",
        "Žilina;26",
        "Myjava;27",
        "Brezno;28",
        "Košice - okolie;29",
        "Krupina;30",
        "Banská Štiavnica;31",
        "Banská Bystrica;32",
        "Pezinok;33",
        "Michalovce;34",
        "Sabinov;35",
        "Levoča;36",
        "Veľký Krtíš;37",
        "Stropkov;38",
        "Piešťany;39",
        "Prievidza;40",
        "Bánovce nad Bebravou;41",
        "Žarnovica;42",
        "Žiar nad Hronom;43",
        "Sobrance;44",
        "Partizánske;45",
        "Poprad;46",
        "Nové Mesto nad Váhom;47",
        "Revúca;48",
        "Martin;49",
        "Snina;50",
        "Zlaté Moravce;51",
        "Považská Bystrica;52",
        "Svidník;53",
        "Púchov;54",
        "Dolný Kubín;55",
        "Ružomberok;56",
        "Trnava;57",
        "Senica;58",
        "Čadca;59",
        "Ilava;60",
        "Hlohovec;61",
        "Malacky;62",
        "Medzilaborce;63",
        "Bratislava I;64",
        "Bratislava V;65",
        "Bratislava IV;66",
        "Bratislava III;67",
        "Bratislava II;68",
        "Detva;69",
        "Poltár;70",
        "Tvrdošín;71",
        "Skalica;72",
        "Kysucké Nové Mesto;73",
        "Gelnica;74",
        "Šaľa;75",
        "Košice I;76",
        "Košice IV;77",
        "Košice III;78",
        "Košice II;79"
    };
}
