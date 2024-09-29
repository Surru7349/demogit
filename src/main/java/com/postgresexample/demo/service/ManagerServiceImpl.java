package com.postgresexample.demo.service;

import com.postgresexample.demo.entity.Manager;
import com.postgresexample.demo.payload.ManagerDto;
import com.postgresexample.demo.repository.ManagerRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService{

    private ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public ManagerDto addManager(ManagerDto dto) {
        Manager manager =  mapToEntity(dto);
        Manager managers = managerRepository.save(manager);
        ManagerDto managerDto = mapToDto(managers);
        return managerDto;
    }

    private ManagerDto mapToDto(Manager managers) {
        ManagerDto dto = new ManagerDto();
        dto.setId(managers.getId());
        dto.setName(managers.getName());
        dto.setEmail(managers.getEmail());
        return dto;
    }

    private Manager mapToEntity(ManagerDto dto) {
        Manager manager = new Manager();
        manager.setName(dto.getName());
        manager.setEmail(dto.getEmail());
        return manager;
    }
}
