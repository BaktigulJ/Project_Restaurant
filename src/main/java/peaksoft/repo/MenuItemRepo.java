package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.model.MenuItem;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {

}
