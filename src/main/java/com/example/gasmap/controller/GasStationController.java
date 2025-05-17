package com.example.gasmap.controller;

import com.example.gasmap.dto.GasStationDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/gasstations")
public class GasStationController {

    @GetMapping("/nearby")
    public List<GasStationDTO> getNearbyGasStations(
            @RequestParam("lat") double lat,
            @RequestParam("lng") double lng,
            @RequestParam(value = "radius", defaultValue = "5000") int radius) {

        // For Phase 1 MVP, return mock data
        // In a real application, this would query a database or another service
        System.out.println("Received request for nearby gas stations: lat=" + lat + ", lng=" + lng + ", radius=" + radius);

        List<GasStationDTO> mockStations = new ArrayList<>();

        mockStations.add(new GasStationDTO(
                "mock1",
                "Central City Gas",
                new GasStationDTO.LocationDTO(lat + 0.005, lng + 0.005),
                "$3.50/gal",
                "123 Main St"
        ));
        mockStations.add(new GasStationDTO(
                "mock2",
                "Highway Fuel Stop",
                new GasStationDTO.LocationDTO(lat - 0.008, lng - 0.002),
                "$3.45/gal",
                "456 Highway Rd"
        ));
        mockStations.add(new GasStationDTO(
                "mock3",
                "Costco Members Gas (Mock)", // Example for Costco
                new GasStationDTO.LocationDTO(lat + 0.002, lng - 0.009),
                "$3.20/gal (Member Price)",
                "789 Member Ln"
        ));

        // Simple filtering logic for mock data (optional, could be more sophisticated)
        // For now, just returning stations relative to the input lat/lng
        return mockStations;
    }
} 