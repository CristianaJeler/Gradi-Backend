package com.gradi.app.activities.service;


import com.gradi.app.activities.mappers.MediaMapperInterface;
import com.gradi.app.activities.mappers.ResultMapperInterface;
import com.gradi.app.activities.model.ActivityBody;
import com.gradi.app.activities.model.ActivityDetailsEntity;
import com.gradi.app.activities.model.ActivityEntity;
import com.gradi.app.activities.model.answerRelated.*;
import com.gradi.app.activities.model.linkRelated.ActivityLinkEntity;
import com.gradi.app.activities.model.linkRelated.LinkEntity;
import com.gradi.app.activities.model.mediaRelated.ActivityMediaEntity;
import com.gradi.app.activities.model.mediaRelated.MediaDTO;
import com.gradi.app.activities.model.userRelated.ActivityUserEntity;
import com.gradi.app.activities.repository.*;
import com.gradi.app.game.model.ActivityGameEntity;
import com.gradi.app.game.model.GameEntity;
import com.gradi.app.game.repository.GameRepository;
import com.gradi.app.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityServiceInterface{
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    GameRepository gamesRepository;
    @Autowired
    MediaRepository mediaRepository;
    @Autowired
    LinkRepository linkRepository;
    @Autowired
    ActivityGameRepository activityGameRepository;
    @Autowired
    ActivityLinkRepository activityLinkRepository;
    @Autowired
    ActivityMediaRepository activityMediaRepository;
    @Autowired
    ActivityUserRepository activityUserRepository;
    @Autowired
    MediaMapperInterface mediaMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AnswerMediaRepository answerMediaRepository;
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    ResultMapperInterface resultMapper;

    @Override
    public void addNewActivity(ActivityBody activity) {
        var members=activity.getMembers();
        var activityDetails=activity.getActivity();
        var actualActivity=new ActivityEntity(activityDetails.getGroupId(),activityDetails.getDescription(),activityDetails.getDueDate(), activityDetails.getField(), activityDetails.getTitle());
        var games=activityDetails.getGames();
        var media=activityDetails.getMedia();
        var links=activityDetails.getLinks();

        var activityId=activityRepository.save(actualActivity).getId();
        games.forEach(g->{
            var gameId=gamesRepository.save(g).getId();
            activityGameRepository.save(new ActivityGameEntity(activityId, gameId));
        });
        media.forEach(m->{
            var mediaEntity=mediaMapper.mapToMediaContentEntity(m);
            var mediaId=mediaRepository.save(mediaEntity).getId();
            activityMediaRepository.save(new ActivityMediaEntity(activityId, mediaId));
        });
        links.forEach(l->{
            var linkId=linkRepository.save(l).getId();
            activityLinkRepository.save(new ActivityLinkEntity(activityId, linkId));
        });

        members.forEach(m-> activityUserRepository.save(new ActivityUserEntity(activityId,m)));
    }

    @Override
    public List<ActivityDetailsEntity> getCurrentActivities(String username, String groupId) {
        var userId=userRepository.findByUsername(username).getId();
        var usersActivities=activityUserRepository.findAllByUserId(userId);
        List<ActivityDetailsEntity> activities=new ArrayList<>();
        usersActivities.forEach(ua->{
            var actualActivity=activityRepository.findById(ua.getId().getActivityId());
            List<LinkEntity> links=new ArrayList<>();
            List<MediaDTO> media=new ArrayList<>();
            List<GameEntity> games=new ArrayList<>();
            if(actualActivity.isPresent() && actualActivity.get().getGroupId().equals(groupId)) {
                links = activityLinkRepository.findAllByActivityId(actualActivity.get().getId())
                        .stream()
                        .map(actLink -> {
                            var link = linkRepository.findById(actLink.getId().getLinkId());
                            return link.orElse(null);
                        })
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
                media = activityMediaRepository.findAllByActivityId(actualActivity.get().getId())
                        .stream()
                        .map(actMedia -> {
                            var med = mediaRepository.findById(actMedia.getId().getMediaId());
                            return med.orElse(null);
                        })
                        .filter(Objects::nonNull)
                        .map(med-> mediaMapper.mapToMediaDTO(med))
                        .collect(Collectors.toList());
                games = activityGameRepository.findAllByActivityId(actualActivity.get().getId())
                        .stream()
                        .map(actGame -> {
                            var game = gamesRepository.findById(actGame.getId().getGameId());
                            return game.orElse(null);
                        })
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());

                activities.add(new ActivityDetailsEntity(actualActivity.get().getId(),actualActivity.get().getDueDate(),
                        actualActivity.get().getDescription(), actualActivity.get().getTitle(),
                        actualActivity.get().getField(), games, media, links));

            }
        });
        return activities;
    }

    @Override
    public void addNewAnswer(AnswerBody answer, String token) {
        var userId=userRepository.findUserEntityByToken(token).getId();
        var media=answer.getPhotos();
        var actualAnswer= new AnswerEntity(userId,answer.getActivityId());
        var answerId=answerRepository.save(actualAnswer).getId();

        media.forEach(m->{
            var mediaEntity=mediaMapper.mapToMediaContentEntity(m);
            var mediaId=mediaRepository.save(mediaEntity).getId();
            answerMediaRepository.save(new AnswerMediaEntity(answerId, mediaId));
        });


        var results=answer.getGameResults();
        results.forEach(r-> resultRepository.save(new ResultEntity(answerId,r.getGame(),r.getResult())));
    }

    @Override
    public List<AnswerBody> getAnswers(String activityId) {
        var answers=answerRepository.findAllByActivityIdOrderByAddedAt(activityId);
        var returnAnswers=new ArrayList<AnswerBody>();

        answers.forEach(ans->{
            var results=new ArrayList<ResultBody>();
            var media=new ArrayList<MediaDTO>();

           answerMediaRepository.findAllByAnswerId(ans.getId())
           .forEach(am->{
               var med=mediaRepository.findById(am.getId().getMedia_id());
               med.ifPresent(mediaContentEntity -> media.add(mediaMapper.mapToMediaDTO(mediaContentEntity)));
           });

           resultRepository.findAllByAnswerId(ans.getId())
                   .forEach(r-> results.add(resultMapper.mapToResultBody(r)));

           var user=userRepository.findById(ans.getUserId());
           String username="";
           if(user.isPresent())
               username= user.get().getFirstName()+" "+user.get().getLastName();

           var groupId="";
           var act=activityRepository.findById(activityId);
           if(act.isPresent()) groupId=act.get().getGroupId();

           returnAnswers.add(new AnswerBody(activityId,media,groupId,username,results));
        });

        return returnAnswers;
    }

    @Override
    public List<ActivityDetailsEntity> getGroupActivities(String groupId) {
        var acts= activityRepository.findAllByGroupId(groupId);
        return acts.stream()
                .map(act->new ActivityDetailsEntity(act.getId(),act.getDueDate(),
                            act.getDescription(), act.getTitle(),
                            act.getField()
                ))
                .collect(Collectors.toList());
    }
}
