package io.github.mavaze.release.config;

import lombok.Builder;
import lombok.Getter;
import org.glassfish.jersey.server.ResourceConfig;

@Getter
@Builder
public class ServerConfig {
    private String hostname;
    private Integer port;
    private ResourceConfig resourceConfig;
    private String shutdownPath;
}
