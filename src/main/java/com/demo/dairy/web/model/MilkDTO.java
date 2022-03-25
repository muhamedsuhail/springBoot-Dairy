package com.demo.dairy.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MilkDTO {

    private UUID id;
    private String milkName;
    private String milkType;
    private Long upc;
}
