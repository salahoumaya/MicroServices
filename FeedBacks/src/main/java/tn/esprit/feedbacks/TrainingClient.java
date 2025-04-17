package tn.esprit.feedbacks;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name="TrainingMSProject")
public interface TrainingClient {
    @RequestMapping("/Trainings")
    public List<Training> getTrainings();
    @RequestMapping("/Trainings/{id}")
    public Training getTrainingsById(@PathVariable("id") int id);
}
