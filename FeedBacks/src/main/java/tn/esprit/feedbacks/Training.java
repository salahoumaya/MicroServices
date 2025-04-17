package tn.esprit.feedbacks;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import java.time.LocalDate;

public class Training {

    private static final long serialVersionUID=6;
    @Id
    @GeneratedValue
    private  int id;
    private String title;

    private String level;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private TypeTraining typeTraining;

    public Training() {};
    public Training(String title, String level, String description, TypeTraining typeTraining, LocalDate startDate, LocalDate endDate) {
        this.title=title;
        this.level=level;
        this.description=description;
        this.typeTraining=typeTraining;
        this.startDate=startDate;
        this.endDate=endDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public TypeTraining getTypeTraining() {
        return typeTraining;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setTypeTraining(TypeTraining typeTraining) {
        this.typeTraining = typeTraining;
    }
}

