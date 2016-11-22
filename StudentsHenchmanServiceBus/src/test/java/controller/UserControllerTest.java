package controller;

import cdm.PreferencesRQ;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 22.11.2016.
 */
public class UserControllerTest {

    @Test
    public void asd() {
        List<Long> asd = new ArrayList<>();
        asd.add(388l);
        PreferencesRQ preferencesRQ = new PreferencesRQ();
        preferencesRQ.setTerm(7);
        preferencesRQ.setDegree(1);
        preferencesRQ.setDepartmentId(14);
        preferencesRQ.setFieldId(69);
        preferencesRQ.setDeanGroupIds(asd);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonInString = objectMapper.writeValueAsString(preferencesRQ);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}