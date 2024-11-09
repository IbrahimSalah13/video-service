package ma.xporce.videoservice.service;

import ma.xporce.videoservice.dao.entities.Creator;

import java.util.List;

public interface CreatorService {
    public Creator addCreator(Creator creator);
    public Creator updateCreator(Integer id, Creator creator);
    public Creator deleteCreator(Creator creator);
    public Creator getCreator(Integer creatorId);
    public List<Creator> getAllCreators();
}
