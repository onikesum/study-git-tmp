package com.git.studygittmp.data.dao;

import com.git.studygittmp.data.entity.Onikesum;

public interface OnikesumDAO {
    Onikesum insertOnikesum(Onikesum Onikesum);

    Onikesum selectOnikesum(Long number);
    Onikesum updateOnikesumName(Long number, String name) throws Exception;

    void deleteOnikesum(Long number) throws Exception;
}
