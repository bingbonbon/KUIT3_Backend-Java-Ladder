package ladder;

public class Position {

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public int getValue() {
        return position;
    }

    //공장에서 새로찍는거 처럼 팩토리 메서드-객체를 새로 생성해주는 메서드로 생성자 직접 호출을 못하게 하네...
    public static Position of(int position) {
        validatePosition(position);
        return new Position(position);
    }

    public Position prev() {
        return new Position(position - 1);
    }

    public Position back() {
        return new Position(position + 1);
    }

    private static void validatePosition(int position) {
        if(position < 0) {
            throw new RuntimeException("포지션은 0이상이어야 합니다.");
        }
    }

    //Row에서 int형과 position형은 비교 불가능하기 떄문에 여기서 비교해서 반환해주기!
    public boolean isRightOutofRow(int position) {
        return this.position > position;
    }

    public boolean isLeftOutofRow(int position) {
        return this.position < position;
    }
}
