package com.gradi.app.activities.model.answerRelated;

import java.io.Serializable;

public class ResultBody implements Serializable {
    String game;

    public ResultBody() {
    }

    public ResultBody(String game, Integer result) {
        this.game = game;
        this.result = result;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    Integer result;
}
