package nl.novi.techiteasy.services;
import nl.novi.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.techiteasy.models.Remote;
import nl.novi.techiteasy.models.dtos.RemoteDto;
import nl.novi.techiteasy.repositories.RemoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteService {

    private final RemoteRepository remoteRepository;

    public RemoteService(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }



    public RemoteDto addRemote(RemoteDto remoteDto) {
        // opvangen in new entiry
        Remote remote = transferToRemote(remoteDto);
        // opslaan in repo
        remoteRepository.save(remote);
        return remoteDto;
    }


    public List<RemoteDto> getAllRemotes() {
        List<Remote> remoteList = remoteRepository.findAll();
        List<RemoteDto> remoteDtoList = new ArrayList<>();

        for ( Remote remote : remoteList){
        RemoteDto remoteDto = transferToDto(remote);
        remoteDtoList.add(remoteDto);
        }
        return remoteDtoList;
    }

    public RemoteDto getRemoteById(Long id) {
    Optional<Remote> remoteDto = remoteRepository.findById(id);
    if(remoteDto.isPresent()){
        return transferToDto(remoteDto.get());
    }
    else {
        throw new RecordNotFoundException("not found");
    }
    }

    public void deleteRemote(Long id) {
        remoteRepository.deleteById(id);
    }

    public void updateRemote(Long id, RemoteDto remoteDto) {
        if(!remoteRepository.existsById(id)){
            throw new RecordNotFoundException("not found");
        }
        Remote storedRemote = remoteRepository.findById(id).orElse(null);
        storedRemote.setId(remoteDto.getId());
        storedRemote.setBrand(remoteDto.getBrand());
        storedRemote.setBatteryType(remoteDto.getBatteryType());
        storedRemote.setName(remoteDto.getName());
        storedRemote.setPrice(remoteDto.getPrice());
        storedRemote.setOriginalStock(remoteDto.getOriginalStock());
        storedRemote.setCompatibleWith(remoteDto.getCompatibleWith());
        remoteRepository.save(storedRemote);
        }











    public Remote transferToRemote(RemoteDto remoteDto){
        Remote addRemote = new Remote();

        addRemote.setCompatibleWith(remoteDto.getCompatibleWith());
        addRemote.setPrice(remoteDto.getPrice());
        addRemote.setName(remoteDto.getName());
        addRemote.setBrand(remoteDto.getBrand());
        addRemote.setOriginalStock(remoteDto.getOriginalStock());
        addRemote.setBatteryType(remoteDto.getBatteryType());
        addRemote.setId(remoteDto.getId());

        return addRemote;
    }



    public RemoteDto transferToDto(Remote remote){
        RemoteDto remoteDto = new RemoteDto();

        remoteDto.setCompatibleWith(remote.getCompatibleWith());
        remoteDto.setPrice(remote.getPrice());
        remoteDto.setName(remote.getName());
        remoteDto.setBrand(remote.getBrand());
        remoteDto.setOriginalStock(remote.getOriginalStock());
        remoteDto.setBatteryType(remote.getBatteryType());
        remoteDto.setId(remote.getId());

        return remoteDto;
    }



}
