package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void 방향대로_움직이기() {
        Position startPosition = Position.of(1);
        Position destination = Node.of(Direction.left).move(startPosition);
        assertEquals(0, destination.getValue());

        //position값이 변하는 게 아니기 때문에 위의 케이스와 서로 영향x
        Position destination1 = Node.of(Direction.right).move(startPosition);
        assertEquals(2, destination1.getValue());
    }

    @Test
    void 선_없을_때_그대로_있음() {
        Position startPosition = Position.of(1);
        Position destination = Node.of(Direction.center).move(startPosition);
        assertEquals(1, destination.getValue());
    }

}