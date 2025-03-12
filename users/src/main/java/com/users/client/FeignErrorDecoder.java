package com.users.client;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        String errorMessage = getErrorMessage(response);

        return switch (response.status()) {
            case 404 -> methodKey.contains("getAddress")
                    ? new ResourceNotFoundException("Address not found: " + errorMessage)
                    : new ResourceNotFoundException("Resource not found: " + errorMessage);
            case 500 -> new InternalServerException("Internal Server Error: " + errorMessage);
            default -> new Exception(response.reason());
        };
    }

    private String getErrorMessage(Response response) {
        try {
            if (response.body() != null) {
                return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (Exception ignored) {
        }
        return "No additional error details";
    }

    private static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

    private static class InternalServerException extends RuntimeException {
        public InternalServerException(String message) {
            super(message);
        }
    }
}
