package com.example.bdsagent.controller;

import com.example.bdsagent.model.Agent;
import com.example.bdsagent.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController {


    @Autowired
    private AgentService agentService;


    @PostMapping()
    public Agent createAgent (@RequestBody Agent agent) {
        return agentService.createAgent(agent);
    }

    @GetMapping("{id}")
    public Agent findById(@PathVariable("id") Long id){

        return agentService.findById(id);
    }

    @GetMapping()
    public List<Agent> findAllAgent() {
        return agentService.findAll();
    }

}
