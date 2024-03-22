package ladder;

public class Row {

    private static final int right = 1;
    private static final int left = -1;

    private int[] row;

    //row는 가로줄 전체를 보면 됨. 그 가로줄에 어떤 위치에 가로줄이 그어져있고, 그어져 있지 않은지 표현한것.
    //그래서 사다리는 이차원 배열로 만들어짐. 첫번째 레이어의 인덱스는 위쪽부터 가로줄의 묶음 다발이고, 두번째 레이어의 인덱스는 그 가로줄이 어떤 세로선들을 이어주는지를 표현
    //그래서 row의 배열은 새로줄의 개수만큼 있어야 하기 때문에 배열의 길이가 사람수 만큼 지정되는 것이다.
    //row 한줄에 가로로 그어질 지점을 표시해서 왼쪽으로 가면 -1, 오른쪽으로 가면 +1로 배열로 지정 -> 그러면 [1,-1, 0...]
    //이런식으로 저장되고 배열을 돌면서 그 값이 나올 때마다 사용자의 row값이 있는 인덱스 값을 반환하면서 x위치를 옮기고,
    //동시에 y위치를 내려주는 식으로 코드 짜기.
    public Row(int numberOfPerson) {
        //입력받은 사람 수 검증
        validateNumberOfPerson(numberOfPerson);
        //배열을 생성해버리기
        row = new int[numberOfPerson];
    }
    //세로선 하나 긋는데 오른쪽으로 가로선 한번 그으면 다음은 왼쪽으로 가로선 긋는 메서드(당연하지)
    public void drawLine(int lineStartPosition) {
        validateDrawLinePosition(lineStartPosition);
        row[lineStartPosition] = right;
        row[lineStartPosition + 1] = left;
    }

    public int nextPosition(int position) {

        validatePosition(position);
        //현재위치에 왼쪽으로 가로줄이 있을경우, 왼쪽 세로줄로 이동
        if (isLeft(position)) {
            return position + left;
        }
        //현재위치에 오른쪽으로 가로줄이 있을경우, 오른쪽 세로줄로 이동.
        if (isRight(position)) {
            return position + right;
        }
        return position;
    }
    //left가 맞으면 true, 틀리면 false 반환
    private boolean isLeft(int position) {
        return row[position] == left;
    }
    //left랑 반대로
    private boolean isRight(int position) {
        return row[position] == right;
    }

    private void validateNumberOfPerson(int numberOfPerson) {
        if(numberOfPerson < 1) {
            throw new IllegalArgumentException("게임의 참여자 수는 1명 이상이어야 합니다.");
        }
    }

    private void validateDrawLinePosition(int lineStartPosition) {
        //0보다 작은 값은 인덱스를 벗어나고, 마지막 줄은 로직을 통일하기 위해 그 전줄에 그으면 된다. row.length-2에 긋기, 선이 연속으로 그어지면 안됨. 0인 곳에만 긋기
        if(lineStartPosition < 0 || lineStartPosition >= row.length - 1 || row[lineStartPosition] == left || row[lineStartPosition + 1] == right) {
            throw new IllegalArgumentException("라인 생성이 불가능한 위치 입니다.");
        }
    }

    //인덱스에서 벗어낫는지만 검증
    private void validatePosition(int position) {
        if(position >= row.length || position < 0 ) {
            throw new IllegalArgumentException("유효하지 않은 위치 입니다.");
        }
    }
}
