package com.movieglass.backend.domain.home.service;

import com.movieglass.backend.domain.home.dto.HomeResponseDto;

public interface HomeService {
    HomeResponseDto getHomeData(String userId);
}
