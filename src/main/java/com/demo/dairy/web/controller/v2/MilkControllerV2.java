package com.demo.dairy.web.controller.v2;

import com.demo.dairy.services.v2.MilkServiceV2;
import com.demo.dairy.web.model.v2.MilkDTOV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v2/milk")
public class MilkControllerV2 {

    private final MilkServiceV2 milkServiceV2;

    public MilkControllerV2(MilkServiceV2 milkServiceV2) {
        this.milkServiceV2 = milkServiceV2;
    }

    @RequestMapping("/{milkId}")
    public ResponseEntity<MilkDTOV2> getMilk(@PathVariable("milkId") UUID milkId) {

        return new ResponseEntity<>(milkServiceV2.getMilkById(milkId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @NotNull @RequestBody MilkDTOV2 milkDTOv2) {

        MilkDTOV2 saveDTO = milkServiceV2.saveNewMilk(milkDTOv2);
        HttpHeaders headers = new HttpHeaders();
        // TODO add hostname to url
        headers.add("Location", "/api/v1/milk/" + saveDTO.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{milkId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@Valid @NotNull @PathVariable("milkId") UUID milkId, MilkDTOV2 milkDTOv2) {

        milkServiceV2.updateMilkById(milkId, milkDTOv2);
    }

    @DeleteMapping("/{milkId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("milkId") UUID milkId) {

        milkServiceV2.deleteMilkById(milkId);
    }
}
