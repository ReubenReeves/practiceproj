package com.practice.utils;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;

public class WebConnector {
    static Logger log = Logger.getLogger(WebConnector.class.getName());
    private static final String API_KEY_VALUE = "RGAPI-b905c23b-a69e-42f2-9ce5-165b90c1148c";
    private static final String API_KEY_KEY = "api_key";

    private static final String MATCHES_ENDPOINT = "https://oc1.api.riotgames.com/lol/match/v3/matchlists/by-account/";
    private static final String ACCOUNT_ENDPOINT = "https://oc1.api.riotgames.com/lol/summoner/v3/summoners/by-name/";

    private static final String ENCODING = "UTF-8";

    public String getMatches(int accountId) {
        try {
            URIBuilder builder = new URIBuilder(MATCHES_ENDPOINT + accountId);
            builder.addParameter(API_KEY_KEY, API_KEY_VALUE);
            HttpGet request = new HttpGet(builder.build());
            return(createConnection(request));

        } catch (URISyntaxException e) {
            e.printStackTrace();
            log.error("getMatches " + accountId, e);
        }
        return null;
    }

    public String getAccount(String accountName) {
        try {
            URIBuilder builder = new URIBuilder(ACCOUNT_ENDPOINT + accountName);
            builder.addParameter(API_KEY_KEY, API_KEY_VALUE);
            HttpGet request = new HttpGet(builder.build());
            return(createConnection(request));

        } catch (URISyntaxException e) {
            e.printStackTrace();
            log.error("getAccount " + accountName, e);
        }
        return null;
    }


    private String createConnection(HttpGet request){
        HttpClient client = HttpClientBuilder.create().build();
        try {
            HttpResponse response = client.execute(request);

            StringWriter writer = new StringWriter();
            IOUtils.copy(response.getEntity().getContent(), writer, ENCODING);

            return writer.toString();

        } catch (IOException e) {
            e.printStackTrace();
            log.error("createConnection " + request.getURI(), e);
        }
        return null;
    }
}
