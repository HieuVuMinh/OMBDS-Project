package com.bdsagent.repo;

import com.bdsagent.dto.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerFakeRepo extends JpaRepository<CustomerDTO,Long> {
}
