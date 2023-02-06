package com.git.studygittmp.service.impl;

import com.git.studygittmp.data.dao.OnikesumDAO;
import com.git.studygittmp.data.dto.OnikesumDto;
import com.git.studygittmp.data.dto.OnikesumResponseDto;
import com.git.studygittmp.data.entity.Onikesum;
import com.git.studygittmp.data.repository.OnikesumRepository;
import com.git.studygittmp.service.OnikesumService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OnikesumServiceImpl implements OnikesumService {
    private final OnikesumDAO onikesumDAO;
    private final OnikesumRepository onikesumRepository;

    @Autowired
    public OnikesumServiceImpl(OnikesumDAO onikesumDAO, OnikesumRepository onikesumRepository){
        this.onikesumDAO = onikesumDAO;
        this.onikesumRepository = onikesumRepository;
    }
    @Override
    public OnikesumResponseDto getOnikesum(Long number) {
        Onikesum onikesum = onikesumDAO.selectOnikesum(number);

        OnikesumResponseDto onikesumResponseDto = new OnikesumResponseDto();
        onikesumResponseDto.setNumber(onikesum.getNumber());
        onikesumResponseDto.setName(onikesum.getName());
        onikesumResponseDto.setSid(onikesum.getSid());
        onikesumResponseDto.setAge(onikesum.getAge());
        return onikesumResponseDto;
    }

    @Override
    public OnikesumResponseDto saveOnikesum(OnikesumDto onikesumDto) {
        Onikesum onikesum = new Onikesum();
        onikesum.setName(onikesumDto.getName());
        onikesum.setAge(onikesumDto.getAge());
        onikesum.setSid(onikesumDto.getSid());
        onikesum.setCreateAt(LocalDateTime.now());
        onikesum.setUpdatedAt(LocalDateTime.now());
        Onikesum savedOnikesum = onikesumDAO.insertOnikesum(onikesum);

        OnikesumResponseDto OnikesumResponseDto = new OnikesumResponseDto();
        OnikesumResponseDto.setNumber(savedOnikesum.getNumber());
        OnikesumResponseDto.setAge(savedOnikesum.getAge());
        OnikesumResponseDto.setName(savedOnikesum.getName());
        OnikesumResponseDto.setSid(savedOnikesum.getSid());
        return OnikesumResponseDto;
    }

    @Override
    public OnikesumResponseDto changeOnikesum(Long number, String name) throws Exception {
        Onikesum changedOnikesum = onikesumDAO.updateOnikesumName(number, name);

        OnikesumResponseDto OnikesumResponseDto = new OnikesumResponseDto();
        OnikesumResponseDto.setNumber(changedOnikesum.getNumber());
        OnikesumResponseDto.setName(changedOnikesum.getName());
        OnikesumResponseDto.setAge(changedOnikesum.getAge());
        OnikesumResponseDto.setSid(changedOnikesum.getSid());

        return OnikesumResponseDto;
    }

    @Override
    public void deleteOnikesum(Long number) throws Exception {
        onikesumDAO.deleteOnikesum(number);
    }
}
