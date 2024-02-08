package com.drogo.spring.data.jpa.entity.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DeliveryAddress {

    private String houseNumber;
    private String streetName;
    private String pinCode;
    private String city;
}
