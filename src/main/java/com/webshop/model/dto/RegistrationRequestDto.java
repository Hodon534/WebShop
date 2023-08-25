package com.webshop.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * A Data Transfer Object (DTO) representing a user's registration request.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegistrationRequestDto {
    @Email(message = "Enter a proper email address")
    private String username;
    @Size(min = 8, max = 65, message = "password length has to be between 8 and 65 characters")
    private String password;
    @NotNull(message = "you have to enter your first name")
    private String firstName;
    @NotNull(message = "you have to enter your last name")
    private String lastName;
    private AddressDto address;
    @NotNull(message = "you have to enter your phone number")
    private long phoneNumber;

}
