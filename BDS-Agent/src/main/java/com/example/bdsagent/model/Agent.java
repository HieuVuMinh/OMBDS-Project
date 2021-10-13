package com.example.bdsagent.model;

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
@Table(name = "agents")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId;

    private String firstName;

    private String lastName;

    private String suportType;

    private Long customerId;
}
