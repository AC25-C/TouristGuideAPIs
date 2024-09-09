package com.example.touristguideapi.tourism.repository;

import org.springframework.stereotype.Repository;
import com.example.touristguideapi.tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository() {
        attractions.add(new TouristAttraction("Christiansborg", "At Copenhagen"));
        attractions.add(new TouristAttraction("The little mermaid", "At Copnehagen"));
    }

    public List<TouristAttraction> getAttractionslist() {
        return attractions;
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        attractions.add(touristAttraction);
        return touristAttraction;
    }


    public TouristAttraction findAttractionByName(String name) {
        for (TouristAttraction touristAttraction : attractions) {
            if (touristAttraction.getName().equals(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

        public void deleteAttraction (TouristAttraction touristAttraction){
            attractions.remove(touristAttraction);
        }

        public TouristAttraction updateAttraction (TouristAttraction touristAttraction){
            int index = attractions.indexOf(touristAttraction);
            attractions.set(index, touristAttraction);
            return attractions.get(index);


        }
    }