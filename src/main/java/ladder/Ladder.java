package ladder;

public class Ladder {

    //LadderGame의 생성자는 LadderCreator를 뱉어내야 함. run메서드를 구현해서 LadderRunner를 뱉어내면서  LadderRunner의 run을 뱉어내야 함.
    //근데 생각해보니까 LadderCreator를 만들필요 없이 이미 Ladder가 ladder를 만들어서 뱉어내는 듯.
    //그러면 LadderGame은 ladder를 받아서 run하는 것만 구현하면 되지 않을까?
    //LadderRunner는 Ladder를 받아서 run메서드를 구현해야 함. 이게 진짜 실질 run메서드. Game에 있던 run은 그냥 실행하는것
    //Ladder의 getRow는 ladder를 돌려야 할 떄 받아올 수 있도록 하는 것.
    LadderCreator ladderCreator;

    public Ladder(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int gameStart(Position positionChoice) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        return ladderRunner.run(positionChoice);
    }

    //Ladder를 외부에서 객체를 만들어 내면 ladder는 0, 0, 0, 0/0, 0, 0, 0으로 초기화 되어 있음.
    //할일 : 그래서 LadderTest를 수정할 떄 drawLine없이 만들면 assertAll했을 때, 모든 노드들이 0으로 초기화 되어 있어야 함!
    //LadderCreator 부분 반환을 Ladder로 반환.
//    public String showLadder(Row[] rows, Position position) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i = 0; i < rows.length; i++) {
//            Row row = rows[i];
//            row.generateRow(stringBuilder, i, position);
//        }
//        return stringBuilder.toString();
//    }


}