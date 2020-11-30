package com.halasfilip.AndroidSpringApp.repo;


import com.halasfilip.AndroidSpringApp.dto.CreateInformationToBeSentDTO;
import com.halasfilip.AndroidSpringApp.model.InformationSended;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);

        InformationSended informationSent = InformationSended.builder()
                .id(idCount.getAndIncrement())
                .creationTime(formatDateTime)
                .informationSent(createInformationToBeSentDTO.getInformationSent())
                .build();
        informationsSendedList.add(informationSent);

    }

    @Override
    public List<InformationSended> fetchThemAll() {

        return informationsSendedList;

    }

    @Override
    public boolean deleteById(Integer id) {

        informationsSendedList.removeIf(product -> id.equals(product.getId()));
        return false;

    }


}
