package me.kahlil;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
        // TODO: application initialization
    }

    @Override
    public void run(final ImprovCoachConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
