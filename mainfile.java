import java.util.ArrayList;
import java.util.List;
abstract class Person {
    private String id;
    private String name;
    private int age;

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void displayDetails();
}
 abstract class HospitalService {
    private String serviceId;
    private String serviceName;

    public HospitalService(String serviceId, String serviceName) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public abstract void performService();
}
 interface Schedulable {
    void schedule(String date, String time);
}
 interface Payable {
     void processPayment(double amount);
}
class Patient extends Person implements Schedulable {
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
 class Doctor extends Person {
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
 class Nurse extends Person {
    private String department;

    public Nurse(String id, String name, int age, String department) {
        super(id, name, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.println("Nurse ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Department: " + department);
    }

    public void assistDoctor(Doctor doctor) {
        System.out.println("Nurse " + getName() + " is assisting Doctor " + doctor.getName());
    }
}
 class OutpatientService extends HospitalService implements Payable {
    private double fee;

    public OutpatientService(String serviceId, String serviceName, double fee) {
        super(serviceId, serviceName);
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public void performService() {
        System.out.println("Performing outpatient service: " + getServiceName());
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount);
    }
}
 class InpatientService extends HospitalService {
    private int duration; // Duration of stay in days

    public InpatientService(String serviceId, String serviceName, int duration) {
        super(serviceId, serviceName);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void performService() {
        System.out.println("Performing inpatient service: " + getServiceName() + " for " + duration + " days");
    }
}
public class mainfile {
    public static void main(String[] args) {
        // Creating patients
        Patient patient1 = new Patient("P001", "John Doe", 30, "Flu");
        Patient patient2 = new Patient("P002", "Jane Smith", 25, "Fever");

        // Creating doctors
        Doctor doctor1 = new Doctor("D001", "Dr. Smith", 45, "Cardiology");
        Doctor doctor2 = new Doctor("D002", "Dr. Brown", 50, "Neurology");

        // Creating nurses
        Nurse nurse1 = new Nurse("N001", "Nurse Alice", 35, "Emergency");
        Nurse nurse2 = new Nurse("N002", "Nurse Bob", 40, "ICU");

        // Display details
        patient1.displayDetails();
        patient2.displayDetails();
        doctor1.displayDetails();
        doctor2.displayDetails();
        nurse1.displayDetails();
        nurse2.displayDetails();

        // Scheduling appointments
        patient1.schedule("2024-06-01", "10:00 AM");
        doctor1.addAppointment(patient1);

        // Performing services
        OutpatientService outpatientService = new OutpatientService("S001", "General Checkup", 50.0);
        InpatientService inpatientService = new InpatientService("S002", "Surgery", 5);

        outpatientService.performService();
        outpatientService.processPayment(outpatientService.getFee());

        inpatientService.performService();

        // Polymorphic behavior
        HospitalService[] services = {outpatientService, inpatientService};
        for (HospitalService service : services) {
            service.performService();
        }

        // Doctor prescribing medication
        doctor1.prescribeMedication(patient1, "Antibiotics");

        // Nurse assisting doctor
        nurse1.assistDoctor(doctor1);
    }
}
