package ma.xporce.videoservice.service;

import ma.xporce.videoservice.dao.entities.Video;

import java.util.List;

public interface VideoService {
    public Video addVideo(Video video);
    public Video updateVideo(Integer id, Video video);
    public Video deleteVideo(Video video);
    public Video getVideo(Integer id);
    public List<Video> getAllVideos();
}
