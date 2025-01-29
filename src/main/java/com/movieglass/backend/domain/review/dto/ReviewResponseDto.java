package com.movieglass.backend.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 포함한 생성자
public class ReviewResponseDto {

    private Long reviewId;
    private Long  userId;
    private BigDecimal rating;
    private String comment;
    private int viewCount;
}
