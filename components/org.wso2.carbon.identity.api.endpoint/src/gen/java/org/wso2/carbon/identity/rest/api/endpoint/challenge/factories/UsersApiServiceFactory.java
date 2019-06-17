package org.wso2.carbon.identity.rest.api.endpoint.challenge.factories;

import org.wso2.carbon.identity.rest.api.endpoint.challenge.UsersApiService;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.impl.UsersApiServiceImpl;

public class UsersApiServiceFactory {

   private final static UsersApiService service = new UsersApiServiceImpl();

   public static UsersApiService getUsersApi()
   {
      return service;
   }
}
