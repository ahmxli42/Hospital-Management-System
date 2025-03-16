public class InpatientService extends HospitalService {
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
