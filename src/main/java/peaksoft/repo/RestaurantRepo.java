package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.request.RestaurantRequest;
import peaksoft.dto.response.RestaurantResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.exceptions.NotFoundException;
import peaksoft.model.Restaurant;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
    boolean existByName(String name);

    @Query("select r from Restaurant r where r.id =:restId")
    Optional<Restaurant> findRestaurantById(Long restId);
    default Restaurant getRestaurantById(Long restId){
        return findRestaurantById(restId).orElseThrow(()->
                new NotFoundException("Restaurant with id: "+ restId + " not found"));
    }

}
