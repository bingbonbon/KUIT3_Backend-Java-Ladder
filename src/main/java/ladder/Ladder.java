package ladder;

public class Ladder {
    private Row[] rows;
    private final NaturalNumber numberOfRows, numberOfPerson;

 //numberOfPerson은 한 가로 묶음 그러니까 row배열의 길이를 결정하고, numberOfRows는 세로줄의 길이를 결정
 public Ladder(NaturalNumber numberOfRows, NaturalNumber numberOfPerson) {
        this.numberOfRows = numberOfRows;
        this.numberOfPerson = numberOfPerson;

        //새로줄의 개수를 결정. 일차원 배열 형성
        rows = new Row[numberOfPerson.getNumber()];
        //새로줄의 길이를 얼마나 길게 할지 결정. 이차원 배열 형성
        for(int i = 0; i < numberOfRows.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson.getNumber());
        }
    }

    //row의 drawLine메서드는 특정 세로선 두줄 사이에 연결되는 가로선을 긋는 메서드고, 여기 메서드는 몇번째 층에 가로선을 그을지 결정해주는것!
    public void drawLine(int row, int col) {
        rows[row].drawLine(col);
    }

    public Row[] getRows() {
     return this.rows;
    }
    //나중에 runner클래스로 뺄거지만, 일단 테스트 코드가 돌아가야 하기 때문에 남기기
    public Position run(int positionChoice) {
        Position currentPosition = Position.of(positionChoice);
        for(int i = 0; i < rows.length; i++) {
            currentPosition = rows[i].nextPosition();
        }
        return currentPosition;
    }
}
