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
     * Initialise l'autorisation OAuth2 pour un fournisseur donné.
     *
     * @param clientRegistration Le fournisseur OAuth2 à initialiser.
     * @return La requête d'autorisation OAuth2.
     */
    OAuth2AuthorizationRequest initAuthorizationRequest(ClientRegistration clientRegistration);

    /**
     * Récupère le client OAuth2 autorisé pour un fournisseur donné.
     *
     * @param clientRegistration Le fournisseur OAuth2 pour lequel récupérer le client autorisé.
     * @return Le client OAuth2 autorisé.
     */
    OAuth2AuthorizedClient getAuthorizedClient(ClientRegistration clientRegistration);

    /**
     * Récupère l'utilisateur authentifié à partir des informations d'autorisation OAuth2.
     *
     * @param authorizedClient Les informations d'autorisation OAuth2.
     * @return L'utilisateur authentifié.
     */
    User getUserFromAuthorizedClient(OAuth2AuthorizedClient authorizedClient);

}