/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.carbon.identity.rest.api.endpoint.challenge.exeption;

import org.apache.commons.logging.Log;
import org.wso2.carbon.identity.base.IdentityException;
import org.wso2.carbon.identity.recovery.IdentityRecoveryClientException;
import org.wso2.carbon.identity.recovery.IdentityRecoveryException;
import org.wso2.carbon.identity.recovery.IdentityRecoveryServerException;
import org.wso2.carbon.identity.rest.api.endpoint.common.Constants;
import org.wso2.carbon.identity.rest.api.endpoint.challenge.dto.ErrorDTO;

import javax.ws.rs.WebApplicationException;

public class ErrorUtil {

    /**
     * This method is used to create an InternalServerErrorException with the known errorCode.
     *
     * @return a new InternalServerErrorException with default details.
     */
    public static WebApplicationException handleException(Log log, Throwable e) {

        String description = "";
        String code = "" ;
        String message = Constants.STATUS_INTERNAL_SERVER_ERROR_MESSAGE_DEFAULT;

        if (e instanceof IdentityRecoveryException){
            description = ((IdentityRecoveryException) e).getErrorDescription();
            code = ((IdentityRecoveryException) e).getErrorCode();
            message = e.getMessage();
        }

//        if (e instanceof IdentityRecoveryServerException){
//            description = ((IdentityRecoveryServerException) e).getErrorDescription();
//            code = ((IdentityException) e).getErrorCode();
//        } else if (e instanceof IdentityRecoveryClientException){
//            description = ((IdentityRecoveryClientException) e).getErrorDescription();
//            code = ((IdentityRecoveryClientException) e).getErrorCode();
//        } else if (e instanceof IdentityRecoveryClientException){
//            description = ((IdentityRecoveryClientException) e).getErrorDescription();
//            code = ((IdentityRecoveryClientException) e).getErrorCode();
//        } else if (e instanceof IdentityRecoveryException){
//            description = ((IdentityRecoveryException) e).getErrorDescription();
//            code = ((IdentityRecoveryException) e).getErrorCode();
//        }

        ErrorDTO errorDTO = getErrorDTO(message, description, code);
        logError(log, e);
        return new InternalServerErrorException(errorDTO);
    }

    /**
     * This method is used to create an InternalServerErrorException with the known errorCode.
     *
     * @param code Error Code.
     * @return a new InternalServerErrorException with default details.
     */
    public static InternalServerErrorException buildInternalServerErrorException(String code, String description,
                                                                                 Log log, Throwable e) {

        ErrorDTO errorDTO = getErrorDTO(Constants.STATUS_INTERNAL_SERVER_ERROR_MESSAGE_DEFAULT,
                description, code);
        logError(log, e);
        return new InternalServerErrorException(errorDTO);
    }

    /**
     * This method is used to create a BadRequestException with the known errorCode and message.
     *
     * @param description Error Message Desription.
     * @param code        Error Code.
     * @return BadRequestException with the given errorCode and description.
     */
    public static BadRequestException buildBadRequestException(String description, String code,
                                                               Log log, Throwable e) {

        ErrorDTO errorDTO = getErrorDTO(Constants.STATUS_BAD_REQUEST_MESSAGE_DEFAULT, description, code);
        logDebug(log, e);
        return new BadRequestException(errorDTO);
    }

    /**
     * This method is used to create a ConflictRequestException with the known errorCode and message.
     *
     * @param description Error Message Description.
     * @param code        Error Code.
     * @return ConflictRequestException with the given errorCode and description.
     */
    public static ConflictRequestException buildConflictRequestException(String description, String code,
                                                                         Log log, Throwable e) {

        ErrorDTO errorDTO = getErrorDTO(Constants.STATUS_BAD_REQUEST_MESSAGE_DEFAULT, description, code);
        logDebug(log, e);
        return new ConflictRequestException(errorDTO);
    }

    /**
     * This method is used to create a NotFoundException with the known errorCode and message.
     *
     * @param description Error Message Description.
     * @param code        Error Code.
     * @return NotFoundException with the given errorCode and description.
     */
    public static NotFoundException buildNotFoundRequestException(String description, String code,
                                                                  Log log, Throwable e) {

        ErrorDTO errorDTO = getErrorDTO(Constants.STATUS_BAD_REQUEST_MESSAGE_DEFAULT, description, code);
        logDebug(log, e);
        return new NotFoundException(errorDTO);
    }

    /**
     * This method is used to create a NotFoundException with the known errorCode and message.
     *
     * @param description Error Message Description.
     * @param code        Error Code.
     * @return NotFoundException with the given errorCode and description.
     */
    public static NotImplementedException buildNotImplementedException(String description, String code,
                                                                  Log log, Throwable e) {

        ErrorDTO errorDTO = getErrorDTO(Constants.STATUS_NOT_IMPLEMENTED_MESSAGE_DEFAULT, description, code);
        logDebug(log, e);
        return new NotImplementedException(errorDTO);
    }

    /**
     * This method is used to create a Forbidden Exception with the known errorCode and message.
     *
     * @param description Error Message Description.
     * @param code        Error Code.
     * @return ForbiddenException with the given errorCode and description.
     */
    public static ForbiddenException buildForbiddenException(String description, String code,
                                                             Log log, Throwable e) {

        ErrorDTO errorDTO = getErrorDTO(Constants.STATUS_BAD_REQUEST_MESSAGE_DEFAULT, description, code);
        logDebug(log, e);
        return new ForbiddenException(errorDTO);
    }

    private static void logError(Log log, Throwable throwable) {

        log.error(throwable.getMessage(), throwable);
    }

    private static void logDebug(Log log, Throwable throwable) {

        if (log.isDebugEnabled()) {
            log.debug(Constants.STATUS_BAD_REQUEST_MESSAGE_DEFAULT, throwable);
        }
    }

    private static ErrorDTO getErrorDTO(String message, String description, String code) {

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(code);
        errorDTO.setMessage(message);
        errorDTO.setDescription(description);
        return errorDTO;
    }

}
