package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
