package com.webshop.model.dto;

import lombok.*;

import java.util.List;

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
