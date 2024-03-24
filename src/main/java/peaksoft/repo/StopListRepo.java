package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.model.StopList;

@Repository
public interface StopListRepo extends JpaRepository<StopList, Long> {

}
