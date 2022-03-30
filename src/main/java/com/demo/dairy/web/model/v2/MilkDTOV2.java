package com.demo.dairy.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MilkDTOV2 {

    @NotNull
    private UUID id;
    @NotBlank
    private String milkName;
    @NotBlank
    private MilkTypeEnum milkType;
    @Positive
    private Long upc;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastUpdatedDate;
}
