package com.example.apiproject.controllers;

import com.example.apiproject.domain.Holiday;
import com.example.apiproject.feign.HolidayClient;
import com.example.apiproject.services.HolidayService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holiday")
public class HolidayController {

    private final HolidayService service;
    @Getter
    private int defaultYear = 2024;
    public HolidayController(HolidayService service){
        this.service = (HolidayService) service;
    }
    @Autowired
    public HolidayClient holidayClient;

    @GetMapping("")
    public ResponseEntity<List<Holiday>> getHoliday(){
        int defaultYear = getDefaultYear();
        List<Holiday> holidays = this.service.getHolidaysFromWeb(defaultYear);
        return ResponseEntity.ok().body(holidays);
    }
    @GetMapping("/{year}")
    public ResponseEntity<List<Holiday>> getHolidaysByYear(@PathVariable("year") int year){
        List<Holiday> holidays = holidayClient.getHolidaysYear(year);
        return ResponseEntity.ok().body(holidays);
    }
    @PostMapping("/setYear/{year}")
    public ResponseEntity<String> setDefaultYear(@PathVariable("year") int year){
        defaultYear = year;
        return ResponseEntity.ok().body("Default year set to "+ year);
    }

}
