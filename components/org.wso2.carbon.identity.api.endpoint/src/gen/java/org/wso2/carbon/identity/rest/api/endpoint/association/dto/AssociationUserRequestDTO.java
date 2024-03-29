package org.wso2.carbon.identity.rest.api.endpoint.association.dto;

import java.util.ArrayList;
import java.util.List;
import org.wso2.carbon.identity.rest.api.endpoint.association.dto.PropertyDTO;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class AssociationUserRequestDTO  {
  
  
  
  private String userId = null;
  
  
  private String password = null;
  
  
  private List<PropertyDTO> properties = new ArrayList<PropertyDTO>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("properties")
  public List<PropertyDTO> getProperties() {
    return properties;
  }
  public void setProperties(List<PropertyDTO> properties) {
    this.properties = properties;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssociationUserRequestDTO {\n");
    
    sb.append("  userId: ").append(userId).append("\n");
    sb.append("  password: ").append(password).append("\n");
    sb.append("  properties: ").append(properties).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
