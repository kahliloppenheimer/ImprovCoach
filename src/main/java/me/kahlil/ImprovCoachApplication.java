package me.kahlil;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import me.kahlil.health.SayingHealthCheck;
import me.kahlil.resources.SayingResource;

public class ImprovCoachApplication extends Application<ImprovCoachConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ImprovCoachApplication().run(args);
    }

    @Override
    public String getName() {
        return "ImprovCoach";
    }

    @Override
    public void initialize(final Bootstrap<ImprovCoachConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(final ImprovCoachConfiguration configuration,
                    final Environment environment) {
        SayingResource resource = new SayingResource(
                configuration.getTemplate(),
                configuration.getDefaultName());

        SayingHealthCheck sayingHealthCheck = new SayingHealthCheck(configuration.getTemplate());

        environment.jersey().register(resource);
        environment.healthChecks().register("saying", sayingHealthCheck);
    }

}
