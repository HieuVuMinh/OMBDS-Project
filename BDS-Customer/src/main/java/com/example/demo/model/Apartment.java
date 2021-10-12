package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document("Apartment")
@ToString
public class Apartment {
    @Id
    private String apartmentId;

    private double price;

    private String type_apartment;

    private double bedroom;

    private String bathroom;

    private String surface_area;

    private String address;

    private String information;
}
