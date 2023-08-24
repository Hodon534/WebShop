package com.webshop.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ManufacturerDto {
    private long id;
    private String name;
    private AddressDto address;
    private String taxCode;
}
