package th.ac.mahidol.ict.gemini6.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import java.util.List;

@Entity
public class SciencePlan {

    @Id
    private String planID;  // Primary key for the table
    private String planName; // Name of the science plan
    private String creator;  // Creator of the plan
    private float funding;   // Funding amount (in USD)
    private String objective; // Objective of the science plan
    private String target;  // Target for the observation (e.g., star system)
    private String observationMode; // Mode of observation (e.g., optical, infrared)
    private String observationTime; // Time when the observation is planned
    private float exposureTime; // Exposure time for the observation (in seconds)
    private float snr;  // Signal-to-Noise Ratio for the observation
    private String submitter;  // Person submitting the science plan
    @ElementCollection(fetch = FetchType.LAZY) // To store a list of strings (astronomical objects)
    private List<String> astronomicalObjects;  // List of astronomical objects involved in the plan
    private String schedule; // Schedule for the observations (could be a timestamp or description)

    // Getters and Setters for all attributes
    public String getPlanID() {
        return planID;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public float getFunding() {
        return funding;
    }

    public void setFunding(float funding) {
        this.funding = funding;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getObservationMode() {
        return observationMode;
    }

    public void setObservationMode(String observationMode) {
        this.observationMode = observationMode;
    }

    public String getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public float getExposureTime() {
        return exposureTime;
    }

    public void setExposureTime(float exposureTime) {
        this.exposureTime = exposureTime;
    }

    public float getSnr() {
        return snr;
    }

    public void setSnr(float snr) {
        this.snr = snr;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public List<String> getAstronomicalObjects() {
        return astronomicalObjects;
    }

    public void setAstronomicalObjects(List<String> astronomicalObjects) {
        this.astronomicalObjects = astronomicalObjects;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
