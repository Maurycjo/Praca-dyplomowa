package pl.pwr.edu.computermanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import pl.pwr.edu.computermanagementtool.entity.Office;

import java.util.Optional;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Integer> {


    Optional<Office> findOfficeByAddress(String address);
}