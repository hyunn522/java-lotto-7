package lotto.model;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.DrawType;
import lotto.model.dto.DrawResult;
import lotto.model.dto.DrawResults;

public class LottoGame {

    private DrawResults drawResults;

    private final Lottos lottos;
    private final Lotto winningLotto;
    private final int bonusNum;

    public LottoGame(Lottos lottos, Lotto winningLotto, int bonusNum) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }

    public void draw() {
        drawResults = lottos.getDrawResult(winningLotto, bonusNum);
    }

    public Map<DrawType, Integer> generateDrawResult() {
        Map<DrawType, Integer> result = new HashMap<>();

        for (DrawType type : DrawType.values()) {
            result.put(type, 0);
        }

        for (DrawResult singleResult : drawResults.getDrawResults()) {
            DrawType type = singleResult.formatDrawResult();
            result.put(type, result.get(type) + 1);
        }

        return result;
    }

}