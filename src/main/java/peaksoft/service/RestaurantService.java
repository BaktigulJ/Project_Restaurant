package peaksoft.service;


import peaksoft.dto.request.EditRestaurantRequest;
import peaksoft.dto.request.RestaurantRequest;
import peaksoft.dto.request.SaveRestaurantRequest;
import peaksoft.dto.response.RestaurantPaginationResponse;
import peaksoft.dto.response.SimpleResponse;

import java.security.Principal;

public interface RestaurantService {
    
    RestaurantPaginationResponse getAllRes(int page, int size);

    SimpleResponse save(Principal principal, SaveRestaurantRequest saveRestaurantRequest);

    SimpleResponse editRestaurant(EditRestaurantRequest editRestaurantRequest, Principal principal);
}
