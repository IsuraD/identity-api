package org.wso2.carbon.identity.rest.api.endpoint.challenge.factories;

import org.wso2.carbon.identity.rest.api.endpoint.challenge.ChallengesApiService;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.impl.ChallengesApiServiceImpl;

public class ChallengesApiServiceFactory {

   private final static ChallengesApiService service = new ChallengesApiServiceImpl();

   public static ChallengesApiService getChallengesApi()
   {
      return service;
   }
}
