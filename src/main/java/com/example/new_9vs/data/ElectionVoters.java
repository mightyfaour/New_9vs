package com.example.new_9vs.data;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@Document
@Getter
@Setter
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Election_Voters")
public class ElectionVoters {
//    @Getter(AccessLevel.NONE)
//    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    private String username;
    @NonNull
    private String first_name;
    @NonNull
    private String middle_name;
    @NonNull
    private  String last_name;
    @NonNull
    private String email;
    @NonNull
    private  String phone_number;
    @NonNull
    private Gender gender;
    @NonNull
    private String profilePicture_url;
    @NonNull
    private String password;

    private String date_of_birth;

    private String BVN;

    private String address;

    private String phoneNumber;

    private String profileImageUrl;

    private String nationality;

    private boolean hasVoted;


}
