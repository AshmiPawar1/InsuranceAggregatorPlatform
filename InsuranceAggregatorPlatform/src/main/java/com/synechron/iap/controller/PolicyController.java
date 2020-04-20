package com.synechron.iap.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.iap.exception.RecordNotFoundException;
import com.synechron.iap.model.*;
import com.synechron.iap.service.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Api(value = "PolicyController", description = "REST APIs related to Policy Entity!!!!")
@RestController
@RequestMapping("/aggregator")
public class PolicyController {

	@Autowired
	PolicyService PolicyService;
	
	@GetMapping("/welcome")
	public String showMessage() {
		return "welcome";
	}
 
	/* to save an Policy */
	 @ApiOperation(value = "Post specific Policy in the System ", response = Policy.class, tags = "postPolicy")

	@PostMapping("/policy")
	public Policy createPolicy(@Valid @RequestBody Policy policy) {
		return PolicyService.save(policy);
	}

	/* get all Policys */
	@ApiOperation(value = "Get list of Policy in the System ", response = Iterable.class, tags = "getPolicy")

	@ApiResponses(value = {
			@ApiResponse(code = 200 ,message = "Success|Ok"),
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!")
		
	})
	
	@GetMapping(path = "/policy", produces = { "application/json" })
	public List<Policy> getAllPolicys() {

		return PolicyService.findAll();
	}
 
//	/* get Policy by policyid */
//	 @ApiOperation(value = "Get specific Policy in the System ", response = Policy.class, tags = "getPolicy")
//	
//	@GetMapping(path ="/Policys/{id}",produces = { "application/xml", "application/json" })
//	public Resource<Policy> getPolicyById(@PathVariable(value = "id") Long policyid) throws RecordNotFoundException {
//
//		Resource<Policy> resource = new Resource<Policy>(PolicyService.findOne(policyid));
//
//		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllPolicys());
//		ControllerLinkBuilder linkToo = linkTo(methodOn(this.getClass()).deletePolicy(policyid));
//
//		resource.add(linkTo.withRel("all policy"));
//		resource.add(linkToo.withRel("delete policy"));
//
//		if (resource.hasLinks()) {
//			return resource;
//
//		}
//		else
//			return null;
//
//	}

	/* update an Policy by policyid */
	
	 @ApiOperation(value = "Put specific Policy in the System ", response = Policy.class, tags = "putPolicy")
		
	 @PutMapping("/policy/{id}")
	public ResponseEntity<Policy> updatePolicy(@PathVariable(value = "id") Long policyid,
			@Valid @RequestBody Policy policyDetails) {

		Policy policy = PolicyService.findOne(policyid);
		if (policy == null) {
			return ResponseEntity.notFound().build();
		}

	//	policy.setName(policyDetails.getName());
//		policy.setDesignation(policyDetails.getDesignation());
//		policy.setExpertise(policyDetails.getExpertise());

		Policy updatePolicy = PolicyService.save(policy);

		return ResponseEntity.ok().body(updatePolicy);

	}

	/* Delete an Policy */
	
	 @ApiOperation(value = "Delete specific Policy in the System ", response = Policy.class, tags = "deletePolicy")
		
	 @DeleteMapping("/policy/{id}")
	public ResponseEntity<Policy> deletePolicy(@PathVariable(value = "id") Long policyid) {
 
		Policy policy = PolicyService.findOne(policyid);
		if (policy == null) {
            //throw new RecordNotFoundException("No Record Found");
			return ResponseEntity.notFound().build();
		}

		PolicyService.delete(policy); 

		return ResponseEntity.ok().build();

	}

}

