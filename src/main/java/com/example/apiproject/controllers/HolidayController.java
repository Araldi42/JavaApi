package com.example.apiproject.controllers;

import com.example.apiproject.domain.Holiday;
import com.example.apiproject.feign.HolidayClient;
import com.example.apiproject.services.HolidayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/holiday")
public class HolidayController {

    private final HolidayService service;
    public HolidayController(HolidayService service){
        this.service = (HolidayService) service;
    }
    @GetMapping("")
    public ResponseEntity<List<Holiday>> getHoliday(){
        List<Holiday> holidays = this.service.getHolidaysFromWeb();
        System.out.println(holidays);
        return ResponseEntity.ok().body(holidays);
    }
}
