package com.roytuts.orchestrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.orchestrator.dto.OrderRequest;
import com.roytuts.orchestrator.service.OrchestratorService;

@RestController
@RequestMapping("/orchestrate")
public class OrchestratorController {

	@Autowired
	private OrchestratorService orchestratorService;

	@PostMapping
	public String orchestrateOrder(@RequestBody OrderRequest request) {
		return orchestratorService.processOrder(request);
	}
}
