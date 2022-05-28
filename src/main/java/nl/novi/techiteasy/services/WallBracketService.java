package nl.novi.techiteasy.services;

import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.techiteasy.models.WallBracket;
import nl.novi.techiteasy.models.dtos.WallBracketDto;
import nl.novi.techiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;


    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }


    public WallBracketDto addWallBracket(WallBracketDto wallBracketDto) {
        WallBracket wallBracket = transferToWallBracket(wallBracketDto);
        wallBracketRepository.save(wallBracket);
        return wallBracketDto;
    }

    public List<WallBracketDto> getAllWallBrackets() {
        List<WallBracket> wallBracketList = wallBracketRepository.findAll();
        List<WallBracketDto> wallBracketDtoList = new ArrayList<>();

        for(WallBracket wallBracket : wallBracketList){
            WallBracketDto wallBracketDto = transferToDto(wallBracket);
            wallBracketDtoList.add(wallBracketDto);
        }
        return wallBracketDtoList;
    }

    public WallBracketDto getWallBracketById(Long id) {
       Optional<WallBracket> wallBracket = wallBracketRepository.findById(id);

       if(wallBracket.isPresent()){
           return transferToDto(wallBracket.get());
       }
       else{
           throw new RecordNotFoundException("not found");
       }
    }

//    public WallBracketDto getWallBracketById(Long id){
//        if(wallBracketRepository.findById(id).isPresent()){
//
//            WallBracket wallBracket = wallBracketRepository.getById(id);
//            return transferToDto(wallBracket);
//        }
//        else{
//            throw new RecordNotFoundException("not found");
//        }
//    }

    public void deleteWallBracketById(Long id) {
        wallBracketRepository.deleteById(id);
    }



    // Bij deze methode kun je zelf kiezen welke velden worden aangepast. Als je een veld weglaat wordt het ook niet aangepast.
    public void updateWallBracket(Long id, WallBracketDto wallBracketDto) {
        if (!wallBracketRepository.existsById(id)) {
            throw new RecordNotFoundException("not found");
        }
            WallBracket wallBracketSave = wallBracketRepository.findById(id).orElse(null);

            wallBracketSave.setId(wallBracketDto.getId());
            wallBracketSave.setAjustable(wallBracketDto.getAjustable());
            wallBracketSave.setPrice(wallBracketDto.getPrice());
            wallBracketSave.setAjustable(wallBracketDto.getAjustable());
            wallBracketSave.setName(wallBracketDto.getName());
            wallBracketRepository.save(wallBracketSave);
    }

    // Bij deze update methode worden alle velden  aanpast
//    public void updateWallBracket(Long id, WallBracketDto wallBracketDto) {
//        if (wallBracketRepository.findById(id).isPresent()) {
//
//            WallBracket wallBracket = wallBracketRepository.findById(id).get();
//            WallBracket wallBracket1 = transferToWallBracket(wallBracketDto);
//            wallBracket1.setId(wallBracket.getId());
//            wallBracketRepository.save(wallBracket1);
//        }
//        else{
//            throw new RecordNotFoundException("not found");
//        }
//    }









    public WallBracket transferToWallBracket(WallBracketDto wallBracketDto){
        WallBracket wallBracket = new WallBracket();

        wallBracket.setId(wallBracketDto.getId());
        wallBracket.setName(wallBracketDto.getName());
        wallBracket.setPrice(wallBracketDto.getPrice());
        wallBracket.setAjustable(wallBracketDto.getAjustable());
        wallBracket.setSize(wallBracketDto.getSize());

        return wallBracket;
    }


    public WallBracketDto transferToDto(WallBracket wallBracket){
        WallBracketDto wallBracketDto = new WallBracketDto();

        wallBracketDto.setAjustable(wallBracket.getAjustable());
        wallBracketDto.setId(wallBracket.getId());
        wallBracketDto.setName(wallBracket.getName());
        wallBracketDto.setSize(wallBracket.getSize());
        wallBracketDto.setPrice(wallBracket.getPrice());

        return wallBracketDto;
    }



}
