package com.example.new_9vs.services;

//import com.example.diary.dto.request.CreateContactRequest;
//import com.example.diary.dto.request.UpdateContactRequest;
//import com.example.diary.dto.response.CreateContactResponse;
//import com.example.diary.dto.response.DeleteContactResponse;
//import com.example.diary.dto.response.UpdateContactResponse;
//import com.example.diary.exception.ContactException;
//import com.example.diary.model.data.Contact;
//import com.example.new_9vs.dto.response.CreateContactResponse;
//
import com.example.new_9vs.data.Contact;
import com.example.new_9vs.dto.request.CreateContactRequest;
import com.example.new_9vs.dto.request.UpdateContactRequest;
import com.example.new_9vs.dto.response.CreateContactResponse;
import com.example.new_9vs.dto.response.DeleteContactResponse;
import com.example.new_9vs.dto.response.UpdateContactResponse;
import com.example.new_9vs.exception.ContactException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ContactService {
    CreateContactResponse createContact(CreateContactRequest createContactRequest) throws ContactException, IOException;

    Contact findContactByUsername(String username) throws ContactException;

    List<Contact> getAllUsername() throws ContactException;

    List<Contact> getAllContact() throws ContactException;

    UpdateContactResponse updateContactDetails(UpdateContactRequest request) throws ContactException, InvocationTargetException, IllegalAccessException;

    DeleteContactResponse deleteContactByUsername(String username) throws ContactException ;
}
