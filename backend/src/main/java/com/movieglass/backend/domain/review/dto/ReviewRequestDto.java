package com.movieglass.backend.domain.review.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReviewRequestDto {
    private Long userId;
    private BigDecimal rating;
    private String comment;
    private int viewCount;
}
