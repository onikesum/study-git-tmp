package com.git.studygittmp.data.dao.impl;


import com.git.studygittmp.data.dao.OnikesumDAO;
import com.git.studygittmp.data.entity.Onikesum;
import com.git.studygittmp.data.repository.OnikesumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component

public class OnikesumDAOImpl implements OnikesumDAO {
    private final OnikesumRepository onikesumRepository;

    @Autowired
    public OnikesumDAOImpl(OnikesumRepository onikesumRepository){
        this.onikesumRepository = onikesumRepository;
    }

    @Override
    public Onikesum insertOnikesum(Onikesum Onikesum) {
        Onikesum savedOnikesum = onikesumRepository.save(Onikesum);
        return savedOnikesum;
    }

    @Override
    public Onikesum selectOnikesum(Long number) {
        Onikesum selectedOnikesum = onikesumRepository.getById(number);
        return selectedOnikesum;
    }

    @Override
    public Onikesum updateOnikesumName(Long number, String name) throws Exception {
        Optional<Onikesum> selectedOnikesum = onikesumRepository.findById(number);

        Onikesum updatedOnikesum;
        if(selectedOnikesum.isPresent()){
            Onikesum Onikesum = selectedOnikesum.get();

            Onikesum.setName(name);

            updatedOnikesum = onikesumRepository.save(Onikesum);
        }
        else{
            throw new Exception();
        }
        return updatedOnikesum;
    }

    @Override
    public void deleteOnikesum(Long number) throws Exception {
        Optional<Onikesum> selectedOnikesum = onikesumRepository.findById(number);

        if(selectedOnikesum.isPresent()){
            Onikesum onikesum = selectedOnikesum.get();
            onikesumRepository.delete(onikesum);
        }else{
            throw new Exception();
        }

    }
}
