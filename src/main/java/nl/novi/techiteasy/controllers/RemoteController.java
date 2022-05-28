package nl.novi.techiteasy.controllers;

import nl.novi.techiteasy.models.dtos.RemoteDto;
import nl.novi.techiteasy.models.dtos.TelevisionDto;
import nl.novi.techiteasy.services.RemoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RemoteController {

    private final RemoteService remoteService;

    public RemoteController(RemoteService remoteService) {
        this.remoteService = remoteService;
    }


    @PostMapping("/remotes")
    public RemoteDto addRemote(@RequestBody RemoteDto remoteDto){
        RemoteDto remoteAdded = remoteService.addRemote(remoteDto);
        return remoteAdded;
    }


    @GetMapping("/remotes")
        public List<RemoteDto> getAllRemotes(){
        List<RemoteDto> listDto = remoteService.getAllRemotes();
            return listDto;
    }

    @GetMapping("/remotes/{id}")
    public RemoteDto getRemoteById(@PathVariable ("id") Long id){
       RemoteDto remoteDto = remoteService.getRemoteById(id);
       return remoteDto;
    }


    @DeleteMapping("/remotes/{id}")
    public void deleteRemote(@PathVariable ("id") Long id){
            remoteService.deleteRemote(id);
    }


    @PutMapping("/remotes/{id}")
        public RemoteDto updateRemote(@PathVariable ("id") Long id, @RequestBody RemoteDto remoteDto){
        remoteService.updateRemote(id, remoteDto);
        return remoteDto;
    }



}
