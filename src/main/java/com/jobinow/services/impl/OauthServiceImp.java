package com.jobinow.services.impl;

import com.jobinow.model.entities.User;
import com.jobinow.services.spec.OauthService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

/**
 * Implementation of the {@link OauthService} interface for OAuth2 authentication with external providers.
 */
public class OauthServiceImp implements OauthService {

    /**
     * Initializes the OAuth2 authorization request for a given provider.
     *
     * @param clientRegistration The OAuth2 provider to initialize.
     * @return The OAuth2 authorization request.
     */
    @Override
    public OAuth2AuthorizationRequest initAuthorizationRequest(ClientRegistration clientRegistration) {
        // Implementation goes here
        return null;
    }

    /**
     * Retrieves the authorized OAuth2 client for a given provider.
     *
     * @param clientRegistration The OAuth2 provider for which to retrieve the authorized client.
     * @return The authorized OAuth2 client.
     */
    @Override
    public OAuth2AuthorizedClient getAuthorizedClient(ClientRegistration clientRegistration) {
        // Implementation goes here
        return null;
    }

    /**
     * Retrieves the authenticated user from OAuth2 authorization information.
     *
     * @param authorizedClient The OAuth2 authorization information.
     * @return The authenticated user.
     */
    @Override
    public User getUserFromAuthorizedClient(OAuth2AuthorizedClient authorizedClient) {
        // Implementation goes here
        return null;
    }
}