package nl.novi.techiteasy.services;

import nl.novi.techiteasy.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

@Service
public class CiModuleService {

    private final CiModuleRepository ciModuleRepository;

    public CiModuleService(CiModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;


    }
}
