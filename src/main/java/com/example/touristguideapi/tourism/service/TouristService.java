package com.example.touristguideapi.tourism.service;

import org.springframework.stereotype.Service;
import com.example.touristguideapi.tourism.model.TouristAttraction;
import com.example.touristguideapi.tourism.repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {

        this.touristRepository = touristRepository;
    }
    public void addAttraction(TouristAttraction touristAttraction) {
        touristRepository.addAttraction(touristAttraction);
    }

    public TouristAttraction findAttractionByName(String name) {
       for (TouristAttraction touristAttraction : getAttractions()){
             if(touristAttraction.getName().equals(name)){
                return touristAttraction;
            }
        }
        return null;
    }

    public void deleteAttraction(TouristAttraction touristAttraction) {
        touristRepository.deleteAttraction(touristAttraction);
    }
    public void updateAttraction(TouristAttraction touristAttraction) {
        touristRepository.updateAttraction(touristAttraction);
    }
    public List<TouristAttraction> getAttractions() {
        return touristRepository.getAttractionslist();
    }

}
