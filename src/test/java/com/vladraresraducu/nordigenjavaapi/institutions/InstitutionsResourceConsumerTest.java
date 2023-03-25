package com.vladraresraducu.nordigenjavaapi.institutions;

import com.vladraresraducu.nordigenjavaapi.NordigenApiClient;
import com.vladraresraducu.nordigenjavaapi.institutions.model.Country;
import com.vladraresraducu.nordigenjavaapi.institutions.model.InstitutionsRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InstitutionsResourceConsumerTest {
    @Autowired
    private NordigenApiClient nordigenApiClient;


    @Test
    void getAllInstitutions() {
        var institutions = nordigenApiClient.institutionsResourceConsumer.getAllInstitutions(institutionsRequest());

        assertNotNull(institutions);
    }

    private InstitutionsRequest institutionsRequest() {
        return new InstitutionsRequest(Country.RO, false);
    }
}
