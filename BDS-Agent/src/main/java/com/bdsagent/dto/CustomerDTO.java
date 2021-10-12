package com.bdsagent.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "customerfakes")
public class CustomerDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String customerName;

    private String customerPhone;

    private String customerEmail;

    private double price;

    private String surface_area;

    private double bedroom;

    private String address;

    private String information;

    private Long agent_id;
}
