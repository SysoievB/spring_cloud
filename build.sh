#!/bin/bash

services=("config_server" "eureka" "gateway" "account" "address" "users")

for service in "${services[@]}"; do
    echo "Building $service..."
    mvn clean install -f $service
    if [ $? -ne 0 ]; then
        echo "Build failed for $service. Exiting..."
        exit 1
    fi
done

echo "✅ All services built successfully!"
