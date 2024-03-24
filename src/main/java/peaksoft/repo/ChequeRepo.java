package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.model.Cheque;

@Repository
public interface ChequeRepo extends JpaRepository<Cheque, Long> {

}
