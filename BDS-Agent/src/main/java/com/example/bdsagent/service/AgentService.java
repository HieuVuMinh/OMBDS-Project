package com.example.bdsagent.service;

import com.example.bdsagent.model.Agent;
import com.example.bdsagent.repository.IAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService implements IAgentService{

    @Autowired
    private IAgentRepository agentRepository;

    @Override
    public Agent findById(Long id) {
        return agentRepository.findAgentById(id);
    }

    @Override
    public List<Agent> findAll() {
        return agentRepository.findAll();
    }
}
