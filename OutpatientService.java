public class OutpatientService extends HospitalService implements Payable {
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
