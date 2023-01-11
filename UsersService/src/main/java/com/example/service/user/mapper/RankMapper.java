package com.example.service.user.mapper;

import com.example.service.user.domain.Rank;
import com.example.service.user.dto.CreateRankDto;
import com.example.service.user.dto.RankDto;
import org.springframework.stereotype.Component;

@Component
public class RankMapper {
    public RankDto rankToRankDto(Rank rank) {
        RankDto rankDto = new RankDto();

        rankDto.setRankId(rank.getRankId());
        rankDto.setRankName(rank.getRankName());
        rankDto.setNumberOfDays(rank.getNumberOfDays());
        rankDto.setDiscount(rank.getDiscount());

        return rankDto;
    }

    public Rank CreateRankDtoToRank(CreateRankDto createRankDto) {
        Rank rank = new Rank();

        rank.setRankName(createRankDto.getRankName());
        rank.setNumberOfDays(createRankDto.getNumberOfDays());
        rank.setDiscount(createRankDto.getDiscount());

        return rank;
    }
}
