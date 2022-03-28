package com.demo.dairy.web.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MilkDTO {
    @NotNull
    private UUID id;
    @NotBlank
    private String milkName;
    @NotBlank
    private String milkType;
    @Positive
    private Long upc;
}
