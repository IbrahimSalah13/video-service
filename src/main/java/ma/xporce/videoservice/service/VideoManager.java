package ma.xporce.videoservice.service;

import ma.xporce.videoservice.dao.entities.Video;
import ma.xporce.videoservice.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VideoManager implements VideoService{

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video addVideo(Video video) {
        if(video.getUrl()!=null && !video.getUrl().trim().isEmpty()){
            return videoRepository.save(video);
        }
        return null;
    }

    @Override
    public Video updateVideo(Integer id, Video video) {
        if(Objects.equals(video.getId(), id)){
            videoRepository.deleteById(id);
            return addVideo(video);
        }
        return null;
    }

    @Override
    public Video deleteVideo(Video video) {
        try {
            videoRepository.delete(video);
            return video;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Video getVideo(Integer id) {
        return videoRepository.findById(id).get();
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}
