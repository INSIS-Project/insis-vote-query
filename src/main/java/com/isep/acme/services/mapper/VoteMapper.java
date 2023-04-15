package com.isep.acme.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.isep.acme.model.Vote;
import com.isep.acme.services.dto.VoteDTO;

@Mapper(componentModel = "spring")
public interface VoteMapper {

    VoteDTO toDTO(Vote vote);

    Vote toEntity(VoteDTO voteDTO);

    Vote toEntity(String vote);

    /* @Mapping(source = "review_id", target = "reviewId")
    VoteDTO toDTOWithReviewId(Vote vote); */
}