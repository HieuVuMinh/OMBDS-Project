package com.bdsagent.service;

import com.bdsagent.model.Agent;

import java.util.List;

public interface IAgentService {

    Agent findByLastName (String name);
    List<Agent> findAll ();
}
