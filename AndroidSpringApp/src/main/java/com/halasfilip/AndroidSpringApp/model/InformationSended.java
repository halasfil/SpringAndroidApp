package com.halasfilip.AndroidSpringApp.model;

import lombok.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class InformationSended {

    private Integer id;
    private String creationTime;
    private String informationSent;

    
}
