package com.webshop.model.dto;

import lombok.*;

import java.util.List;

/**
 * A Data Transfer Object (DTO) representing a user's information.
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private long id;
    private String username;
    private String appUserRole;
    private AddressDto address;
    private long phoneNumber;
    private List<OrderDto> orders;
}
