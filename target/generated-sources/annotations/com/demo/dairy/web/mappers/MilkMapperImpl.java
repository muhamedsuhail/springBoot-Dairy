package com.demo.dairy.web.mappers;

import com.demo.dairy.domain.Milk;
import com.demo.dairy.domain.Milk.MilkBuilder;
import com.demo.dairy.web.model.v2.MilkDTOV2;
import com.demo.dairy.web.model.v2.MilkDTOV2.MilkDTOV2Builder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-30T23:32:05+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class MilkMapperImpl implements MilkMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public MilkDTOV2 milkToMilkDTO(Milk milk) {
        if ( milk == null ) {
            return null;
        }

        MilkDTOV2Builder milkDTOV2 = MilkDTOV2.builder();

        milkDTOV2.id( milk.getId() );
        milkDTOV2.milkName( milk.getMilkName() );
        milkDTOV2.milkType( milk.getMilkType() );
        milkDTOV2.upc( milk.getUpc() );
        milkDTOV2.createdDate( dateMapper.asOffsetDateTime( milk.getCreatedDate() ) );
        milkDTOV2.lastUpdatedDate( dateMapper.asOffsetDateTime( milk.getLastUpdatedDate() ) );

        return milkDTOV2.build();
    }

    @Override
    public Milk milkDTOToMilk(MilkDTOV2 milkDTO) {
        if ( milkDTO == null ) {
            return null;
        }

        MilkBuilder milk = Milk.builder();

        milk.id( milkDTO.getId() );
        milk.milkName( milkDTO.getMilkName() );
        milk.milkType( milkDTO.getMilkType() );
        milk.upc( milkDTO.getUpc() );
        milk.createdDate( dateMapper.asTimestamp( milkDTO.getCreatedDate() ) );
        milk.lastUpdatedDate( dateMapper.asTimestamp( milkDTO.getLastUpdatedDate() ) );

        return milk.build();
    }
}
