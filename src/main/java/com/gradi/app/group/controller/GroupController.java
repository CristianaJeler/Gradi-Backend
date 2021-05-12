package com.gradi.app.group.controller;

import com.gradi.app.apiResponse.ApiResponse;
import com.gradi.app.authentication.jwt.JwtValues;
import com.gradi.app.group.dtos.GroupDTO;
import com.gradi.app.group.model.GroupEntity;
import com.gradi.app.group.service.GroupServiceInterface;
import com.gradi.app.user.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

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
//
//    static Session session;
//    private static HashMap<String, String> users = new HashMap<>();


    @GetMapping(value = "")
    public ResponseEntity<Collection<GroupEntity>> getAllUsersGroups(HttpServletRequest request) {
        String token = request.getHeader(jwtValues.getHEADER()).split(jwtValues.getTOKEN_TYPE())[1];
        var user = userService.getUserEntityByToken(token.trim());
        var groups = groupService.getUsersGroups(user.getId());
        return ResponseEntity.ok(groups);
    }

    @PutMapping(value = "")
    public ResponseEntity<GroupEntity> addNewGroup(@RequestBody GroupDTO newGroup, HttpServletRequest request) {
        String token = request.getHeader(jwtValues.getHEADER()).split(jwtValues.getTOKEN_TYPE())[1];
        var user = userService.getUserEntityByToken(token.trim());
        newGroup.setMembersNo(1);
        var group = groupService.addNewGroup(newGroup);
        groupService.addUserGroup(user, group);
        return ResponseEntity.ok(group);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GroupEntity> getGroupDetails(@PathVariable String id) {
        var group = groupService.getGroup(id);
        return ResponseEntity.ok(group);
    }
}
