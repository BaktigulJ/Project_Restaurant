package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.EditRestaurantRequest;
import peaksoft.dto.request.RestaurantRequest;
import peaksoft.dto.request.SaveRestaurantRequest;
import peaksoft.dto.response.AllRestResponse;
import peaksoft.dto.response.RestaurantPaginationResponse;
import peaksoft.dto.response.SimpleResponse;

import peaksoft.enums.Role;
import peaksoft.exceptions.AlreadyExistsException;
import peaksoft.exceptions.BedRequestException;
import peaksoft.exceptions.NotFoundException;
import peaksoft.model.Employee;
import peaksoft.model.Restaurant;
import peaksoft.model.User;
import peaksoft.repo.ChequeRepo;
import peaksoft.repo.RestaurantRepo;
import peaksoft.repo.UserRepo;
import peaksoft.service.RestaurantService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j

public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepo restaurantRepo;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
   // private final EmployeeRepo employeeRepo;
    private final CurrentUserService currentUserService;
    private final ChequeRepo chequeRepo;


    private AllRestResponse convert(Restaurant restaurant) {
        return new AllRestResponse(
                restaurant.getId(), restaurant.getName(), restaurant.getLocation(),
                restaurant.getRestType(),
                restaurant.getNumberOfEmployees(), restaurant.getService());
    }

    @Override
    public RestaurantPaginationResponse getAllRes(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Restaurant> restaurantPage = restaurantRepo.findAll(pageable);

        if (restaurantPage.isEmpty()) throw new NotFoundException("Restaurant is not found");

        List<AllRestResponse> allRestResponses = restaurantPage.getContent().stream()
                .map(this::convert)
                .collect(Collectors.toList());

        return RestaurantPaginationResponse.builder()
                .page(restaurantPage.getNumber() + 1)
                .size(restaurantPage.getNumberOfElements())
                .responses(allRestResponses)
                .build();
    }

    private void checkName(String name){
        boolean exist = restaurantRepo.existByName(name);
        if(exist) throw  new AlreadyExistsException("Restaurant with name: "+ name + " is already exist");
    }
    @Override @Transactional
    public SimpleResponse save(Principal principal, SaveRestaurantRequest saveRestaurantRequest) {
        currentUserService.devops(principal);
        checkName(saveRestaurantRequest.name());
        boolean exist = userRepo.existsByEmail(saveRestaurantRequest.email());
        if(exist) {
            throw new AlreadyExistsException("User with email: " + saveRestaurantRequest.email() + "already exist");
        }

        if(saveRestaurantRequest.service()<1){
            throw new BedRequestException("It cannot be negative");
        }
        User user = new User();
        user.setFirstName(saveRestaurantRequest.firstName());
        user.setLastName(saveRestaurantRequest.lastName());
        user.setDateOfBirth(saveRestaurantRequest.dateOfBirth());
        user.setEmail(saveRestaurantRequest.email());
        user.setPassword(passwordEncoder.encode(saveRestaurantRequest.password()));
        user.setPhoneNumber(saveRestaurantRequest.phoneNumber());
        user.setExperience(saveRestaurantRequest.experience());
        user.setRole(Role.ADMIN);
        userRepo.save(user);

        Restaurant restaurant = new Restaurant();
        restaurant.addUsers(user);
        user.setRestaurant(restaurant);
        restaurant.setName(saveRestaurantRequest.name());
        restaurant.setLocation(saveRestaurantRequest.location());
        restaurant.setRestType(saveRestaurantRequest.restType());
        restaurant.setService(saveRestaurantRequest.service());
        restaurant.setNumberOfEmployees(restaurant.getUsers().size());

        restaurantRepo.save(restaurant);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully saved")
                .build();
    }

    @Override
    public SimpleResponse editRestaurant(EditRestaurantRequest editRestaurantRequest, Principal principal) {
        User user = currentUserService.adminUser(principal);
        checkName(editRestaurantRequest.name());
        Long restId = user.getRestaurant().getId();
        Restaurant restaurant = restaurantRepo.getRestaurantById(restId);

        restaurant.setName(editRestaurantRequest.name());
        restaurant.setLocation(editRestaurantRequest.location());
        restaurant.setRestType(editRestaurantRequest.restType());
        restaurant.setService(editRestaurantRequest.service());
        restaurantRepo.save(restaurant);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Restaurant successfully edited")
                .build();
    }




}
