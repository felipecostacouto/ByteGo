package com.gpti.bytego.model.entity.exam;

import jakarta.persistence.*;

@Entity
@Table(name = "Exam")
public class Exam
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long ID;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "timeToDeliverInSeconds", nullable = false)
    private int timeToDeliverInSeconds;
    @Column(name = "closedQuestionsAmount", nullable = false)
    private int closedQuestionsAmount;
    @Column(name = "openQuestionsAmount", nullable = false)
    private int openQuestionsAmount;

    public Exam() {}

    public Exam(String name, int timeToDeliverInSeconds, int closedQuestionsAmount, int openQuestionsAmount) {
        this.name = name;
        this.timeToDeliverInSeconds = timeToDeliverInSeconds;
        this.closedQuestionsAmount = closedQuestionsAmount;
        this.openQuestionsAmount = openQuestionsAmount;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeToDeliverInSeconds() {
        return timeToDeliverInSeconds;
    }

    public void setTimeToDeliverInSeconds(int timeToDeliverInSeconds) {
        this.timeToDeliverInSeconds = timeToDeliverInSeconds;
    }

    public int getClosedQuestionsAmount() {
        return closedQuestionsAmount;
    }

    public void setClosedQuestionsAmount(int closedQuestionsAmount) {
        this.closedQuestionsAmount = closedQuestionsAmount;
    }

    public int getOpenQuestionsAmount() {
        return openQuestionsAmount;
    }

    public void setOpenQuestionsAmount(int openQuestionsAmount) {
        this.openQuestionsAmount = openQuestionsAmount;
    }
}
