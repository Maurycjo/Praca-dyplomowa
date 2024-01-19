package pl.edu.pwr.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pwr.computermanagementtool.entity.Office;

import java.util.Optional;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Integer> {


    Optional<Office> findOfficeByAddress(String address);
}