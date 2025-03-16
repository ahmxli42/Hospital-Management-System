import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String specialization;
    private List<Schedulable> appointments;

    public Doctor(String id, String name, int age, String specialization) {
        super(id, name, age);
        this.specialization = specialization;
        this.appointments = new ArrayList<>();
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void addAppointment(Schedulable appointment) {
        appointments.add(appointment);
    }

    public List<Schedulable> getAppointments() {
        return appointments;
    }

    @Override
    public void displayDetails() {
        System.out.println("Doctor ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Specialization: " + specialization);
        System.out.println("Appointments: " + appointments);
    }

    public void prescribeMedication(Patient patient, String medication) {
        patient.addPrescription(medication);
        System.out.println("Prescribed " + medication + " to patient " + patient.getName());
    }
}
