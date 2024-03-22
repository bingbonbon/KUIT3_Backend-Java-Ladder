package ladder;

public class Position {

    private final int position;
    private final int numberOfPerson;

    private Position(int position) {
        validatePostion(position);
        this.position = position;
    }

    //여기를 어떻게 써야 할까
    private void validatePostion(int position) {
        if (position < 0) {
            throw new RuntimeException("유효하지 않은 위치입니다.");
        }
    }

    //외부에서 수를 주입받으면 안되지 않나..
    public void outOfLadder(int numberOfPerson) {
        if (position > numberOfPerson) {
            throw new RuntimeException("사다리 밖을 나갔습니다.");
        }
    }

    public Position prev() {
        return Position.of(position - 1);
    }

    public Position next() {
        return Position.of(position + 1);
    }

    public static Position of(int position) {
        return new Position(position);
    }
}
