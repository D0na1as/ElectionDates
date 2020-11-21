package com.api.dates.Controller;

import com.api.dates.Model.Election;
import com.api.dates.Service.ParsingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ElectionController {

    private static final String JSON_URL = "https://www.vrk.lt/statiniai/puslapiai/rinkimai/rt.json";

    @Autowired
    private ParsingService parsingService;

    @RequestMapping (value = "/", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public String Hello() throws JsonProcessingException, JSONException {

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(JSON_URL, String.class);

        JSONObject o = new JSONObject(response);
        JSONArray obj = o.getJSONArray("data");
        String dataArray = obj.toString();

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Election>>(){});
        List<Election> result = objectReader.readValue(dataArray);
        

        String resultJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        System.out.println(resultJson);

        return resultJson;
    }

}

