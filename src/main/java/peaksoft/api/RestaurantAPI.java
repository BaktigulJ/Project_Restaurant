
package peaksoft.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.EditRestaurantRequest;
import peaksoft.dto.request.SaveRestaurantRequest;
import peaksoft.dto.response.RestaurantPaginationResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.service.RestaurantService;
import peaksoft.service.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")

public class RestaurantAPI {
    private final UserService userService;
    private final RestaurantService restaurantService;

    @Secured("DEVELOPER")
    @PutMapping
    public SimpleResponse saveRestAndAdmin(@RequestBody @Valid SaveRestaurantRequest saveRestaurantRequest,
                                             Principal principal){
        return restaurantService.save(principal, saveRestaurantRequest);
    }

    @Secured({"ADMIN"})
    @PutMapping
    public SimpleResponse saveRestaurant(@RequestBody @Valid EditRestaurantRequest editRestaurantRequest,
                                         Principal principal){
        return restaurantService.editRestaurant(editRestaurantRequest, principal);
    }


    @GetMapping
    public RestaurantPaginationResponse getAll(@RequestParam int page,
                                               @RequestParam int size){
        return restaurantService.getAllRes(page, size);
    }



}

