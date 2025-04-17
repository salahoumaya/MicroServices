package tn.esprit.emicro.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.emicro.entity.Diplome;


@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Long> {
}
