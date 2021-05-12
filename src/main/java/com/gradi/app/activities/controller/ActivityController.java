package com.gradi.app.activities.controller;

import com.gradi.app.activities.model.ActivityBody;
import com.gradi.app.activities.model.answerRelated.AnswerBody;
import com.gradi.app.activities.service.ActivityServiceInterface;
import com.gradi.app.authentication.jwt.JwtValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/gradi/activities")
public class ActivityController {
    @Autowired
    ActivityServiceInterface activityService;
    @Autowired
    JwtValues jwtValues;

    @PutMapping("/assign")
    public ResponseEntity<?> addActivity(@RequestBody ActivityBody activity){
        activityService.addNewActivity(activity);
        return ResponseEntity.ok("");
    }

    @GetMapping("/currentAct/{memberId}/{groupId}")
    public ResponseEntity<?> getCurrentActivities(@PathVariable String memberId,@PathVariable String groupId){
        var activities=activityService.getCurrentActivities(memberId, groupId);
        return ResponseEntity.ok(activities);
    }

    @GetMapping("/currentAct/{groupId}")
    public ResponseEntity<?> getActivitiesFromGroup(@PathVariable String groupId){
        var activities=activityService.getGroupActivities(groupId);
        return ResponseEntity.ok(activities);
    }

    @PutMapping("/answer")
    public ResponseEntity<?> addAnswer(@RequestBody AnswerBody answer, HttpServletRequest request){
        String token = request.getHeader(jwtValues.getHEADER()).split(jwtValues.getTOKEN_TYPE())[1];
        activityService.addNewAnswer(answer, token.trim());
        return ResponseEntity.ok("");
    }

    @GetMapping("/answers/{activityId}")
    public ResponseEntity<?> getAnswers(@PathVariable String activityId){
        var answers=activityService.getAnswers(activityId);
        return ResponseEntity.ok(answers);
    }
}
