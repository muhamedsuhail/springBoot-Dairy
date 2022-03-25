package com.demo.dairy.services.v2;

import com.demo.dairy.web.model.v2.MilkDTOV2;
import com.demo.dairy.web.model.v2.MilkTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class MilkServiceV2Impl implements MilkServiceV2{

    @Override
    public MilkDTOV2 getMilkById(UUID milkId) {
        return MilkDTOV2.builder()
                .id(UUID.randomUUID())
                .milkName("Aavin")
                .milkType(MilkTypeEnum.GREEN_MAGIC)
                .build();
    }

    @Override
    public MilkDTOV2 saveNewMilk(MilkDTOV2 milkDTOv2) {
        return MilkDTOV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateMilkById(UUID milkId, MilkDTOV2 milkDTOv2) {
        // TODO impl
    }

    @Override
    public void deleteMilkById(UUID milkId) {
        log.debug("Deleting a Milk Object...");
    }
}
