package org.wso2.carbon.identity.rest.api.endpoint.challenge.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.recovery.IdentityRecoveryException;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.ApiResponseMessage;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.UsersApiService;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.dto.ChallengeAnswerDTO;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.exeption.ErrorUtil;

import javax.ws.rs.core.Response;
import java.util.List;

import static org.wso2.carbon.identity.rest.api.endpoint.challenge.core.ChallengeService.getChallengeAnswersOfUser;
import static org.wso2.carbon.identity.rest.api.endpoint.challenge.core.ChallengeService.getChallengesForUser;
import static org.wso2.carbon.identity.rest.api.endpoint.challenge.core.ChallengeService.setChallengeAnswersOfUser;

public class UsersApiServiceImpl extends UsersApiService {
    private static Log log = LogFactory.getLog(UsersApiServiceImpl.class);

    @Override
    public Response addChallengeAnswersForLoggedInUser(String userId,List<ChallengeAnswerDTO> challengeAnswer){
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response addChallengeAnswersOfAUser(String userId,List<ChallengeAnswerDTO> challengeAnswer){
        // do some magic!
        try {
            return Response.ok().entity(setChallengeAnswersOfUser(userId, challengeAnswer)).build();
        } catch (IdentityRecoveryException e) {
            throw ErrorUtil.handleException(log, e);
        }
    }

    @Override
    public Response deleteChallengeAnswerOfAUser(String challengeSetId,String userId){
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteChallengeAnswerOfLoggedInUser(String challengeSetId,String userId){
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteChallengeAnswersOfAUser(String userId){
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteChallengeAnswersOfLoggedInUser(String userId){
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getAnsweredChallengesOfAUser(String userId){
        // do some magic!
        try {
            return Response.ok().entity(getChallengeAnswersOfUser(userId)).build();
        } catch (IdentityRecoveryException e) {
            throw ErrorUtil.handleException(log, e);
        }
    }
    @Override
    public Response getAnsweredChallengesOfLoggedInUser(String userId){
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getChallengesForAUser(String userId, Integer offset, Integer limit) {
        // do some magic!
        try {
            return Response.ok().entity(getChallengesForUser(userId, offset, limit)).build();
        } catch (IdentityRecoveryException e) {
            throw ErrorUtil.handleException(log, e);
        }
    }
    @Override
    public Response getChallengesForLoggedInUser(Integer offset,Integer limit){
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateChallengeAnswerOfAUser(String challengeSetId,String userId,ChallengeAnswerDTO challengeAnswer){
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateChallengeAnswerOfLoggedInUser(String challengeSetId,String userId,ChallengeAnswerDTO challengeAnswer){
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateChallengeAnswersOfAUser(String userId,List<ChallengeAnswerDTO> challengeAnswers){
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
