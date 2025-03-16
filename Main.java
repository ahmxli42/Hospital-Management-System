public class Main {
    public static void main(String[] args) {
        Patient p1 = new Patient("P-01", "Ahsan", 30, "Flu");
        Patient p2 = new Patient("P-02", "Khaleel", 25, "Fever");
        Patient p3 = new Patient("P-03", "Abdul Ahad", 25, "Stomach Pain");

        Doctor d1 = new Doctor("D-01", "Dr. Nazir", 45, "Cardiology");
        Doctor d2 = new Doctor("D002", "Dr. Sagheer", 50, "Neurology");

        Nurse n1 = new Nurse("N-01", "Hatim", 35, "Emergency");
        Nurse n2 = new Nurse("N-02", "Huzaifa", 28, "ICU");
        
        p1.addMedicalRecord("checked and shifted to room");
        p1.addMedicalRecord("Again shifted to surgical");
        
        p1.displayDetails();
        p2.displayDetails();
        p3.displayDetails();

        d1.displayDetails();
        d2.displayDetails();

        n1.displayDetails();
        n2.displayDetails();

        p1.schedule("2024-06-01", "10:00 AM");
        d1.addAppointment(p1);

        OutpatientService Os = new OutpatientService("S-01", "General Checkup", 50.0);
        InpatientService Is = new InpatientService("S-02", "Surgery", 5);

        Os.performService();
        Os.processPayment(Os.getFee());

        Is.performService();

        HospitalService[] services = {Os, Is};
        for (HospitalService service : services) {
            service.performService();
        }

        d1.prescribeMedication(p1, "Antibiotics");
        d1.prescribeMedication(p2, "PainKillers");
        n1.assistDoctor(d1);

    }
}
