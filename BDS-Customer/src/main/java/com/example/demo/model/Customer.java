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
@Document("Customer")
@ToString
public class Customer {
    @Id
    private String customer_id;

    private String customer_name;

    private String customer_phone;

    private String customer_email;

    private Apartment[] apartments;

    private Requirement[] requirements;

    private Long agentId;
}
