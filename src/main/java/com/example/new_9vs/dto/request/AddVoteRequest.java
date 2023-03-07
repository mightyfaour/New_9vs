package com.example.new_9vs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddVoteRequest {

    private String VoteCategory;
    private String BVN;
    private String password;


}
