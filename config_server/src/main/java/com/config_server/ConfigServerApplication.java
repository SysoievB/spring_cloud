package com.config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    /**
     * <h1>Spring Cloud Config Server</h1>
     * <p>
     * Spring Cloud Config Server centralizes the configuration of multiple microservices
     * in a distributed system. Instead of maintaining configuration properties
     * (<code>application.properties</code> or <code>application.yml</code>) in each service,
     * Spring Cloud Config Server stores and serves configurations from a central location
     * (such as a Git repository).
     * </p>
     *
     * <h2>🛠️ Key Features</h2>
     * <ul>
     *     <li><b>✅ Centralized Configuration Management</b> – Keep all microservice configurations in one place.</li>
     *     <li><b>✅ Externalized Configuration</b> – Changes to configurations do not require redeployments.</li>
     *     <li><b>✅ Supports Git, SVN, Database, etc.</b> – Configurations are usually stored in Git repositories.</li>
     *     <li><b>✅ Real-time Updates (with Spring Cloud Bus)</b> – Config changes can be refreshed dynamically.</li>
     *     <li><b>✅ Security & Encryption</b> – Secure sensitive properties like API keys & passwords.</li>
     * </ul>
     */


    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
