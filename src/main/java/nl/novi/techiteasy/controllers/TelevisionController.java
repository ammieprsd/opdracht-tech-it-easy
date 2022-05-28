package nl.novi.techiteasy.controllers;

import nl.novi.techiteasy.models.Television;
import nl.novi.techiteasy.models.dtos.IdInputDto;
import nl.novi.techiteasy.models.dtos.TelevisionDto;
import nl.novi.techiteasy.models.dtos.TelevisionInputDto;
import nl.novi.techiteasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }


    @GetMapping("/televisions")
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions(){
        List<TelevisionDto> listDto = televisionService.getAllTelevisions();
        return ResponseEntity.ok(listDto);
    }

//    // Zonder Dto
//    @GetMapping("/televisions")
//    public ResponseEntity<List<Television>> getAllTelevisions(){
//        List<Television> list = televisionService.getAllTelevisions();
//        return ResponseEntity.ok(list);
//    }


    @GetMapping("/televisions/{id}")
    public ResponseEntity<TelevisionDto> getTelevisionById(@PathVariable Long id){
        TelevisionDto televisionDto = televisionService.getTelevisionById(id);
        return ResponseEntity.ok().body(televisionDto);
    }


    @PostMapping("/televisions")
    public ResponseEntity<TelevisionDto> addTelevision(@RequestBody TelevisionInputDto televisionInputDto){
        TelevisionDto televisionAdded  = televisionService.addTelevision(televisionInputDto);
        return ResponseEntity.created(null).body(televisionAdded);
    }


    @PutMapping("/televisions/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto televisionInputDto){
    TelevisionDto televisionDto = televisionService.updateTelevision(id, televisionInputDto);
    return ResponseEntity.ok(televisionDto);
    }


    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<TelevisionDto> deleteTelevions(@PathVariable Long id ){
        televisionService.deleteTelevions(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/televisions/{id}/remotes")
    public void assignRemoteControllerToTelevision(@PathVariable("id") Long id, @RequestBody IdInputDto idInputDto){
    televisionService.assignRemoteControllerToTelevision(id, idInputDto.id);
    }

}

