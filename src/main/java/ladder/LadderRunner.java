package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    //ladder를 받을게 아니라 결국 움직이는 건 Row에 배정했기 때문에 최종적으로는 int값을 받아와야 함.
    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            position = rows[i].movePosition(position);
        }
        return position.getValue();
    }
}
