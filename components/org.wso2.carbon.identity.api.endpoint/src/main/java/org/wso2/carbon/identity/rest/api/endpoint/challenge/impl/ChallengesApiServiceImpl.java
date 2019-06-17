package org.wso2.carbon.identity.rest.api.endpoint.challenge.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.recovery.IdentityRecoveryException;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.ChallengesApiService;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.dto.ChallengeQuestionDTO;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.dto.ChallengeQuestionPatchDTO;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.dto.ChallengeSetDTO;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.exeption.ErrorUtil;

import javax.ws.rs.core.Response;
import java.util.List;

import static org.wso2.carbon.identity.rest.api.endpoint.challenge.core.ChallengeService.addChallengeSets;
import static org.wso2.carbon.identity.rest.api.endpoint.challenge.core.ChallengeService.deleteQuestion;
import static org.wso2.carbon.identity.rest.api.endpoint.challenge.core.ChallengeService.deleteQuestionSet;
import static org.wso2.carbon.identity.rest.api.endpoint.challenge.core.ChallengeService.getChallengeSet;
import static org.wso2.carbon.identity.rest.api.endpoint.challenge.core.ChallengeService.getChallenges;
import static org.wso2.carbon.identity.rest.api.endpoint.challenge.core.ChallengeService.patchChallengeSet;
import static org.wso2.carbon.identity.rest.api.endpoint.challenge.core.ChallengeService.updateChallengeSets;

public class ChallengesApiServiceImpl extends ChallengesApiService {
    private static Log log = LogFactory.getLog(ChallengesApiServiceImpl.class);

    @Override
    public Response addChallengeQuestionToASet(String challengeSetId,ChallengeQuestionPatchDTO challengeQuestion){
        // do some magic!

        try {
            return Response.ok().entity(patchChallengeSet(challengeSetId, challengeQuestion)).build();
        } catch (IdentityRecoveryException e) {
            throw ErrorUtil.handleException(log, e);
        }

    }
    @Override
    public Response addChallenges(List<ChallengeSetDTO> challengeSet){
        // do some magic!
        try {
            return Response.ok().entity(addChallengeSets(challengeSet)).build();
        } catch (IdentityRecoveryException e) {
            throw ErrorUtil.handleException(log, e);
        }
    }
    @Override
    public Response deleteChallengeQuestion(String questionId,String challengeSetId,String locale){
        // do some magic!
        try {
            return Response.ok().entity(deleteQuestion(challengeSetId, questionId, locale)).build();
        } catch (IdentityRecoveryException e) {
            throw ErrorUtil.handleException(log, e);
        }
    }
    @Override
    public Response deleteChallengeQuestionSet(String challengeSetId,String locale){
        // do some magic!
        try {
            return Response.ok().entity(deleteQuestionSet(challengeSetId, locale)).build();
        } catch (IdentityRecoveryException e) {
            throw ErrorUtil.handleException(log, e);
        }
    }
    @Override
    public Response getChallengeQuestionSet(String challengeSetId,String locale,Integer offset,Integer limit){
        // do some magic!
        try {
            return Response.ok().entity(getChallengeSet(locale, challengeSetId, offset, limit)).build();
        } catch (IdentityRecoveryException e) {
            throw ErrorUtil.handleException(log, e);
        }    }
    @Override
    public Response searchChallenges(String locale,Integer offset,Integer limit){
        try {
            return Response.ok().entity(getChallenges(locale, offset, limit)).build();
        } catch (IdentityRecoveryException e) {
            throw ErrorUtil.handleException(log, e);
        }
    }
    @Override
    public Response updateChallengeQuestionSet(String challengeSetId,List<ChallengeQuestionDTO> challengeSet){
        // do some magic!
        try {
            return Response.ok().entity(updateChallengeSets(challengeSetId, challengeSet)).build();
        } catch (IdentityRecoveryException e) {
            throw ErrorUtil.handleException(log, e);
        }
    }
}
