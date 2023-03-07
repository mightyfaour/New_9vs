package com.example.new_9vs.controller;

import com.example.new_9vs.dto.request.AddVoteRequest;
import com.example.new_9vs.dto.response.AddVoteResponse;
import com.example.new_9vs.exception.VoterException;
import com.example.new_9vs.services.ContactService;
import com.example.new_9vs.services.ElectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/election/")
@RequiredArgsConstructor
public class ElectionController {

        @Autowired
        private ElectionService electionService;
        @Autowired
        private ContactService contactService;

        @PostMapping("/vote")
        public ResponseEntity<?> addVote(@RequestBody AddVoteRequest addVoteRequest) throws VoterException, IOException {
                AddVoteResponse addVoteResponse = contactService.addVote(addVoteRequest);
                return ResponseEntity.status(HttpStatus.OK).body(addVoteResponse);
        }
}
