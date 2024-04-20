package com.example.demo.controllers;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<Long> save(
            @RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll(){
      return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.userService.findById(id));
    }
    @PatchMapping("/validate/{id}")
    public ResponseEntity<Long> validateAccount(@PathVariable Long id){
        return ResponseEntity.ok(this.userService.validateAccount(id));
    }

    @PatchMapping("/invalidate/{id}")
    public ResponseEntity<Long> invalidateAccount(@PathVariable Long id){
        return ResponseEntity.ok(this.userService.invalidateAccount(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        userService.delete(id);
        return ResponseEntity.accepted().build();
    }


}
