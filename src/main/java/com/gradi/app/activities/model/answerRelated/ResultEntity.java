package com.gradi.app.activities.model.answerRelated;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@Table(name = "results")
public class ResultEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "result_id", columnDefinition = "varchar")
    private String id;

    @Column(name = "answer_id")
    private String answerId;

    @Column(name = "game_name")
    private String game;

    @Column(name = "result")
    private int result;


    public ResultEntity() {
    }

    public ResultEntity(String answerId, String game, int result) {
        this.answerId = answerId;
        this.game = game;
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultEntity that = (ResultEntity) o;
        return result == that.result && Objects.equals(id, that.id) && Objects.equals(answerId, that.answerId) && Objects.equals(game, that.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answerId, game, result);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
