//package peaksoft.api;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.web.bind.annotation.*;
//import peaksoft.dto.responce.SimpleResponse;
//import peaksoft.model.User;
//import peaksoft.service.UserService;
//
//import java.security.Principal;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/users")
//public class UserAPI {
//    private final UserService userService;
//
//
//
//    @PutMapping("/{userID}")
//    @Secured({"ADMIN, CLIENT"})
//    public SimpleResponse update(@PathVariable Long userID,
//                                 @RequestBody User newUser, Principal principal){
//        return userService.updateUser(userID,newUser, principal);
//    }
//
//    @GetMapping("/{userID}")
//    public User findById(@PathVariable Long userID){
//        return userService.findProductByIdForUser(userID);
//    }
//
//}
