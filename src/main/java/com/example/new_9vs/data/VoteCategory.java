package com.example.new_9vs.data;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "VoteCategory")
@Getter
@Setter
@Builder
public enum VoteCategory {
    PRESIDENCY;
}
