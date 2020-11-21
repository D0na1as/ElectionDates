package com.api.dates.Controller;

import com.api.dates.Service.ElectionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ElectionController {

    @Autowired
    private ElectionService electionService;

    //Returning list of election data
    @RequestMapping (value = "/", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public String getElections() throws JsonProcessingException, JSONException {

        return electionService.getList();

    }

    //Returning sorted election data:
    // "asc" for ascending sorting by date,
    // "desc" for descending sorting by date
    @RequestMapping(value = "/{sorting}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable("sorting") String order) throws JSONException, JsonProcessingException {

        return electionService.getListSorted(order);
    }

}

