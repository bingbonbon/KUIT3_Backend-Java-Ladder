package ladder;

import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

import java.util.Random;

public class LadderCreator {

    private final Row[] rows;
    private final Random random;

    public LadderCreator(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        random = new Random();
        rows = new Row[numberOfRows.getNumber()];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Row(numberOfPerson);
            //여기부터 렌덤으로 drawLine해주는거 메서드로 뺴주기.
        }
        drawRandomLine();
    }
    private void drawRandomLine() {
        for(int i = 0; i < rows.length; i++) {
            for(int j = 0; j <rows[i].getNode().length - 1; j++) {
                if (random.nextBoolean()) {
                    rows[i].drawLine(Position.of(j));
                }
            }
        }
    }
    //ladderRunner의 run이 Row[]를 파라미터로 받기 때문에 rows를 받을 수 있는 메서드 만들어주기
    public Row[] getRows() {
        return rows;
    }
}
