package com.ouharri.Jobinow.services.spec;

import com.ouharri.Jobinow.model.entities.User;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

/**
 * Service interface for OAuth2 authentication with external providers.
 */
public interface OauthService {

    /**
     * Initializes the OAuth2 authorization request for a given provider.
     *
     * @param clientRegistration The OAuth2 provider to initialize.
     * @return The OAuth2 authorization request.
     */
    OAuth2AuthorizationRequest initAuthorizationRequest(ClientRegistration clientRegistration);

    /**
     * Retrieves the authorized OAuth2 client for a given provider.
     *
     * @param clientRegistration The OAuth2 provider for which to retrieve the authorized client.
     * @return The authorized OAuth2 client.
     */
    OAuth2AuthorizedClient getAuthorizedClient(ClientRegistration clientRegistration);

    /**
     * Retrieves the authenticated user from OAuth2 authorization information.
     *
     * @param authorizedClient The OAuth2 authorization information.
     * @return The authenticated user.
     */
    User getUserFromAuthorizedClient(OAuth2AuthorizedClient authorizedClient);

}