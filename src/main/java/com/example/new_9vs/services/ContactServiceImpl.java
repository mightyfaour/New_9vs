package com.example.new_9vs.services;

import com.cloudinary.utils.ObjectUtils;
//import com.example.diary.dto.request.CreateContactRequest;
//import com.example.diary.dto.request.UpdateContactRequest;
//import com.example.diary.dto.response.CreateContactResponse;
//import com.example.diary.dto.response.DeleteContactResponse;
//import com.example.diary.dto.response.UpdateContactResponse;
//import com.example.diary.exception.ContactException;
//import com.example.diary.model.data.ElectionVoters;
//import com.example.diary.repositories.ContactRepository;
import com.example.new_9vs.data.ElectionVoters;
import com.example.new_9vs.dto.request.AddVoteRequest;
import com.example.new_9vs.dto.request.CreateContactRequest;
import com.example.new_9vs.dto.request.UpdateContactRequest;
import com.example.new_9vs.dto.response.AddVoteResponse;
import com.example.new_9vs.dto.response.CreateContactResponse;
import com.example.new_9vs.dto.response.DeleteContactResponse;
import com.example.new_9vs.dto.response.UpdateContactResponse;
import com.example.new_9vs.exception.ContactException;
import com.example.new_9vs.repositories.ContactRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository;
    private final CloudService cloudService;


    @Override
    public AddVoteResponse addVote(AddVoteRequest addVoteRequest) throws ContactException, IOException {
        Optional<ElectionVoters> optionalElectionVoters = contactRepository.findContactById(addVoteRequest.getId());
        if (optionalElectionVoters. && userVoteCount ==0){
            voting = ElectionVoters.vote();
        }
        return CreateContactResponse.builder()
                .successful(true)
                .id(saveElectionVoters.getId())
                .build();
    }
    @Override
    public CreateContactResponse createContact(CreateContactRequest createContactRequest) throws ContactException, IOException {
        Optional<ElectionVoters> optionalContact = contactRepository.findContactByUsername(createContactRequest.getUsername());
        if (optionalContact.isPresent()){
            throw new ContactException("ElectionVoters with Username "+createContactRequest.getUsername()+" already exist", 400);
        }
        ElectionVoters electionVoters = buildContact(createContactRequest);
        if(createContactRequest.getImage() != null){
            Map<?,?> uploadResult = cloudService.upload(createContactRequest.getImage().getBytes(),
                    ObjectUtils.asMap("public_id", "profile_image/" + createContactRequest.getImage().getOriginalFilename(),
                            "overwrite", true
                    ));
            electionVoters.setProfilePicture_url(uploadResult.get("url").toString());
        }
        ElectionVoters saveElectionVoters = contactRepository.save(electionVoters);
        return CreateContactResponse.builder()
                .successful(true)
                .id(saveElectionVoters.getUsername())
                .build();
    }



    private ElectionVoters buildContact(CreateContactRequest createContactRequest) {
        return ElectionVoters.builder()
                .username(createContactRequest.getUsername())
                .first_name(createContactRequest.getFirst_name())
                .middle_name(createContactRequest.getMiddle_name())
                .last_name(createContactRequest.getLast_name())
                .email(createContactRequest.getEmail())
                .phone_number(createContactRequest.getPhone_number())
                .gender(createContactRequest.getGender())
                .password(createContactRequest.getPassword())
                .build();
    }

//    public List<ElectionVoters> getAllContact(){
//        return contactRepository.findAll();
//    }

    @Override
    public ElectionVoters findContactByUsername(String username) throws ContactException {
        Optional<ElectionVoters> foundContact = contactRepository.findContactByUsername(String.valueOf(username));
        if (foundContact.isEmpty()) {
            throw new ContactException("ElectionVoters with Username " + username + " does not exist", 404);
        }
        return foundContact.get();
    }

    @Override
    public List<ElectionVoters> getAllUsername() throws ContactException {
        return null;
    }

    @Override
    public DeleteContactResponse deleteContactByUsername(String username) throws ContactException {
        Optional<ElectionVoters> foundContact = contactRepository.findContactByUsername(String.valueOf(username));

        if (foundContact.isEmpty()) {
            log.info("found contact is after repo search ====> null o");
            throw new ContactException("ElectionVoters with Username " + username + " does not exist", 404);
        }
//        contactRepository.deleteContactByUsername(String.valueOf(username));
        log.info("found contact is ====> "+foundContact.get());
        contactRepository.delete(foundContact.get());
        return new DeleteContactResponse(true);
    }

    @Override
    public List<ElectionVoters> getAllContact(){
        return contactRepository.findAll();
    }

    @Override
    public UpdateContactResponse updateContactDetails(UpdateContactRequest updateContactRequest) throws ContactException, InvocationTargetException, IllegalAccessException {
        Optional<ElectionVoters> foundContact = contactRepository.findContactByUsername(String.valueOf(updateContactRequest.getUsername()));
        if (foundContact.isEmpty()){
            throw new ContactException("ElectionVoters with Username: "+updateContactRequest.getUsername()+" does not exist", 404);
        }
        ElectionVoters electionVoters = foundContact.get();
        electionVoters.setUsername(updateContactRequest.getUsername());
        electionVoters.setFirst_name(updateContactRequest.getFirst_name());
        electionVoters.setMiddle_name(updateContactRequest.getMiddle_name());
        electionVoters.setLast_name(updateContactRequest.getLast_name());
        electionVoters.setEmail(updateContactRequest.getEmail());
        electionVoters.setPassword(updateContactRequest.getPassword());
        electionVoters.setGender(updateContactRequest.getGender());
        electionVoters.setPhone_number(updateContactRequest.getPhone_number());
        electionVoters.setGender(updateContactRequest.getGender());
        contactRepository.save(electionVoters);
        UpdateContactResponse updateContactResponse = new UpdateContactResponse();
        BeanUtils.copyProperties(updateContactResponse, electionVoters);
        return updateContactResponse;
    }


}
