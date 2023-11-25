package com.prgrms.jpaweekly;

import com.prgrms.jpaweekly.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
