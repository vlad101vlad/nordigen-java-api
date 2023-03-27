package com.vladraresraducu.nordigenjavaapi.agreements;

import com.vladraresraducu.nordigenjavaapi.NordigenApiClient;
import com.vladraresraducu.nordigenjavaapi.agreements.model.EndUserAgreementRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AgreementsResourceConsumerTest {
    @Autowired
    private NordigenApiClient nordigenApiClient;

    @Test
    void createEnduserAgreement() {
        var createdAgreement = nordigenApiClient.agreementsResourceConsumer.createEnduserAgreement(endUserAgreementRequest());
        assertNotNull(createdAgreement);

        cleanupAgreement(createdAgreement.getId());
    }


    @Test
    void getEndUserAgreement() {
        var agreement = nordigenApiClient.agreementsResourceConsumer.getEndUserAgreement();

        assertNotNull(agreement);
    }

    @Test
    void deleteEnduserAgreement() {
        var allAgreementsStart = nordigenApiClient.agreementsResourceConsumer.getEndUserAgreement();
        assertNotNull(allAgreementsStart);
        var newAgreement = nordigenApiClient.agreementsResourceConsumer.createEnduserAgreement(endUserAgreementRequest());
        assertNotNull(newAgreement);
        var allAgreementsAfterOneCreation = nordigenApiClient.agreementsResourceConsumer.getEndUserAgreement();
        assertNotNull(allAgreementsAfterOneCreation);
        assertEquals(allAgreementsAfterOneCreation.getCount(), allAgreementsStart.getCount() + 1);

        nordigenApiClient.agreementsResourceConsumer.deleteEnduserAgreement(newAgreement.getId());
        var allAgreementsAfterDeletion = nordigenApiClient.agreementsResourceConsumer.getEndUserAgreement();
        assertNotNull(allAgreementsAfterDeletion);
        assertEquals(allAgreementsAfterDeletion.getCount(), allAgreementsStart.getCount());
    }

    @Test
    void testGetEndUserAgreement() {
        var createdAgreement = nordigenApiClient.agreementsResourceConsumer.createEnduserAgreement(endUserAgreementRequest());
        assertNotNull(createdAgreement);
        var foundAgreement = nordigenApiClient.agreementsResourceConsumer.getEndUserAgreement(createdAgreement.getId());
        assertNotNull(foundAgreement);
        assertEquals(foundAgreement.getId(), createdAgreement.getId());

        cleanupAgreement(createdAgreement.getId());
    }

    private void cleanupAgreement(String id) {
        nordigenApiClient.agreementsResourceConsumer.deleteEnduserAgreement(id);
    }

    private EndUserAgreementRequest endUserAgreementRequest() {
        return new EndUserAgreementRequest("SANDBOXFINANCE_SFIN0000");
    }
}
