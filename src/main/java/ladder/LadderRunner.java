package ladder;

public class LadderRunner {

    private final Ladder ladder;

    //ladder형으로 생성자 파라미터를 받아내면 될거 같다.

    public LadderRunner(Ladder ladder) {
        this.ladder = ladder;
    }

    //ladder에 getRow메서드 만들기.
    public int run(int positionChoice) {
        int currentPosition = positionChoice;
        for(int i = 0; i < ladder.length; i++) {
            currentPosition = rows[i].nextPosition(currentPosition);
        }
        return currentPosition;
    }
}
