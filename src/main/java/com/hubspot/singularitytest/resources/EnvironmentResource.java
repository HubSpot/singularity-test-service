package com.hubspot.singularitytest.resources;

import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.Map;

@Path("/environment")
@Produces(MediaType.APPLICATION_JSON)
public class EnvironmentResource {

  public EnvironmentResource() {}

  @GET
  @Timed
  public Map<String, String> sayHello() {
    Map<String, String> env = System.getenv();
    for (String envName : env.keySet()) {
      System.out.format("%s=%s%n",
        envName,
        env.get(envName));
    }
    return env;
  }
}
