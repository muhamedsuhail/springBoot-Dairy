package com.demo.dairy.services;

import com.demo.dairy.web.model.MilkDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class MilkServiceImpl implements MilkService{

    @Override
    public MilkDTO getMilkById(UUID uuid) {
        return MilkDTO.builder()
                .id(UUID.randomUUID())
                .milkName("Aavin")
                .milkType("Green Magic")
                .build();
    }

    @Override
    public MilkDTO saveNewMilk(MilkDTO milkDTO) {
        return MilkDTO.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateMilkById(UUID milkId, MilkDTO milkDTO) {
        // TODO impl
    }

    @Override
    public void deleteMilkById(UUID milkId) {
        log.debug("Deleting a Milk Object...");
    }
}
