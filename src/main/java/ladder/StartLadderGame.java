package ladder;

import java.util.Scanner;

public class StartLadderGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // numberOfRows 입력 받기
        System.out.print("행 수 입력: ");
        int numberOfRows = scanner.nextInt();

        // numberOfPerson 입력 받기
        System.out.print("참가자 수: ");
        int numberOfPerson = scanner.nextInt();


        LadderCreator ladderCreator = new LadderCreator(NaturalNumber.of(numberOfRows), NaturalNumber.of(numberOfPerson));

        Ladder ladder = new Ladder(ladderCreator);

        // 시작 위치 입력 받기
        System.out.print("시작 위치를 입력하세요 (0부터 시작): ");
        int startPosition = scanner.nextInt();

        // LadderRunner를 사용하여 게임 실행
        int result = ladder.gameStart(Position.of(startPosition));

        // 게임 결과 출력
        System.out.println("도착 위치: " + result);

        scanner.close();
    }
}

