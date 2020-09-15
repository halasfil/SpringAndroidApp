package com.halasfilip.AndroidSpringApp.repo;


import com.halasfilip.AndroidSpringApp.dto.CreateInformationToBeSentDTO;
import com.halasfilip.AndroidSpringApp.model.InformationSended;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class InMemoryRepo implements InformationsRepo {

    private static List<InformationSended> informationsSendedList;
    private static AtomicInteger idCount;

    public InMemoryRepo() {
        informationsSendedList = new ArrayList<>();
        idCount = new AtomicInteger(1);
    }


    @Override
    public void addInformation(CreateInformationToBeSentDTO createInformationToBeSentDTO) {
        InformationSended informationSent = InformationSended.builder()
                .id(idCount.getAndIncrement())
                .informationSent(createInformationToBeSentDTO.getInformationSent())
                .build();
        informationsSendedList.add(informationSent);
    }

    @Override
    public List<InformationSended> fetchThemAll() {
        return informationsSendedList;
    }
}
