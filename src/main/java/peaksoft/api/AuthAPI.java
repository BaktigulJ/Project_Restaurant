package peaksoft.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.SignInRequest;
import peaksoft.dto.request.SignUpRequest;
import peaksoft.dto.response.RegisterResponse;
import peaksoft.dto.response.SignInResponse;
import peaksoft.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "Auth API")

public class AuthAPI {
    private final UserService userService;


   /* @PostMapping()
    @Operation(description = "this is registration")
    public RegisterResponse signUp(@RequestBody @Valid SignUpRequest signUpRequest){
        return userService.signUp(signUpRequest);
    }

    @GetMapping("/signIn/{restaurantID}")
    public SignInResponse signIn(@RequestBody SignInRequest signInRequest,
                                 @PathVariable Long restaurantID){

        return userService.signIn(signInRequest);
    }*/

}
