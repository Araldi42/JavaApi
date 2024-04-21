package com.example.apiproject.services;

import com.example.apiproject.domain.Holiday;
import com.example.apiproject.feign.HolidayClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService {

    private final HolidayClient holidayClient;

    public HolidayService(HolidayClient client){
        this.holidayClient = client;
    }

    public List<Holiday> getHolidaysFromWeb(){
        return this.holidayClient.getHolidays();

    }
}
