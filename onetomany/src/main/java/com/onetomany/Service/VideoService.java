package com.onetomany.Service;

import com.onetomany.Entity.Video;
import com.onetomany.EntityDto.VideoDto;
import com.onetomany.Repository.VideoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    private VideoRepository videoRepository;
    private ModelMapper modelMapper;

    public VideoService(VideoRepository videoRepository, ModelMapper modelMapper) {
        this.videoRepository = videoRepository;
        this.modelMapper = modelMapper;
    }

    public VideoDto save( VideoDto videoDto){
        Video video = covertDtoToEntity (videoDto);
        Video save = videoRepository.save(video);
        VideoDto savedto =  convertEntityToDto(save);
        return savedto;
    }
    VideoDto convertEntityToDto(Video save){
        VideoDto videoDto = modelMapper.map(save, VideoDto.class);
        return videoDto;
    }
    Video covertDtoToEntity(VideoDto videoDto){
        Video video =modelMapper.map(videoDto, Video.class);
        return video;
    }





}
