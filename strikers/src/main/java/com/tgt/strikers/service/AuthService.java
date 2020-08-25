package com.tgt.strikers.service;

import com.google.api.client.auth.openidconnect.IdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.tgt.strikers.contact.Error;
import com.tgt.strikers.exception.UserRoleByEmailIdNotFoundException;
import com.tgt.strikers.model.UserRoleByEmailId;
import com.tgt.strikers.repository.AuthRepository;
import com.tgt.strikers.contact.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Optional;

//import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;
//import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.EMAIL;
import static com.tgt.strikers.constants.CricketApplicationConstants.*;


@Service
public class AuthService {
    @Autowired
    AuthRepository authRepository;
    public ResponseEntity authService(String idTokenString) throws GeneralSecurityException, IOException {

        try {
            HttpTransport transport = new NetHttpTransport();
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory).
                    setAudience(Arrays.asList(CLIENT_ID)).build();
            GoogleIdToken idToken = verifier.verify(idTokenString);
            if (idToken != null) {

                GoogleIdToken.Payload payload = idToken.getPayload();
                String email = (String) payload.get("email");
                String name = (String) payload.get("name");
                Optional<UserRoleByEmailId> role = authRepository.findById(email);

                if (role.get().getUserRole().equalsIgnoreCase(CABI_APPL_ADMIN)) {

                    Response response = new Response();
                    response.setName(name);
                    response.setRole(CABI_APPL_ADMIN);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else if (role.get().getUserRole().equalsIgnoreCase(CABI_APPL_SCORER)) {
                    Response response = new Response();
                    response.setName(name);
                    response.setRole(CABI_APPL_SCORER);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
                else if (role.get().getUserRole().equalsIgnoreCase(CABI_SITE_ADMIN)){
                    Response response = new Response();
                    response.setName(name);
                    response.setRole(CABI_SITE_ADMIN);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
            }
            else {
                Error error = new Error("INVALID_TOKEN");
                return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);//invalid token
            }
        }
        catch(Exception e){
            Error error = new Error("UNAUTHORISED_USER");
            return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED); //User does not have a role

        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

    }
}
