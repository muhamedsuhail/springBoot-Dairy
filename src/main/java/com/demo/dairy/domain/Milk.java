package com.demo.dairy.domain;

import com.demo.dairy.web.model.v2.MilkTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Milk {
    private UUID id;
    private String milkName;
    private MilkTypeEnum milkType;
    private Long upc;

    private Timestamp createdDate;
    private Timestamp lastUpdatedDate;
}
