package nl.novi.techiteasy.controllers;

import nl.novi.techiteasy.services.CiModuleService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CiModuleController {

    private final CiModuleService ciModuleService;


    public CiModuleController(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }





}
