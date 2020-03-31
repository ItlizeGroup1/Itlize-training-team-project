package com.itlize.Korera.controllers;



import com.itlize.Korera.dbModels.Project;
import com.itlize.Korera.dbModels.Role;
import com.itlize.Korera.dbModels.User;
import com.itlize.Korera.repositories.UserRepository;
import com.itlize.Korera.services.ProjectService;
import com.itlize.Korera.services.UserService;
import com.itlize.Korera.utils.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/test")
    public ResponseEntity<?> test(@RequestBody List<User> users) {
        System.out.println(users);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(Principal principal){
        if(principal == null) {
            //This should be ok http status because this will be used for logout path.
            return ResponseEntity.ok(principal);
        }
        System.out.println("request reaches /users/login route");
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
        System.out.println("request passes /users/login route");
        User user = userService.findByUsername(authenticationToken.getName());
        user.setToken(jwtTokenProvider.generateToken(authenticationToken));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(Principal principal){
        if(principal == null){
            //This should be ok http status because this will be used for logout path.
            return ResponseEntity.ok(principal);
        }
        User user = userService.findByUsername(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/addProject")
    public ResponseEntity<?> addProject(Principal principal,
                                        @RequestParam(name="projectName") String projectName){
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
        User user = userService.findByUsername(authenticationToken.getName());

        Project projectToAdd = new Project();
        projectToAdd.setProjectName(projectName);
        boolean isSuccessful = projectService.create(projectToAdd,user);

        if(!isSuccessful){
            return new ResponseEntity<>("{\"error\":\"sth wrong happens when creating new project!\"}",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projectToAdd,HttpStatus.OK);

    }
}