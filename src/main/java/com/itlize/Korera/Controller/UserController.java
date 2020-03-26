package com.itlize.Korera.Controller;



import com.itlize.Korera.Entity.Role;
import com.itlize.Korera.Entity.User;
import com.itlize.Korera.Service.UserService;
import com.itlize.Korera.Utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private JwtUtils jwtUtils;


    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<?> login (Principal principal) {
        if (principal == null) {
            return ResponseEntity.ok(principal);
        }
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
        User user = userService.findByUsername(authenticationToken.getName());
        user.setToken(jwtUtils.generateToken(authenticationToken));
        return new ResponseEntity<>(userService.findByUsername(principal.getName()), HttpStatus.OK);
    }
}