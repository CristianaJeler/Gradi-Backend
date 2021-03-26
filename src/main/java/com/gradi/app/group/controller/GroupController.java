package com.gradi.app.group.controller;

import com.gradi.app.authentication.jwt.JwtValues;
import com.gradi.app.group.service.GroupServiceInterface;
import com.gradi.app.user.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/gradi/groups")
public class GroupController {
    @Autowired
    JwtValues jwtValues;
    @Autowired
    GroupServiceInterface groupService;
    @Autowired
    UserServiceInterface userService;


    @GetMapping(value = "")
    ResponseEntity<?> getAllUsersGroups(HttpServletRequest request) {
        String token = request.getHeader(jwtValues.getHEADER()).split(jwtValues.getTOKEN_TYPE())[1];
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        var user = userService.getUserEntityByToken(token.trim());
        var groups = groupService.getUsersGroups(user.getId());
        return ResponseEntity.ok(groups);
    }

    @PutMapping(value = "/add")
    ResponseEntity<?> addNewGroup(@RequestBody String name, HttpServletRequest request) {
        String token = request.getHeader(jwtValues.getHEADER()).split(jwtValues.getTOKEN_TYPE())[1];
        var user = userService.getUserEntityByToken(token.trim());
        var group=groupService.addNewGroup(name);
        groupService.addUserGroup(user,group);
        return ResponseEntity.ok(group);
    }
}
