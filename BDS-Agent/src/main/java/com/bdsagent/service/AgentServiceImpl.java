package com.bdsagent.service;

import com.bdsagent.model.Agent;
import com.bdsagent.repo.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements IAgentService{

    @Autowired
    AgentRepo agentRepo;

    @Override
    public Agent findByLastName(String lastName) {
        return agentRepo.findByLastName(lastName);
    }

    @Override
    public List<Agent> findAll() {
        return agentRepo.findAll();
    }
}
