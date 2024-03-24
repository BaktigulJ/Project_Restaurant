package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.model.Subcategory;

@Repository
public interface SubcategoryRepo extends JpaRepository<Subcategory, Long> {

}
