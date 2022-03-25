package com.demo.dairy.services.v2;

import com.demo.dairy.web.model.v2.MilkDTOV2;

import java.util.UUID;

public interface MilkServiceV2 {
    MilkDTOV2 getMilkById(UUID milkId);
    MilkDTOV2 saveNewMilk(MilkDTOV2 milkDTOv2);
    void updateMilkById(UUID milkId, MilkDTOV2 milkDTOv2);
    void deleteMilkById(UUID milkId);
}
