package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class LadderGame {

    public static final String STR_ALL = "all";
    public static final String ERR_MSG_RESULTS_NUMBER = "실행 결과의 갯수는 참여하는 사람의 수와 동일해야 합니다.";
    public static final String ERR_MSG_CANDIDATE_NAME = "참여한 사람의 이름을 입력해야 합니다.";

    private final Names names;
    private final Results results;

    public LadderGame(Names names, Results results) {
        this.names = names;
        this.results = results;
        checkValidationOfResultsNumber(names.getCountOfNames(), results.getResultsSize());
    }

    private void checkValidationOfResultsNumber(int countOfNames, int countOfResults) {
        if (countOfNames != countOfResults) {
            throw new IllegalArgumentException(ERR_MSG_RESULTS_NUMBER);
        }
    }

    public Map<Name, String> getExecutionResultAll(Ladder ladder) {
        Map<Name, String> ladderResult = new LinkedHashMap<>();
        for (int i = 0; i < names.getCountOfNames(); i++) {
            int resultIdx = ladder.getLadderEndIdx(i);
            String result = results.getResults().get(resultIdx);
            ladderResult.put(names.getNames().get(i), result);
        }
        return ladderResult;
    }

    public String getExecutionResult(String candidate, Ladder ladder) {
        Name candidateName = new Name(candidate);
        int idx = names.getNames().indexOf(candidateName);
        int resultIdx = ladder.getLadderEndIdx(idx);
        return results.getResults().get(resultIdx);
    }

    public Names getNames() {
        return names;
    }

    public void validateCandidateName(String candidate) {
        if (!names.isContainedName(new Name(candidate))) {
            throw new IllegalArgumentException(ERR_MSG_CANDIDATE_NAME);
        }
    }
}