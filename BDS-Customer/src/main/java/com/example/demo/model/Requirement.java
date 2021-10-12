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
@Document("Requirement")
@ToString
public class Requirement {
    @Id
    private String requirement_id;

    private double price;

    private String surface_area;

    private double bedroom;

    private String address;

    private String information;
}
