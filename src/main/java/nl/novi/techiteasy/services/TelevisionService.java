package nl.novi.techiteasy.services;

import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.techiteasy.models.Television;
import nl.novi.techiteasy.models.dtos.TelevisionDto;
import nl.novi.techiteasy.models.dtos.TelevisionInputDto;
import nl.novi.techiteasy.repositories.RemoteRepository;
import nl.novi.techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final RemoteRepository remoteRepository;


    public TelevisionService(TelevisionRepository televisionRepository, RemoteRepository remoteRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteRepository = remoteRepository;
    }



    public TelevisionDto addTelevision(TelevisionInputDto televisionInputDto) {
        Television addTelevision = new Television();
        addTelevision = transferToTelevision(televisionInputDto);
        Television savedTelevision = televisionRepository.save(addTelevision);
        return transferToDto(savedTelevision);
    }

    public List<TelevisionDto> getAllTelevisions() {
            List<Television> tvList = televisionRepository.findAll();
            List<TelevisionDto> tvDtoList = new ArrayList<>();

            for(Television savedTv : tvList) {
                TelevisionDto toDto = transferToDto(savedTv);
                tvDtoList.add(toDto);
            }
            return tvDtoList;
        }


        // Zonder DTO
//    public List<Television> getAllTelevisions() {
//        List<Television> tvList = televisionRepository.findAll();
//        return tvList;
//    }

    public TelevisionDto getTelevisionById(Long id) {
        if (televisionRepository.findById(id).isPresent()) {

            Television television = televisionRepository.getById(id);
            return transferToDto(television);
        }
        else {
            throw new RecordNotFoundException("Television not found");
        }
    }


    public TelevisionDto updateTelevision(Long id, TelevisionInputDto televisionInputDto) {
        if(televisionRepository.findById(id).isPresent()) {
            Television television = televisionRepository.findById(id).get();
            Television television1 = transferToTelevision(televisionInputDto);
            television1.setId(television.getId());
            televisionRepository.save(television1);
            return transferToDto(television1);
        }
        else {
            throw new RecordNotFoundException("Television not found");
        }
    }

    public void deleteTelevions(Long id) {
        televisionRepository.deleteById(id);
    }









    public Television transferToTelevision(TelevisionInputDto televisionInputDto){
        Television addTelevision = new Television();

        addTelevision.setAmbiLight(televisionInputDto.getAmbiLight());
        addTelevision.setAvailableSize(televisionInputDto.getAvailableSize());
        addTelevision.setBluetooth(televisionInputDto.getBluetooth());
        addTelevision.setBrand(televisionInputDto.getBrand());
        addTelevision.setHdr(televisionInputDto.getHdr());
        addTelevision.setName(televisionInputDto.getName());
        addTelevision.setOriginalStock(televisionInputDto.getOriginalStock());
        addTelevision.setPrice(televisionInputDto.getPrice());
        addTelevision.setRefreshRate(televisionInputDto.getRefreshRate());
        addTelevision.setScreenQuality(televisionInputDto.getScreenQuality());
        addTelevision.setScreenType(televisionInputDto.getScreenType());
        addTelevision.setSmartTv(televisionInputDto.getSmartTv());
        addTelevision.setSold(televisionInputDto.getSold());
        addTelevision.setType(televisionInputDto.getType());
        addTelevision.setVoiceControl(televisionInputDto.getVoiceControl());
        addTelevision.setWifi(televisionInputDto.getWifi());


        return addTelevision;
    }


    public TelevisionDto transferToDto (Television savedTelevision){
        TelevisionDto televisionDto = new TelevisionDto();

        televisionDto.setId(savedTelevision.getId());
        televisionDto.setType(savedTelevision.getType());
        televisionDto.setBrand(savedTelevision.getBrand());
        televisionDto.setName(savedTelevision.getName());
        televisionDto.setPrice(savedTelevision.getPrice());
        televisionDto.setAvailableSize(savedTelevision.getAvailableSize());
        televisionDto.setRefreshRate(savedTelevision.getRefreshRate());
        televisionDto.setScreenType(savedTelevision.getScreenType());
        televisionDto.setScreenQuality(savedTelevision.getScreenQuality());
        televisionDto.setSmartTv(savedTelevision.getWifi());
        televisionDto.setWifi(savedTelevision.getWifi());
        televisionDto.setVoiceControl(savedTelevision.getVoiceControl());
        televisionDto.setHdr(savedTelevision.getHdr());
        televisionDto.setBluetooth(savedTelevision.getBluetooth());
        televisionDto.setAmbiLight(savedTelevision.getAmbiLight());
        televisionDto.setOriginalStock(savedTelevision.getOriginalStock());
        televisionDto.setSold(savedTelevision.getSold());



        return televisionDto;
    }




    // transfer to television
