package com.bdsagent.service;

import com.bdsagent.dto.CustomerDTO;

import java.util.List;

public interface ICustomerFakeService {
    List<CustomerDTO> findAllCustomerAndRequirement();
}
