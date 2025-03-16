import java.util.ArrayList;
import java.util.List;

public class Patient extends Person implements Schedulable {
    private String illness;
    private List<String> medicalRecords;
    private List<String> prescriptions;

    public Patient(String id, String name, int age, String illness) {
        super(id, name, age);
        this.illness = illness;
        this.medicalRecords = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public void addMedicalRecord(String record) {
        medicalRecords.add(record);
    }

    public List<String> getMedicalRecords() {
        return medicalRecords;
    }

    public void addPrescription(String prescription) {
        prescriptions.add(prescription);
    }

    public List<String> getPrescriptions() {
        return prescriptions;
    }

    @Override
    public void displayDetails() {
        System.out.println("Patient ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Illness: " + illness);
        System.out.println("Medical Records: " + medicalRecords);
        System.out.println("Prescriptions: " + prescriptions);
    }

    @Override
    public void schedule(String date, String time) {
        System.out.println("Appointment scheduled for " + date + " at " + time);
    }
}
