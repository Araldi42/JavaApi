package com.example.apiproject.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Holiday {
    public String date;
    public String localName;
    public String name;
    public String CountryCode;
    public boolean fixed;
    public boolean global;
    public String[] countries;
    public int launchYear;
    public String[] types;

}


