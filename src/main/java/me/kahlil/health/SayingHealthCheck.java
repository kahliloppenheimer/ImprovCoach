package me.kahlil.health;

import com.codahale.metrics.health.HealthCheck;

public class SayingHealthCheck extends HealthCheck {

    private final String template;

    public SayingHealthCheck(String template) {
        this.template = template;
    }

    @Override
    public Result check() throws Exception {
        String testName = "TEST";
        String saying = String.format(template, testName);
        if (!saying.contains(testName)) {
            return Result.unhealthy("Template does not include the name!");
        }
        return Result.healthy();
    }
}
