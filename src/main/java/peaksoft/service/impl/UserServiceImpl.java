package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.config.jwt.JwtService;
import peaksoft.dto.request.SignInRequest;
import peaksoft.dto.request.SignUpRequest;
import peaksoft.dto.response.RegisterResponse;
import peaksoft.dto.response.SignInResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.enums.Role;
import peaksoft.model.User;
import peaksoft.repo.UserRepo;
import peaksoft.service.UserService;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j

public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


   /* @Override
    public RegisterResponse signUp(SignUpRequest signUpRequest) {
        boolean exists = userRepo.existsByEmail(signUpRequest.getEmail());
        if (exists) {
            throw new RuntimeException("Email: " + signUpRequest.getEmail() + " already exists");
        }
        if (!signUpRequest.getPassword().equals(signUpRequest.getPasswordConfirm())) {
            throw new RuntimeException("Invalid password");
        }

        User user = new User();
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setDateOfBirth(signUpRequest.getDateOfBirth());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setPhoneNumber(signUpRequest.getPhoneNumber());
        user.setRole(Role.WAITER);
        user.setExperience(signUpRequest.getExperience());

        userRepo.save(user);

        String newToken = jwtService.createToken(user);
        log.info("User successfully saved");
        return RegisterResponse.builder()
                .token(newToken)
                .simpleResponse(SimpleResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .message("User successfully signed up")
                        .build())
                .build();
    }

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        User user = userRepo.findByEmil(signInRequest.getEmail()).orElseThrow(() ->
                new NoSuchElementException("User with email: " + signInRequest.getEmail() + " not found"));
        String encodePassword = user.getPassword();
        String password = signInRequest.getPassword();
        boolean matches = passwordEncoder.matches(password, encodePassword);
        if (!matches) throw new RuntimeException("Invalid password");
        String token = jwtService.createToken(user);

        return SignInResponse.builder()
                .token(token)
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }*/
}
