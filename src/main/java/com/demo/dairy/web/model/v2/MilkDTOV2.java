package com.demo.dairy.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MilkDTOV2 {
    private UUID id;
    private String milkName;
    private MilkTypeEnum milkType;
    private Long upc;
}
