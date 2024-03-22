package ladder;

public class NaturalNumber {

    private final int number;
    private NaturalNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < 1) {
            throw new RuntimeException("숫자는 1이상이어야 한다.");
        }
    }

    public static NaturalNumber of(int number) {
        return new NaturalNumber(number);
    }

    public int getNumber() {
        return number;
    }
}
