
package com.synechron.iap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synechron.iap.model.Policy;
public interface PolicyRepository extends JpaRepository<Policy, Long> {

}
