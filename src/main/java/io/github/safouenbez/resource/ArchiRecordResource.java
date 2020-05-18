package io.github.safouenbez.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.safouenbez.ArchitectureRecord;
import io.github.safouenbez.service.ArchitectureDRService;

@RequestMapping("architecture/records")
public class ArchiRecordResource {

	@Autowired
	ArchitectureDRService service;

	@GetMapping
	public @ResponseBody List<ArchitectureRecord> generateArchitectRecords() {
		return service.generateAR();
	}

}
