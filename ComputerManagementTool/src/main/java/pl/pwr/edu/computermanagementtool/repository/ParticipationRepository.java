package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pwr.edu.computermanagementtool.entity.Participation;

public interface ParticipationRepository extends JpaRepository<Participation, Integer> {
}