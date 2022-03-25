package com.demo.dairy.web.controller;

import com.demo.dairy.services.MilkService;
import com.demo.dairy.web.model.MilkDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Deprecated
@RestController
@RequestMapping("/api/v1/milk")
public class MilkController {

    private final MilkService milkService;

    public MilkController(MilkService milkService) {
        this.milkService = milkService;
    }

    @RequestMapping("/{milkId}")
    public ResponseEntity<MilkDTO> getMilk(@PathVariable("milkId") UUID milkId) {

        return new ResponseEntity<>(milkService.getMilkById(milkId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody MilkDTO milkDTO) {

        MilkDTO saveDTO = milkService.saveNewMilk(milkDTO);
        HttpHeaders headers = new HttpHeaders();
        // TODO add hostname to url
        headers.add("Location", "/api/v1/milk/" + saveDTO.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{milkId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("milkId") UUID milkId, MilkDTO milkDTO) {

        milkService.updateMilkById(milkId, milkDTO);
    }

    @DeleteMapping("/{milkId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("milkId") UUID milkId) {

        milkService.deleteMilkById(milkId);
    }
}
