package com.example.touristguideapi.tourism.controller;

import com.example.touristguideapi.tourism.model.TouristAttraction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.touristguideapi.tourism.service.TouristService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping
    public ResponseEntity<List<TouristAttraction>> getTouristAttractions() {
        List<TouristAttraction> touristAttractions = touristService.getAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String>addTouristAttraction(@RequestParam Map<String, String> body) {
        touristService.addAttraction(new TouristAttraction(body.get("name"), body.get("description")));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction>getTouristAttractionsByName(@PathVariable("name") String name) {
     TouristAttraction attraction =touristService.findAttractionByName(name);
     if(attraction != null) {
         return new ResponseEntity<>(attraction, HttpStatus.OK);
     }
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<List<TouristAttraction>> deleteTouristAttraction(@RequestParam Map<String, String> body) {
        touristService.deleteAttraction(new TouristAttraction(body.get("name"), body.get("description")));
        return new ResponseEntity<>(HttpStatus.OK);
    }


}