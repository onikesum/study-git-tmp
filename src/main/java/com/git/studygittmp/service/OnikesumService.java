package com.git.studygittmp.service;

import com.git.studygittmp.data.dto.OnikesumDto;
import com.git.studygittmp.data.dto.OnikesumResponseDto;

public interface OnikesumService {
    OnikesumResponseDto getOnikesum(Long number);
    OnikesumResponseDto saveOnikesum(OnikesumDto onikesumDto);

    OnikesumResponseDto changeOnikesum(Long number, String name) throws Exception;
    void deleteOnikesum(Long number) throws Exception;

}
