package com.hubspot.singularitytest;

import com.hubspot.singularitytest.health.TemplateHealthCheck;
import com.hubspot.singularitytest.resources.EnvironmentResource;
import com.hubspot.singularitytest.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DockerTestService extends Application<DockerTestConfiguration> {
  public static void main(String[] args) throws Exception {
    new DockerTestService().run(args);
  }

  @Override
  public String getName() {
    return "docker-test-service";
  }

  @Override
  public void initialize(Bootstrap<DockerTestConfiguration> bootstrap) {
  }

  @Override
  public void run(DockerTestConfiguration configuration,
                  Environment environment) {
    final TemplateHealthCheck healthCheck =
      new TemplateHealthCheck(configuration.getTemplate());
    environment.healthChecks().register("template", healthCheck);
    environment.jersey().register(new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName()));
    environment.jersey().register(new EnvironmentResource());
  }
}
