package com.onetomany.Controller;


import com.onetomany.EntityDto.VideoDto;
import com.onetomany.Service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    private VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }
    @PostMapping
    public ResponseEntity<VideoDto>createvideo(@RequestBody VideoDto videoDto){
        VideoDto save = videoService.save(videoDto);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
    }

}
