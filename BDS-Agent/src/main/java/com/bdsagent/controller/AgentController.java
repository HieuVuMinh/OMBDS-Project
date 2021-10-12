package com.bdsagent.controller;

import com.bdsagent.dto.CustomerDTO;
import com.bdsagent.model.Agent;
import com.bdsagent.model.ResponseObject;
import com.bdsagent.service.AgentServiceImpl;
import com.bdsagent.service.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController {
    Logger logger = LoggerFactory.getLogger(AgentController.class);

    @Autowired
    AgentServiceImpl agentService;

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping("name/{name}")
    public Agent findByName(@PathVariable("name") String lastName){
        return agentService.findByLastName(lastName);
    }

    @GetMapping("allagent")
    public List<Agent> findAllAgent() {
        return agentService.findAll();
    }


    @GetMapping("/find-all-cus")
    public ResponseEntity<?>findAllCustomerAndRequirement(){

        List<CustomerDTO> c = new ArrayList<>();
        logger.info("Response data object: "+customerService.findAllCustomerAndRequirement());

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Trả dữ liệu thành công!", customerService.findAllCustomerAndRequirement())
        );
    }
}
