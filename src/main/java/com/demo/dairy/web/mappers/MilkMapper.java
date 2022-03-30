package com.demo.dairy.web.mappers;

import com.demo.dairy.domain.Milk;
import com.demo.dairy.web.model.v2.MilkDTOV2;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface MilkMapper {

    MilkDTOV2 milkToMilkDTO(Milk milk);

    Milk milkDTOToMilk(MilkDTOV2 milkDTO);
}
