package com.halasfilip.AndroidSpringApp.repo;

import com.halasfilip.AndroidSpringApp.dto.CreateInformationToBeSentDTO;
import com.halasfilip.AndroidSpringApp.model.InformationSended;

import java.util.List;

public interface InformationsRepo {

    void addInformation(CreateInformationToBeSentDTO createInformationToBeSent);

    List<InformationSended> fetchThemAll();

}
