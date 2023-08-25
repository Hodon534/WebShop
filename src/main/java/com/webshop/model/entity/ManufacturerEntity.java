package com.webshop.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Entity class representing a manufacturer.
 */
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "manufacturers")
public class ManufacturerEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    //@JdbcTypeCode(SqlTypes.JSON)
    @JoinColumn(name = "address_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private AddressEntity address;
    @Column(name = "tax_code")
    private String taxCode;

    public ManufacturerEntity(String name, AddressEntity address, String taxCode) {
        this.name = name;
        this.address = address;
        this.taxCode = taxCode;
    }
}
