package ladder;

public class Row {

    private Node[] row;

    public Row(NaturalNumber numberOfPerson){
        row = new Node[numberOfPerson.getNumber()];
        //일단 전부다 0으로 초기화해주는 작업!
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            row[i] = Node.of(Direction.center);
        }
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);
        assignDirection(startPosition, Direction.right);
        assignDirection(startPosition.back(), Direction.left);
    }

    private void validateDrawLinePosition(Position lineStartPosition) {
        //0보다 작은 값은 인덱스를 벗어나고, 마지막 줄은 로직을 통일하기 위해 그 전줄에 그으면 된다. row.length-2에 긋기. 현재 position에 왼쪽으로 가로선이 있거나, 오른쪽에 왼쪽 가로선이 있으면 선이 중복되서 안됨.
        if(lineStartPosition.getValue() < 0 || lineStartPosition.getValue() >= row.length - 1 || row[lineStartPosition.back().getValue()].isRight() || row[lineStartPosition.getValue()].isLeft()) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    public void assignDirection(Position position, Direction direction) {
        row[position.getValue()] = Node.of(direction);
    }

    public Position movePosition(Position position) {

        validatePosition(position);
        //현재위치에 왼쪽으로 가로줄이 있을경우, 왼쪽 세로줄로 이동
        return row[position.getValue()].move(position);
    }

    //인덱스에서 벗어낫는지만 검증
    private void validatePosition(Position position) {
        //가장 오른쪽 row에서 하나 왼쪽으로 온 row에서만 가능함. 0번째 row왼쪽에는 row가 없음.
        if(position.isRightOutofRow(row.length - 2) || position.isLeftOutofRow(0)) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
    }

    public Node[] getNode() {
        return row;
    }

//    public void generateRow(StringBuilder stringBuilder, int currentRow, Position position) {
//        for(int i; i < row.length; i++) {
//            Node node = row[i];
//            if(node.equals(Node.))
//        }
//    }
}