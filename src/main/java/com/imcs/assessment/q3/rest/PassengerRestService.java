/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imcs.assessment.q3.rest;

import com.imcs.assessment.q1.models.PassengerProfile;

/**
 *
 * @author Avishek
 */
public interface PassengerRestService {
    
    /**
     *  This is the URL with which the entire process can be operated through 
     *  the implementation class.
     */
    final String REDIRECT_URL = "http://localhost:8081/rest/passengerop";
    
    public PassengerProfile getPassengerProfileById(int profileId);
    public boolean createPassengerProfile(PassengerProfile profile);
    public boolean updatePassengerProfileById(PassengerProfile profile);
    public boolean deletePassengerProfileById(int profileId);
}
