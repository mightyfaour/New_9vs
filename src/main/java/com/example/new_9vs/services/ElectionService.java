package com.example.new_9vs.services;

import com.example.new_9vs.dto.request.AddVoteRequest;
import com.example.new_9vs.dto.response.AddVoteResponse;

public interface ElectionService {
    AddVoteResponse addVote(AddVoteRequest addVoteRequest);
}
