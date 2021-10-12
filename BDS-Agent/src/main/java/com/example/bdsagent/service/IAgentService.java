package com.example.bdsagent.service;


import com.example.bdsagent.model.Agent;

import java.util.List;

public interface IAgentService {

    Agent findById (Long id);

    List<Agent> findAll ();

}
