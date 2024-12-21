package br.com.juhmaran.cleancode;

public class Payroll {

//    public Money calculatePay(Employee e) throws InvalidEmployeeType {
//        switch (e.type) {
//            case COMMISSIONED:
//                return calculateCommisionedPay(e);
//            case HOURLY:
//                return calculateHourlyPay(e);
//            case SALARIED:
//                return calculateSalariedPay(e);
//            default:
//                throw new InvalidEmployeeType(e.type);
//        }
//    }

    public abstract static class Employee {
//        public String type;

        public abstract boolean isPayday();

        public abstract Money calculatePay();

        public abstract void deliveryPay(Money money);
    }

    public interface EmployeeFactory {
        public Record makeEmployee(EmployeeRecord r) throws InvalidEmployeeType;
    }

    public record EmployeeRecord() {
        public static final String type = "";
    }

    public static class Money {

    }

    public static class EmployeeFactoryImpl implements EmployeeFactory {

        private static final String COMMISSIONED = "Commissioned";
        private static final String HOURLY = "Hourly";
        private static final String SALARIED = "Salaried";

        @Override
        public Record makeEmployee(EmployeeRecord r) throws InvalidEmployeeType {
            return switch (EmployeeRecord.type) {
                case COMMISSIONED -> new CommissionedEmployee(r);
                case HOURLY -> new HourlyEmployee(r);
                case SALARIED -> new SalariedEmployee(r);
                default -> throw new InvalidEmployeeType(EmployeeRecord.type);
            };
        }

    }

    public record CommissionedEmployee(EmployeeRecord r) {
    }

    public record HourlyEmployee(EmployeeRecord r) {
    }

    public record SalariedEmployee(EmployeeRecord r) {
    }

}
