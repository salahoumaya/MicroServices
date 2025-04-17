package tn.esprit.emicro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.emicro.entity.Formation;


import java.util.List;


@Repository
public interface FormationRepository extends JpaRepository <Formation, Long> {


}
