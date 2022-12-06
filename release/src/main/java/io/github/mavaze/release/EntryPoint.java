package io.github.mavaze.release;

import org.glassfish.jersey.server.ResourceConfig;

import io.github.mavaze.centralbank.CentralBankFeature;
import io.github.mavaze.corebank.CoreBankingFeature;
import io.github.mavaze.release.config.ServerConfig;

public class EntryPoint {

    public static void main(String[] args) {
        final ResourceConfig resourceConfig = new ResourceConfig()
                .register(CentralBankFeature.class)
                .register(CoreBankingFeature.class);

        final ServerConfig config = ServerConfig.builder()
                .resourceConfig(resourceConfig)
                .hostname("http://localhost/")
                .shutdownPath("/exit")
                .port(9998)
                .build();

        Server.start(config);
    }
}
