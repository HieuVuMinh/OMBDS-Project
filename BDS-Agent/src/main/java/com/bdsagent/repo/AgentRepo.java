package com.bdsagent.repo;

import com.bdsagent.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepo extends JpaRepository<Agent, Long> {

    Agent findByLastName (String lastName);
}
