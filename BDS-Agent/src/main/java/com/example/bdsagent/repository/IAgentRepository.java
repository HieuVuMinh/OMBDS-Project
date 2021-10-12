package com.example.bdsagent.repository;

import com.example.bdsagent.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgentRepository extends JpaRepository<Agent, Long> {
    Agent findAgentById (Long id);
}
