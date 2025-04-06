package YouTube.TeddySmith.SpringMVCBeginnerProject.service.impl;

import YouTube.TeddySmith.SpringMVCBeginnerProject.dto.ClubDto;
import YouTube.TeddySmith.SpringMVCBeginnerProject.models.Club;
import YouTube.TeddySmith.SpringMVCBeginnerProject.repository.ClubRepository;
import YouTube.TeddySmith.SpringMVCBeginnerProject.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

    private ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .undatedOn(club.getUndatedOn())
                .build();

        return clubDto;
    }
}
