package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.APIResponse;
import com.example.lab10.Model.User;
import com.example.lab10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get-all")
    public ResponseEntity getAll() {
        if (!userService.getall().isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(userService.getall());
        return ResponseEntity.status(400).body(new APIResponse("Empty List of users"));
    }

@PostMapping("/add-user")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("User ID " + user.getID() + " name " + user.getName() + " is added successfully"));
    }
    @PutMapping("/update-user/{ID}")
    public ResponseEntity update(@PathVariable Integer ID,@RequestBody @Valid User user,Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (userService.updateUser(ID,user))
            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Updated successfully"));
        return ResponseEntity.status(400).body(new APIResponse("Updated failed"));
    }@DeleteMapping("/delete-user/{ID}")
public ResponseEntity delete(@PathVariable Integer ID){
        if (userService.deleteUser(ID))
            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Deleted successfully"));
    return ResponseEntity.status(400).body(new APIResponse("Deleted failed"));

}
}