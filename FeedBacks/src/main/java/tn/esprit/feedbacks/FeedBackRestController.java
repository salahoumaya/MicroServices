package tn.esprit.feedbacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FeedBacks")
public class FeedBackRestController {
    @Autowired
    private FeedBackService feedbackService;

    @Autowired
    private FeedBackRepository feedbackRepository;

    @PostMapping
    public ResponseEntity<FeedBack> addFeedback(@RequestBody FeedBack feedback) {
        System.out.println("📥 Feedback reçu : " + feedback);
        return ResponseEntity.ok(feedbackService.addFeedback(feedback));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public List<FeedBack> getFeedBacks() {
        return feedbackService.getAllFeedBacks();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedBack> updateFeedback(@PathVariable Long id, @RequestBody FeedBack feedback) {
        return ResponseEntity.ok(feedbackService.updateFeedback(id, feedback));
    }

    // Filter by rating >=
    @GetMapping("/filter")
    public ResponseEntity<List<FeedBack>> filterByRating(@RequestParam int minRating) {
        return ResponseEntity.ok(feedbackService.filterByRating(minRating));
    }

    // Feedbacks for a training
    @GetMapping("/training/{trainingId}")
    public ResponseEntity<List<FeedBack>> getFeedbacksByTraining(@PathVariable Long trainingId) {
        return ResponseEntity.ok(feedbackService.getFeedbacksByTraining(trainingId));
    }

    // Statistics : average rating
    @GetMapping("/training/{trainingId}/average")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long trainingId) {
        return ResponseEntity.ok(feedbackService.getAverageRating(trainingId));
    }

    // Statistics : count
    @GetMapping("/training/{trainingId}/count")
    public ResponseEntity<Long> getFeedbackCount(@PathVariable Long trainingId) {
        return ResponseEntity.ok(feedbackService.getFeedbackCount(trainingId));
    }

    @GetMapping("/trainings/{id}")
    public  Training GetTrainingById(@PathVariable ("id") int id) {
        return feedbackService.getTrainingsById(id);
    }
    @GetMapping("/trainings")
    public  List<Training> GetJobs() {
        return feedbackService.getListTraining();
    }





}
