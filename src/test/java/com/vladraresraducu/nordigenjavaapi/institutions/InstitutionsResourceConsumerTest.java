package com.vladraresraducu.nordigenjavaapi.institutions;

import com.vladraresraducu.nordigenjavaapi.NordigenApiClient;
import com.vladraresraducu.nordigenjavaapi.enums.Country;
import com.vladraresraducu.nordigenjavaapi.institutions.model.InstitutionsRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InstitutionsResourceConsumerTest {
    @Autowired
    private NordigenApiClient nordigenApiClient;


    @Test
    void getAllInstitutions() {
        var institutions = nordigenApiClient.institutionsResourceConsumer.getAllInstitutions(institutionsRequest());

        assertNotNull(institutions);
        assertTrue(Arrays.stream(institutions).findAny().isPresent());
        assertFalse(Arrays.stream(institutions).findAny().get().getId().isEmpty());
    }

    private InstitutionsRequest institutionsRequest() {
        return new InstitutionsRequest(Country.AT, false);
    }

    @Test
    void getInstitution() {
        final String SANDBOX_ID = "SANDBOXFINANCE_SFIN0000";

        var institution = nordigenApiClient.institutionsResourceConsumer.getInstitution(SANDBOX_ID);

        assertNotNull(institution);
        assertFalse(institution.getName().isEmpty());
    }
}
