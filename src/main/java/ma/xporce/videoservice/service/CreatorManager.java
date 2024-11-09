package ma.xporce.videoservice.service;

import ma.xporce.videoservice.dao.entities.Creator;
import ma.xporce.videoservice.dao.repositories.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CreatorManager implements CreatorService{

    @Autowired
    private CreatorRepository creatorRepository;

    @Override
    public Creator addCreator(Creator creator) {
        if(creator.getName()!=null && !creator.getName().trim().isEmpty() && creator.getEmail()!=null && !creator.getEmail().trim().isEmpty()){
            creatorRepository.save(creator);
            return creator;
        }
        return null;
    }

    @Override
    public Creator updateCreator(Integer id, Creator creator) {
        if (Objects.equals(creator.getId(), id)) {
            creatorRepository.deleteById(id);
            return addCreator(creator);
        }
        return null;
    }

    @Override
    public Creator deleteCreator(Creator creator) {
        try {
            creatorRepository.deleteById(creator.getId());
            return creator;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Creator getCreator(Integer creatorId) {
        return creatorRepository.findById(creatorId).get();
    }

    @Override
    public List<Creator> getAllCreators() {
        return creatorRepository.findAll();
    }


}
