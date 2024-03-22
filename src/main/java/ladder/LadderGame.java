package ladder;

public class LadderGame {
    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;

    }

    public void gameStart(NaturalNumber numberOfRows, NaturalNumber numberOfPersons, int positionChoice) {
        LadderCreator ladder = new LadderCreator(numberOfRows, numberOfPersons);
        LadderGame ladderGame = LadderRunner
    }
}
