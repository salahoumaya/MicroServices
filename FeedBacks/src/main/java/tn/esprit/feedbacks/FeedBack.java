package tn.esprit.feedbacks;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FeedBack {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private Long trainingId;
    @Min(1)
    @Max(5)
    private int rating;
    @NotBlank
    private String comment;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
