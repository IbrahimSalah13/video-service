package ma.xporce.videoservice.web;
import ma.xporce.videoservice.dao.entities.Video;
import ma.xporce.videoservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @GetMapping
    public String getAllVideos(Model model) {
        List<Video> videos = videoService.getAllVideos();
        model.addAttribute("videos", videos);
        return "videos";
    }
    @GetMapping("/add")
    public String showAddVideoForm(Model model) {
        model.addAttribute("video", new Video());
        return "add-video";
    }
    @PostMapping
    public String addVideo(@ModelAttribute Video video) {
        videoService.addVideo(video);
        return "redirect:/videos";
    }
    @GetMapping("/edit/{id}")
    public String showEditVideoForm(@PathVariable Integer id, Model model) {
        Video video = videoService.getVideo(id);
        model.addAttribute("video", video);
        return "edit-video";
    }
    @PostMapping("/update/{id}")
    public String updateVideo(@PathVariable Integer id, @ModelAttribute Video video) {
        videoService.updateVideo(id, video);
        return "redirect:/videos";
    }
    @GetMapping("/delete/{id}")
    public String deleteVideo(@PathVariable Integer id) {
        videoService.deleteVideo(videoService.getVideo(id));
        return "redirect:/videos";
    }
}
