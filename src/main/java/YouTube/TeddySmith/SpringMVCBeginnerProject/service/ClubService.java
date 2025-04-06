package YouTube.TeddySmith.SpringMVCBeginnerProject.service;

import YouTube.TeddySmith.SpringMVCBeginnerProject.dto.ClubDto;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
}
