package com.cybernetic;

import java.time.Duration;
import java.time.LocalDateTime;

public class EmergencyCase {
    String caseId;
    Patient patient;
    int severityLevel; // 1-5
    LocalDateTime registrationTime;
    EmergencyCase left, right;
    int height;

    public EmergencyCase(String caseId, Patient patient, int severityLevel, LocalDateTime registrationTime) {
        if (severityLevel < 1 || severityLevel > 5)
            throw new IllegalArgumentException("Severity level must be from 1-5.");

        this.caseId = caseId;
        this.patient = patient;
        this.severityLevel = severityLevel;
        this.registrationTime = registrationTime;
        left = right = null;

        System.out.println(registrationTime);
    }

    public int getWaitTime() {
        return Duration.between(registrationTime, LocalDateTime.now()).toMinutesPart();
    }

    public String toString() {
        return caseId + " (Severity: " + severityLevel + ", Wait time: " + getWaitTime() + " min)";
    }
}
