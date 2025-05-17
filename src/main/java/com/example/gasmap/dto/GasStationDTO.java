package com.example.gasmap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GasStationDTO {
    private String id;
    private String name;
    private LocationDTO location;
    private String price; // Keep as String for now, can be more complex later
    private String address; // Optional: add address if available

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LocationDTO {
        private double lat;
        private double lng;
    }
} 