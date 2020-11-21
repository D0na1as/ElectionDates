package com.api.dates.Repository;

import com.api.dates.Model.Election;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class ElectionRepo {

    private static final String JSON_URL = "https://www.vrk.lt/statiniai/puslapiai/rinkimai/rt.json";

    @Autowired
    ObjectMapper objectMapper;

    //Getting data from API and extracting desirable data
    public List<Election> getList() throws JSONException, JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(JSON_URL, String.class);

        JSONObject o = new JSONObject(response);
        JSONArray obj = o.getJSONArray("data");
        String dataArray = obj.toString();

        ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Election>>(){});
        List<Election> electionList = objectReader.readValue(dataArray);

        return electionList;
    }
}
