package com.bdsagent.service;

import com.bdsagent.dto.CustomerDTO;
import com.bdsagent.repo.CustomerFakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerFakeService{

    @Autowired
    private CustomerFakeRepo customerFakeRepo;

    @Override
    public List<CustomerDTO> findAllCustomerAndRequirement() {
        return customerFakeRepo.findAll();
    }
}
