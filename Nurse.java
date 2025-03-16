public class Nurse extends Person {
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

