package com.example.new_9vs.repositories;

import com.example.new_9vs.data.ElectoralCandidate;
import com.example.new_9vs.data.VoteCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ElectoralCandidateRepository extends MongoRepository<ElectoralCandidate, Long> {

    ElectoralCandidate findCandidateByVoteCategory(VoteCategory voteCategory);
    List<ElectoralCandidate> findCandidateByVoteCategory(VoteCategory voteCategory);

}
