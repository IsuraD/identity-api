package org.wso2.carbon.identity.rest.api.endpoint.challenge;

import org.wso2.carbon.identity.rest.api.endpoint.challenge.dto.*;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.UsersApiService;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.factories.UsersApiServiceFactory;

import io.swagger.annotations.ApiParam;

import org.wso2.carbon.identity.rest.api.endpoint.challenge.dto.ChallengeAnswerDTO;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.dto.ErrorDTO;
import java.util.List;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.dto.ChallengeSetDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/users")


@io.swagger.annotations.Api(value = "/users", description = "the users API")
public class UsersApi  {

   private final UsersApiService delegate = UsersApiServiceFactory.getUsersApi();

    @POST
    @Path("/me/challenge-answers")
    
    
    @io.swagger.annotations.ApiOperation(value = "answers a new challenge question", notes = "Adds a new challenge question answer to the system\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Item Created"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Element Already Exists"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error") })

    public Response addChallengeAnswersForLoggedInUser(@ApiParam(value = "username of the user",required=true ) @PathParam("user-id")  String userId,
    @ApiParam(value = "challenge-question with answer"  ) List<ChallengeAnswerDTO> challengeAnswer)
    {
    return delegate.addChallengeAnswersForLoggedInUser(userId,challengeAnswer);
    }
    @POST
    @Path("/{user-id}/challenge-answers")
    
    
    @io.swagger.annotations.ApiOperation(value = "answers a new challenge question", notes = "Adds a new challenge question answer to the system for a specific user.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Item Created"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found"),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "Element Already Exists"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error") })

    public Response addChallengeAnswersOfAUser(@ApiParam(value = "username of the user",required=true ) @PathParam("user-id")  String userId,
    @ApiParam(value = "challenge question with answer"  ) List<ChallengeAnswerDTO> challengeAnswer)
    {
    return delegate.addChallengeAnswersOfAUser(userId,challengeAnswer);
    }
    @DELETE
    @Path("/{user-id}/challenge-answers/{challenge-set-id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "removes a challenge question answer", notes = "Removes existing challenge question answers of a user\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Item Deleted"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error") })

    public Response deleteChallengeAnswerOfAUser(@ApiParam(value = "Challenge Question set Id",required=true ) @PathParam("challenge-set-id")  String challengeSetId,
    @ApiParam(value = "username of the user",required=true ) @PathParam("user-id")  String userId)
    {
    return delegate.deleteChallengeAnswerOfAUser(challengeSetId,userId);
    }
    @DELETE
    @Path("/me/challenge-answers/{challenge-set-id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "removes a challenge question answer", notes = "Removes existing challenge question answers of authenticated user\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Item Deleted"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error") })

    public Response deleteChallengeAnswerOfLoggedInUser(@ApiParam(value = "Challenge Question set Id",required=true ) @PathParam("challenge-set-id")  String challengeSetId,
    @ApiParam(value = "username of the user",required=true ) @PathParam("user-id")  String userId)
    {
    return delegate.deleteChallengeAnswerOfLoggedInUser(challengeSetId,userId);
    }
    @DELETE
    @Path("/{user-id}/challenge-answers")
    
    
    @io.swagger.annotations.ApiOperation(value = "removes challenge question answers", notes = "Removes existing challenge question answers of a user\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Item Deleted"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error") })

    public Response deleteChallengeAnswersOfAUser(@ApiParam(value = "username of the user",required=true ) @PathParam("user-id")  String userId)
    {
    return delegate.deleteChallengeAnswersOfAUser(userId);
    }
    @DELETE
    @Path("/me/challenge-answers")
    
    
    @io.swagger.annotations.ApiOperation(value = "removes challenge question answers", notes = "Removes an existing challenge question answers of the authenticated user\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Item Deleted"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error") })

    public Response deleteChallengeAnswersOfLoggedInUser(@ApiParam(value = "username of the user",required=true ) @PathParam("user-id")  String userId)
    {
    return delegate.deleteChallengeAnswersOfLoggedInUser(userId);
    }
    @GET
    @Path("/{user-id}/challenge-answers")
    
    
    @io.swagger.annotations.ApiOperation(value = "get user's challenge answers", notes = "Get answered challenges in the system for a specific user.\n", response = ChallengeAnswerDTO.class, responseContainer = "List")
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error") })

    public Response getAnsweredChallengesOfAUser(@ApiParam(value = "username of the user",required=true ) @PathParam("user-id")  String userId)
    {
    return delegate.getAnsweredChallengesOfAUser(userId);
    }
    @GET
    @Path("/me/challenge-answers")
    
    
    @io.swagger.annotations.ApiOperation(value = "get user's challenge answers", notes = "Get answered challenges in the system for a specific user.\n", response = ChallengeAnswerDTO.class, responseContainer = "List")
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error") })

    public Response getAnsweredChallengesOfLoggedInUser(@ApiParam(value = "username of the user",required=true ) @PathParam("user-id")  String userId)
    {
    return delegate.getAnsweredChallengesOfLoggedInUser(userId);
    }
    @GET
    @Path("/{user-id}/challenges")
    
    
    @io.swagger.annotations.ApiOperation(value = "searches challenges available for a user", notes = "Search for\navailable challenges in the system for the user.\n", response = ChallengeSetDTO.class, responseContainer = "List")
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error") })

    public Response getChallengesForAUser(@ApiParam(value = "username of the user",required=true ) @PathParam("user-id")  String userId,
    @ApiParam(value = "number of records to skip for pagination") @QueryParam("offset")  Integer offset,
    @ApiParam(value = "maximum number of records to return") @QueryParam("limit")  Integer limit)
    {
    return delegate.getChallengesForAUser(userId,offset,limit);
    }
    @GET
    @Path("/me/challenges")
    
    
    @io.swagger.annotations.ApiOperation(value = "searches challenge-question for authenticated user", notes = "Retrieve the\navailable challenge-question in the system for the authenticated user\n", response = ChallengeSetDTO.class, responseContainer = "List")
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error") })

    public Response getChallengesForLoggedInUser(@ApiParam(value = "number of records to skip for pagination") @QueryParam("offset")  Integer offset,
    @ApiParam(value = "maximum number of records to return") @QueryParam("limit")  Integer limit)
    {
    return delegate.getChallengesForLoggedInUser(offset,limit);
    }
    @PUT
    @Path("/{user-id}/challenge-answers/{challenge-set-id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "answers a new challenge question", notes = "Adds a new challenge question answer to the system for a specific user.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error") })

    public Response updateChallengeAnswerOfAUser(@ApiParam(value = "Challenge Question set Id",required=true ) @PathParam("challenge-set-id")  String challengeSetId,
    @ApiParam(value = "username of the user",required=true ) @PathParam("user-id")  String userId,
    @ApiParam(value = "challenge-question with answer"  ) ChallengeAnswerDTO challengeAnswer)
    {
    return delegate.updateChallengeAnswerOfAUser(challengeSetId,userId,challengeAnswer);
    }
    @PUT
    @Path("/me/challenge-answers/{challenge-set-id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "answers a new challenge question", notes = "Adds a new challenge question answer to the system for authenticated user.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error") })

    public Response updateChallengeAnswerOfLoggedInUser(@ApiParam(value = "Challenge Question set Id",required=true ) @PathParam("challenge-set-id")  String challengeSetId,
    @ApiParam(value = "username of the user",required=true ) @PathParam("user-id")  String userId,
    @ApiParam(value = "challenge-question with answer"  ) ChallengeAnswerDTO challengeAnswer)
    {
    return delegate.updateChallengeAnswerOfLoggedInUser(challengeSetId,userId,challengeAnswer);
    }
    @PUT
    @Path("/{user-id}/challenge-answers")
    
    
    @io.swagger.annotations.ApiOperation(value = "answers new challenge question combination", notes = "Addsnew challenge question answers to the system for a specific user.\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Item Created"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid input request"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The specified resource is not found"),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error") })

    public Response updateChallengeAnswersOfAUser(@ApiParam(value = "username of the user",required=true ) @PathParam("user-id")  String userId,
    @ApiParam(value = "set of challenge question with answer"  ) List<ChallengeAnswerDTO> challengeAnswers)
    {
    return delegate.updateChallengeAnswersOfAUser(userId,challengeAnswers);
    }
}

