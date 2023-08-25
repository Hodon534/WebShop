package com.webshop.model.dto;

import lombok.*;

/**
 * A Data Transfer Object (DTO) representing manufacturer information.
 */
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
