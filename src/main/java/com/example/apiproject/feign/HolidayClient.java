package com.example.apiproject.feign;

import com.example.apiproject.domain.Holiday;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name = "Holiday-api", url = "https://date.nager.at/api/v3/publicholidays")
public interface HolidayClient {
    @GetMapping("/2024/BR")
    List<Holiday> getHolidays();
}
