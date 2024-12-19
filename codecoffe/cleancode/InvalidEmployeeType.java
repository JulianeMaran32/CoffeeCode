package cleancode;

public class InvalidEmployeeType extends RuntimeException {
  public InvalidEmployeeType(String message) {
    super(message);
  }
}
