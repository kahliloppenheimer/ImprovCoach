package me.kahlil.resources;

import com.codahale.metrics.annotation.Timed;
import me.kahlil.model.ImmutableSaying;
import me.kahlil.model.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/saying")
@Produces(MediaType.APPLICATION_JSON)
public class SayingResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public SayingResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying getSaying(
            @QueryParam("name") Optional<String> name) {

        String value = String.format(template, name.orElse(defaultName));
        return ImmutableSaying.builder()
                .content(value)
                .id(counter.getAndIncrement())
                .build();
    }

}
