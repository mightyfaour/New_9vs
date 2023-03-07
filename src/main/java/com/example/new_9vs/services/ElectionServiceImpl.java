package com.example.new_9vs.services;

import com.example.new_9vs.dto.request.AddVoteRequest;
import com.example.new_9vs.dto.response.AddVoteResponse;
import com.example.new_9vs.repositories.ElectionVotersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class ElectionServiceImpl implements  ElectionService{

    private ElectionVotersRepository electionVotersRepository;

    @Override
    public AddVoteResponse addVote(AddVoteRequest addVoteRequest) {
        return null;
    }
}
