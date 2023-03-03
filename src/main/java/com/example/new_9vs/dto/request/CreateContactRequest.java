package com.example.new_9vs.dto.request;

//import com.example.diary.model.data.Gender;
import com.example.new_9vs.data.Gender;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateContactRequest {
    private String username;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String email;
    private String phone_number;
    private Gender gender;
    private String profile_picture_url;
    private MultipartFile image;
    private String password;
}
