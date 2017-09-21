/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imcs.assessment.q3.rest;

import com.imcs.assessment.q1.models.CreditCardDetails;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreditCardDetailsRestServiceImpl implements CreditCardDetailsRestService {

    RestTemplate restTemplate = new RestTemplate();
    
    @Override
    public CreditCardDetails getCreditCardById(int profile_id) {
        ResponseEntity cardRestEntity = restTemplate.getForEntity(REDIRECT_URL + "/findbyid" + Integer.toString(profile_id), CreditCardDetails.class);
        
        return cardRestEntity.getStatusCode() == HttpStatus.OK ? (CreditCardDetails) cardRestEntity.getBody(): null;
    }

    @Override
    public boolean createCreditCard(CreditCardDetails card) {
        HttpEntity<CreditCardDetails> cardRequest = new HttpEntity(card);
        ResponseEntity<CreditCardDetails> cardRestEntity = restTemplate.postForEntity(REDIRECT_URL + "/add", cardRequest, CreditCardDetails.class);

        return cardRestEntity.getStatusCode() == HttpStatus.OK;
    }

    @Override
    public boolean updateCreditCard(CreditCardDetails card) {
        HttpEntity<CreditCardDetails> cardRequest = new HttpEntity(card);
        ResponseEntity<CreditCardDetails> cardRestEntity = restTemplate.exchange(REDIRECT_URL + "/update", HttpMethod.PUT, cardRequest, CreditCardDetails.class);
        return cardRestEntity.getStatusCode() == HttpStatus.OK;
    }

    @Override
    public boolean deleteCreditCard(int profile_id) {
        ResponseEntity<CreditCardDetails> cardResponseEntity = restTemplate.exchange(REDIRECT_URL + "/delete" + Integer.toString(profile_id), HttpMethod.DELETE, null, CreditCardDetails.class);
        return cardResponseEntity.getStatusCode() == HttpStatus.OK;
    }    
}
