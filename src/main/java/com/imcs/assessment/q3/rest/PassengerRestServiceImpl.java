/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imcs.assessment.q3.rest;

import com.imcs.assessment.q1.models.PassengerProfile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * This Class provides the Rest Service for the Passenger Views
 * The operations supported by this class are as follows:
 * 1.     getPassengerProfileById(int profileId): Returns the profile of the passenger.
 * 2.     createPassengerProfile(PassengerProfile profile): Creates the profile of a passenger and returns success status.
 * 3.     updatePassengerProfile(PassengerProfile profile): Updates the information of a passenger and returns success status.
 * 4.     deletePassengerProfile(int profileId): Deletes the passenger information from the database.
 * @author Avishek
 */

@Service
public class PassengerRestServiceImpl implements PassengerRestService {

    RestTemplate restTemplate = new RestTemplate();
    
    /**
     * Returns the profile of the passenger when searched by the ID.
     * @param profileId: contains the ID of the passenger for whom the data is being retrieved.
     * @return PassengerProfile object containing the information of the passenger.
     */
    @Override
    public PassengerProfile getPassengerProfileById(int profileId) {
        ResponseEntity respPassengerEntity = restTemplate.getForEntity(REDIRECT_URL + "/findbyid" + Integer.toString(profileId), PassengerProfile.class);
        
        return respPassengerEntity.getStatusCode() == HttpStatus.OK ? (PassengerProfile) respPassengerEntity.getBody(): null;
    }

    /**
     * Adds a new passenger to the existing list of passengers
     * @param profile: contains the PassengerProfile object containing the information of the passenger
     * @return boolean status of addition of data to the database.
     */
    @Override
    public boolean createPassengerProfile(PassengerProfile profile) {
        HttpEntity<PassengerProfile> passengerRequest = new HttpEntity(profile);
        ResponseEntity<PassengerProfile> passengerResponseEntity = restTemplate.postForEntity(REDIRECT_URL + "/add", passengerRequest, PassengerProfile.class);

        return passengerResponseEntity.getStatusCode() == HttpStatus.OK;
    }

    /**
     * Updates the information of a Passenger in the database.
     * @param profile: contains the PassegerProfile object containing the information of the passenger.
     * @return boolean status of the update operation of the data to the database.
     */
    @Override
    public boolean updatePassengerProfileById(PassengerProfile profile) {
        HttpEntity<PassengerProfile> passengerRequest = new HttpEntity(profile);
        ResponseEntity<PassengerProfile> passengerResponseEntity = restTemplate.exchange(REDIRECT_URL + "/update", HttpMethod.PUT, passengerRequest, PassengerProfile.class);
        return passengerResponseEntity.getStatusCode() == HttpStatus.OK;
    }

    /**
     * Deletes the information of an existing Passenger from the database.
     * @param profileId is the ID of the Passenger who's information is to be removed.
     * @return boolean status of the delete operation from the database.
     */
    @Override
    public boolean deletePassengerProfileById(int profileId) {
        ResponseEntity<PassengerProfile> passengerResponseEntity = restTemplate.exchange(REDIRECT_URL + "/delete" + Integer.toString(profileId), HttpMethod.DELETE, null, PassengerProfile.class);
        return passengerResponseEntity.getStatusCode() == HttpStatus.OK;
    }
    
}
