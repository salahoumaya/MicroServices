package tn.esprit.feedbacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedBackService implements IFeedBack{

    @Autowired
    private FeedBackRepository feedBackRepository;
    @Autowired
    private TrainingClient trainingClient;


    public FeedBack addFeedback(FeedBack feedback) {
        feedback.setCreatedAt(LocalDateTime.now());
        feedback.setUpdatedAt(LocalDateTime.now());
        return feedBackRepository.save(feedback);
    }

    public List<FeedBack> getFeedbacksByTraining(Long trainingId) {
        return feedBackRepository.findByTrainingId(trainingId);
    }

    public void deleteFeedback(Long feedbackId) {
        feedBackRepository.deleteById(feedbackId);
    }


    public List<FeedBack> getAllFeedBacks() {
        return feedBackRepository.findAll();
    }

    public FeedBack updateFeedback(Long feedbackId, FeedBack newFeedback) {
        FeedBack existingFeedback = feedBackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Feedback not found with id : " + feedbackId));

        existingFeedback.setUserId(newFeedback.getUserId());
        existingFeedback.setTrainingId(newFeedback.getTrainingId());
        existingFeedback.setRating(newFeedback.getRating());
        existingFeedback.setComment(newFeedback.getComment());
        existingFeedback.setUpdatedAt(LocalDateTime.now());

        return feedBackRepository.save(existingFeedback);
    }
    public List<FeedBack> filterByRating(int minRating) {
        return feedBackRepository.findByRatingGreaterThanEqual(minRating);
    }

    public Double getAverageRating(Long trainingId) {
        return feedBackRepository.getAverageRatingByTraining(trainingId);
    }

    public Long getFeedbackCount(Long trainingId) {
        return feedBackRepository.countByTrainingId(trainingId);
    }



    public List<Training> getListTraining() {
        return trainingClient.getTrainings();
    }

    public Training getTrainingsById(int id) {
        return trainingClient.getTrainingsById(id);
    }

}
