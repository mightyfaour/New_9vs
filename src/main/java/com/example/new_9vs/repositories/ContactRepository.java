package com.example.new_9vs.repositories;

//import com.example.diary.model.data.ElectionVoters;
import com.example.new_9vs.data.ElectionVoters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ContactRepository extends JpaRepository<ElectionVoters, Long>{

    Optional<ElectionVoters> findContactByUsername(String username);

    void deleteContactByUsername(String valueOf);
}
