package com.webshop.model.dto;

import lombok.*;

//todo

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDto {
    private long id;
    private String street;
    private String zipCode;
    private String city;
    private String country;
}
