package com.api.dates.Service;

import com.api.dates.Model.Election;
import com.api.dates.Repository.ElectionRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ElectionService {

    @Autowired
    ElectionRepo electionRepo;

    @Autowired
    ObjectMapper objectMapper;

    //Getting desirable date without anny sorting
    public String getList() throws JSONException, JsonProcessingException {

        String resultJson = formatList(electionRepo.getList());

        return resultJson;
    }

    //Sorting data by given order
    public String getListSorted(String order) throws JSONException, JsonProcessingException {

        List<Election> result = electionRepo.getList();
        Collections.sort(result, new Comparator<Election>() {

            DateFormat f = new SimpleDateFormat("yyyy-MM-dd");

            @Override
            public int compare(Election o1, Election o2) {
                try {
                    return f.parse(o1.getRinkData()).compareTo(f.parse(o2.getRinkData()));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });

        if (order.equals("desc")) {
            Collections.reverse(result);
            return formatList(result);

        } else if (order.equals("asc")) {
            return formatList(result);

        } else {
            return "Service does not exists!";
        }
    }

    //Formating list into JSON structure String
    private String formatList(List<Election> list) throws JsonProcessingException {

        String resultJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);

        return resultJson;

    }
}
