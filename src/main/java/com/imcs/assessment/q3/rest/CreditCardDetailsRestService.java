/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imcs.assessment.q3.rest;

import com.imcs.assessment.q1.models.CreditCardDetails;

/**
 *
 * @author Avishek
 */
public interface CreditCardDetailsRestService {
    
    /**
     *  This is the URL with which the entire process can be operated through 
     *  the implementation class.
     */
    final String REDIRECT_URL = "http://localhost:8081/rest/creditcard";
    
    public CreditCardDetails getCreditCardById(int profile_id);
    public boolean createCreditCard(CreditCardDetails card);
    public boolean updateCreditCard(CreditCardDetails card);
    public boolean deleteCreditCard(int profile_id);
}
