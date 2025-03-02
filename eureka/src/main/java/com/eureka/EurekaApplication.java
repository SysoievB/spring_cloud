package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

	/**
	 * <h1>Spring Cloud Netflix Eureka Server</h1>
	 *
	 * <p>
	 * Eureka is a service discovery server provided by Netflix and integrated with
	 * Spring Cloud. It helps microservices register themselves at runtime and allows
	 * other services to discover them dynamically.
	 * </p>
	 *
	 * <h2>Key Features</h2>
	 * <ul>
	 *     <li><b>Service Registration:</b> Microservices can register themselves with Eureka.</li>
	 *     <li><b>Service Discovery:</b> Clients can fetch the list of registered services.</li>
	 *     <li><b>High Availability:</b> Multiple Eureka servers can be set up for redundancy.</li>
	 *     <li><b>Self-Preservation Mode:</b> Protects against network failures by preserving existing registrations.</li>
	 * </ul>
	 *
	 * <h2>Configuration Properties</h2>
	 * <p>
	 * The Eureka server can be configured using properties such as:
	 * </p>
	 * <ul>
	 *     <li><code>eureka.instance.hostname</code> - The hostname of the Eureka server.</li>
	 *     <li><code>eureka.client.register-with-eureka</code> - Determines whether the Eureka server registers itself.</li>
	 *     <li><code>eureka.client.fetch-registry</code> - Controls whether the Eureka server fetches the registry.</li>
	 *     <li><code>eureka.client.service-url.defaultZone</code> - The default service discovery URL.</li>
	 * </ul>
	 */


	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}

}
