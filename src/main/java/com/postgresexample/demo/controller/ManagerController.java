package com.postgresexample.demo.controller;

import com.postgresexample.demo.payload.ManagerDto;
import com.postgresexample.demo.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manager")
public class ManagerController {

    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping
    public ResponseEntity<ManagerDto> addManager(@RequestBody ManagerDto dto){
        ManagerDto managerDto = managerService.addManager(dto);
        return new ResponseEntity<>(managerDto, HttpStatus.CREATED);
    }
}
