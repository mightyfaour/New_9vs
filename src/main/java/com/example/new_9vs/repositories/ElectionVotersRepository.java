package com.example.new_9vs.repositories;

import com.example.new_9vs.data.ElectionVoters;
import com.example.new_9vs.data.ElectoralCandidate;
import com.example.new_9vs.data.VoteCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionVotersRepository extends MongoRepository<ElectoralCandidate, Long> {
    ElectoralCandidate findElectoralCandidateByVoteCategory(VoteCategory voteCategory);
    List<ElectoralCandidate> findCandidateByVoteCategory(VoteCategory voteCategory);
}
