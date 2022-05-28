package nl.novi.techiteasy.controllers;

import nl.novi.techiteasy.models.WallBracket;
import nl.novi.techiteasy.models.dtos.RemoteDto;
import nl.novi.techiteasy.models.dtos.WallBracketDto;
import nl.novi.techiteasy.services.WallBracketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WallBracketController {

    private final WallBracketService wallBracketService;


    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

@PostMapping("/wallbrackets")
        public WallBracketDto addWallBracket(@RequestBody WallBracketDto wallBracketDto){
        wallBracketService.addWallBracket(wallBracketDto);
        return wallBracketDto;
}

@GetMapping("/wallbrackets")
        public List<WallBracketDto> getAllWallBrackets(){
        List<WallBracketDto> wallBracketsDto = wallBracketService.getAllWallBrackets();
        return wallBracketsDto;
}


@GetMapping("/wallbrackets/{id}")
        public WallBracketDto getWallBracketById(@PathVariable ("id") Long id){
        WallBracketDto wallBracketDto = wallBracketService.getWallBracketById(id);
        return wallBracketDto;
}


@DeleteMapping("/wallbrackets/{id}")
        public void deleteWallBracketById(@PathVariable("id") Long id){
        wallBracketService.deleteWallBracketById(id);
}


@PutMapping("/wallbrackets/{id}")
        public WallBracketDto updateWallBracket(@PathVariable("id") Long id, @RequestBody WallBracketDto wallBracketDto){
        wallBracketService.updateWallBracket(id, wallBracketDto);
        return wallBracketDto;
}


}
