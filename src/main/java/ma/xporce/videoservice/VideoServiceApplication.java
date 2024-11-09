package ma.xporce.videoservice;

import ma.xporce.videoservice.dao.entities.Creator;
import ma.xporce.videoservice.dao.entities.Video;
import ma.xporce.videoservice.dao.repositories.CreatorRepository;
import ma.xporce.videoservice.dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class VideoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {

            Creator creator1 = new Creator(null, "saad", "saad@gmail.com",null);
            Creator creator2 = new Creator(null, "hamza", "hamza@gmail.com",null);
            creatorRepository.save(creator1);
            creatorRepository.save(creator2);

            Video video1 = new Video(null, "Spring Boot tutorial", "youtube.com/video1",
                    "for beginners", creator1);
            Video video2 = new Video(null, "Jpa tutorial", "youtube.com/video2",
                    "advanced",creator2 );
            videoRepository.saveAll(Arrays.asList(video1,video2));

            creator1.setVideos(List.of(video1));
            creator2.setVideos(List.of(video2));
            creatorRepository.saveAll(Arrays.asList(creator1,creator2));

        };
    }
}
