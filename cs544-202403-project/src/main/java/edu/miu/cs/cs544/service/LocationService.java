package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Location;
import edu.miu.cs.cs544.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;
    @Autowired
    public LocationService (LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }
    public List<Location> findAllLocations(){
        return locationRepository.findAll();
    }
    public Location findLocationById(Long id){
        return locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
    }

    public Location saveLocation(Location location){
        return locationRepository.save(location);
    }

    public void deleteLocation(Long id){
        locationRepository.deleteById(id);
    }


}
