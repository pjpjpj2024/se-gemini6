package th.ac.mahidol.ict.gemini6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.mahidol.ict.gemini6.Model.SciencePlan;
import th.ac.mahidol.ict.gemini6.Repository.SciencePlanRepository;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/scienceplans")
public class SciencePlanController {

    @Autowired
    private SciencePlanRepository sciencePlanRepository;

    // API endpoint to create a new science plan and store it in the database
    @PostMapping("/create")
    public ResponseEntity<?> createSciencePlan(@RequestBody SciencePlan newSciencePlan) {
        try {
            // Set default value for astronomicalObjects if it's not provided
            if (newSciencePlan.getAstronomicalObjects() == null) {
                // Set default values for astronomical objects
                newSciencePlan.setAstronomicalObjects(Arrays.asList("DefaultObject1", "DefaultObject2"));
            }

            // Save the new science plan to the database
            SciencePlan savedSciencePlan = sciencePlanRepository.save(newSciencePlan);

            // Return the saved SciencePlan as part of the response
            return ResponseEntity.ok(savedSciencePlan);
        } catch (Exception e) {
            // Return an error message if something goes wrong
            return ResponseEntity.status(500).body("Error creating science plan: " + e.getMessage());
        }
    }

    // API endpoint to retrieve all science plans
    @GetMapping("/allsp")
    public ResponseEntity<?> getAllSciencePlans() {
        try {
            // Fetch all science plans from the database
            List<SciencePlan> sciencePlans = sciencePlanRepository.findAll();

            // Return the list of science plans or a message if no plans are found
            if (sciencePlans.isEmpty()) {
                return ResponseEntity.status(404).body("No science plans found");
            }
            return ResponseEntity.ok(sciencePlans);
        } catch (Exception e) {
            // Return an error message if something goes wrong
            return ResponseEntity.status(500).body("Error fetching science plans: " + e.getMessage());
        }
    }
}
