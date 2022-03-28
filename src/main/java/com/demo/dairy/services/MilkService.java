package com.demo.dairy.services;

import com.demo.dairy.web.model.MilkDTO;

import java.util.UUID;

public interface MilkService {

    MilkDTO getMilkById(UUID uuid);
    MilkDTO saveNewMilk(MilkDTO milkDTO);
    void updateMilkById(UUID milkId, MilkDTO milkDTO);
    void deleteMilkById(UUID milkId);
}
