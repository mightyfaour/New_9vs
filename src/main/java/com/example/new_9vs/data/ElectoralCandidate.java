package com.example.new_9vs.data;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(value = "ElectoralCandidate")
public class ElectoralCandidate {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
    private Long id;
    private String fullName;
    private VoteCategory voteCategory;
    private Long voteCount;

}
