package ladder;

public class Node {

    private Direction direction;

    //노드는 결국 한 row에서 방향값을 나타내기 때문에 direction을 가져오면 됨.
    private Node(Direction direction) {
        this.direction = direction;
    }

    //나중에 row의 movePosition을 갈아끼면 됨.
    public Position move(Position position) {
        //노드값이 1일때
        if (isRight()) {
            return position.back();
        }
        //노드값이 -1일때
        if (isLeft()) {
            return position.prev();
        }
        //노드값이 0일때
        return position;
    }
    //정적 팩터리 메서드 - 외부에서 node값을 가져올 수 있는 방법은 이것밖에 없음!
    public static Node of(Direction direction) {
        return new Node(direction);
    }

    public boolean isRight() {
        return direction == Direction.right;
    }

    public boolean isLeft() {
        return direction == Direction.left;
    }

}
