package ladder;

public enum Direction {

    left(-1), right(1), center(0);

    private final int number;
    Direction(int number) {
        this.number = number;
    }
}
