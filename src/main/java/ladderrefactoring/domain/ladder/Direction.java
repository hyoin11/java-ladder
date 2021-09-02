package ladderrefactoring.domain.ladder;

import ladderrefactoring.exception.CustomException;

import java.util.Objects;

public class Direction {

    public static final String EXIST_TRUE_REPETITION = "연속된 사다리가 존재 합니다.";

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        checkTrueRepetition(left, right);
        this.left = left;
        this.right = right;
    }

    private void checkTrueRepetition(boolean beforeValue, boolean currentValue) {
        if (beforeValue && currentValue) {
            throw new CustomException(EXIST_TRUE_REPETITION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
