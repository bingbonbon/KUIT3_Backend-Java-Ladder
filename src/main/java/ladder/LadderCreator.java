package ladder;

import java.util.Random;

public class LadderCreator {

    private static Ladder ladder;

    public LadderCreator(NaturalNumber numberOfRows, NaturalNumber numberOfPersons) {
    }

    public Ladder ladderCreator(NaturalNumber numberOfRows, NaturalNumber numberOfPersons) {
        Random random = new Random();
        Ladder ladder = new Ladder(numberOfRows, numberOfPersons);
        for (int i = 0; i < numberOfRows.getNumber(); i++) {
            for (int j = 0; j < numberOfPersons.getNumber(); j++) {
                if(random.nextBoolean()) {
                    ladder.drawLine(i, j);
                }
            }
        }
        return ladder;
    }
}
