package ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {


    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        Ladder ladder  = new Ladder(numberOfRows, numberOfPerson);

        //then
        //ladder가 null인지 아닌지 확인 - 0 : drawLine을 안써줘도 배열에 알아서 0으로 초기화 되기 때문에 null 반환x
        assertNotNull(ladder);
    }

    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);

        //when
        int position = 3;

        //then
        assertThrows(IllegalArgumentException.class, () -> ladder.run(3));
    }

    @Test
    void 사다리_결과_확인() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        NaturalNumber numberOfRows = NaturalNumber.of(4);
        Ladder ladder = new Ladder(numberOfRows, numberOfPerson);
        ladder.drawLine(1,0);
        ladder.drawLine(1,2);
        ladder.drawLine(2,1);


        //when
        int position = 0;
        int resultPosition = ladder.run(position);
        //then
        assertEquals(2, resultPosition);

        //when
        position = 1;
        resultPosition = ladder.run(position);
        //then
        assertEquals(0, resultPosition);

        //when
        position = 2;
        resultPosition = ladder.run(position);
        //then
        assertEquals(3, resultPosition);

        //when
        position = 3;
        resultPosition = ladder.run(position);
        //then
        assertEquals(1, resultPosition);

    }
}