//    public TelevisionDto addTelevision(TelevisionInputDto televisionInputDto) {
//        Television addTelevision = new Television();
//
//        addTelevision.setAmbiLight(televisionInputDto.getAmbiLight());
//        addTelevision.setAvailableSize(televisionInputDto.getAvailableSize());
//        addTelevision.setBluetooth(televisionInputDto.getBluetooth());
//        addTelevision.setBrand(televisionInputDto.getBrand());
//        addTelevision.setHdr(televisionInputDto.getHdr());
//        addTelevision.setName(televisionInputDto.getName());
//        addTelevision.setOriginalStock(televisionInputDto.getOriginalStock());
//        addTelevision.setPrice(televisionInputDto.getPrice());
//        addTelevision.setRefreshRate(televisionInputDto.getRefreshRate());
//        addTelevision.setScreenQuality(televisionInputDto.getScreenQuality());
//        addTelevision.setScreenType(televisionInputDto.getScreenType());
//        addTelevision.setSmartTv(televisionInputDto.getSmartTv());
//        addTelevision.setSold(televisionInputDto.getSold());
//        addTelevision.setType(televisionInputDto.getType());
//        addTelevision.setVoiceControl(televisionInputDto.getVoiceControl());
//        addTelevision.setWifi(televisionInputDto.getWifi());
//
//        Television savedTelevision = televisionRepository.save(addTelevision);


            // Transfer to Dto
//        TelevisionDto televisionDto = new TelevisionDto();
//
//        televisionDto.setId(savedTelevision.getId());
//        televisionDto.setType(savedTelevision.getType());
//        televisionDto.setBrand(savedTelevision.getBrand());
//        televisionDto.setName(savedTelevision.getName());
//        televisionDto.setPrice(savedTelevision.getPrice());
//        televisionDto.setAvailableSize(savedTelevision.getAvailableSize());
//        televisionDto.setRefreshRate(savedTelevision.getRefreshRate());
//        televisionDto.setScreenType(savedTelevision.getScreenType());
//        televisionDto.setScreenQuality(savedTelevision.getScreenQuality());
//        televisionDto.setSmartTv(savedTelevision.getWifi());
//        televisionDto.setWifi(savedTelevision.getWifi());
//        televisionDto.setVoiceControl(savedTelevision.getVoiceControl());
//        televisionDto.setHdr(savedTelevision.getHdr());
//        televisionDto.setBluetooth(savedTelevision.getBluetooth());
//        televisionDto.setAmbiLight(savedTelevision.getAmbiLight());
//        televisionDto.setOriginalStock(savedTelevision.getOriginalStock());
//        televisionDto.setSold(savedTelevision.getSold());
//
//        return televisionDto;
//    }


    public void assignRemoteControllerToTelevision(Long id, Long remoteId){
        var optionalTelevision = televisionRepository.findById(id);
        var optionalRemote = remoteRepository.findById(remoteId);

        if(optionalTelevision.isPresent() && optionalRemote.isPresent()){
            var television = optionalTelevision.get();
            var remote = optionalRemote.get();

            television.setRemote(remote);
            televisionRepository.save(television);
        }else
            throw new RecordNotFoundException("not");

    }
}











