package com.movieglass.backend.domain.home.service;

import com.movieglass.backend.domain.home.dto.response.CurationShuffleResponseDto;
import com.movieglass.backend.domain.home.dto.response.HomeResponseDto;

public interface HomeService {

    HomeResponseDto getHomeData(String userId);

    CurationShuffleResponseDto getRandomCurations();
}
