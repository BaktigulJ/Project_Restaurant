package peaksoft.service.impl;

import jakarta.xml.bind.helpers.PrintConversionEventImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import peaksoft.enums.Role;
import peaksoft.exceptions.ForbiddenException;
import peaksoft.model.Restaurant;
import peaksoft.model.User;
import peaksoft.repo.UserRepo;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrentUserService {
    private final UserRepo userRepo;


    public void devops(Principal principal) {
        if (principal == null) {
            throw new IllegalArgumentException("Principal cannot be null");
        }
        String email = principal.getName();
        User user = userRepo.getByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found for email: " + email);
        }
        if (!user.getRole().equals(Role.DEVELOPER)) {
            throw new ForbiddenException("Forbidden 403");
        }
    }

    public User adminUser(Principal principal) {
        if (principal == null) {
            throw new IllegalArgumentException("Principal cannot be null");
        }
        String email = principal.getName();
        User user = userRepo.getByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found for email: " + email);
        }
        if (!user.getRole().equals(Role.ADMIN)) {
            throw new ForbiddenException("Forbidden 403");
        }
        return user;
    }

    public User adminAndChef(Principal principal) {
        if (principal == null) {
            throw new IllegalArgumentException("Principal cannot be null");
        }
        String email = principal.getName();
        User user = userRepo.getByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found for email: " + email);
        }
        if (!(user.getRole().equals(Role.ADMIN) || user.getRole().equals(Role.CHEF))) {
            throw new ForbiddenException("Forbidden 403");
        }
        return user;
    }

    public User adminChefWaiter(Principal principal) {
        if (principal == null) {
            throw new IllegalArgumentException("Principal cannot be null");
        }
        String email = principal.getName();
        User user = userRepo.getByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found for email: " + email);
        }
        if (!(user.getRole().equals(Role.ADMIN) || user.getRole().equals(Role.CHEF) ||
                user.getRole().equals(Role.WAITER))) {
            throw new ForbiddenException("Forbidden 403");
        }
        return user;
    }

    public User adminWaiter(Principal principal) {
        if (principal == null) {
            throw new IllegalArgumentException("Principal cannot be null");
        }
        String email = principal.getName();
        User user = userRepo.getByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found for email: " + email);
        }
        if (!(user.getRole().equals(Role.ADMIN) || user.getRole().equals(Role.WAITER))) {
            throw new ForbiddenException("Forbidden 403");
        }
        return user;
    }

    public void checkForbidden(Restaurant adminRestaurant, Restaurant userRestaurant){
        if(!userRestaurant.equals(adminRestaurant)){
            throw new ForbiddenException("Forbidden 403, You are not allowed to delete employees from other restaurants");
        }
    }



}
