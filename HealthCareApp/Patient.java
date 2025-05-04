package HealthCareApp;

import java.util.List;

public class Patient extends Person {
    private List<String> medicalHistory;

    public Patient(String name, int age, String Id, List<String> medicalHistory) {
        super(name, age, Id);
    }

}
