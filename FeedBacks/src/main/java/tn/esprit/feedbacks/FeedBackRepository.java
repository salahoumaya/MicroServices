package tn.esprit.feedbacks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
    List<FeedBack> findByTrainingId(Long trainingId);
    List<FeedBack> findByUserId(Long userId);

    List<FeedBack> findByRatingGreaterThanEqual(int rating);

    @Query("SELECT AVG(f.rating) FROM FeedBack f WHERE f.trainingId = :trainingId")
    Double getAverageRatingByTraining(@Param("trainingId") Long trainingId);

    @Query("SELECT COUNT(f) FROM FeedBack f WHERE f.trainingId = :trainingId")
    Long countByTrainingId(@Param("trainingId") Long trainingId);

}
