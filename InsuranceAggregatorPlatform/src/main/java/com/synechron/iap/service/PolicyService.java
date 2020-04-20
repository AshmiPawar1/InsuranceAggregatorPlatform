package com.synechron.iap.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.iap.exception.RecordNotFoundException;
import com.synechron.iap.model.Policy;
import com.synechron.iap.repository.PolicyRepository;

@Service
@Transactional
public class PolicyService {
	@Autowired
	PolicyRepository PolicyRepository;
	
	public Policy save(Policy policy) {
		return PolicyRepository.save(policy);
	}
		
	public List<Policy> findAll(){
		return PolicyRepository.findAll();
	}
	
	public Policy findOne(Long policyid) {
		
		Optional<Policy> policy = PolicyRepository.findById(policyid);
		if(policy.isPresent()) {
			return policy.get();
		}
		else
		  throw new RecordNotFoundException("Invalid Policy id :"+policyid+" RECORD NOT FOUND....");
		
     }
		
	public void delete(Policy policy) {
		PolicyRepository.delete(policy);
	}


}

