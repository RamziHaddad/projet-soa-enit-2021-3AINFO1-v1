package com.iam.security;
import io.quarkus.oidc.UserInfo;
import io.quarkus.security.identity.SecurityIdentity;
import org.jboss.resteasy.annotations.cache.NoCache;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.io.IOException;

import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.UserRepresentation;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/users")
public class ProfileResource {
   
    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    UserInfo userInfo;

    @Inject
    JsonWebToken jwt;

    @GET
    @Path("/admin")
    @RolesAllowed("admin")
    public Map<String, String> admin() {
        return Map.of(
                "ID", jwt.getSubject(),
                "preferred_username", jwt.getClaim("preferred_username")
        );
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("create")
    public  String createUser(User userE) {

        String serverUrl = "http://localhost:8180/auth/";
        String realm = "quarkus";
        // idm-client needs to allow "Direct Access Grants: Resource Owner Password Credentials Grant"
        String clientId = "backend-service";
        String clientSecret = "1a0e7d07-221e-47c8-9214-e8641a03fdc7";

                // User "idm-admin" needs at least "manage-users, view-clients, view-realm, view-users" roles for "realm-management"
                Keycloak keycloak = KeycloakBuilder
                .builder()
                .serverUrl(serverUrl)
                .realm("master")
                .username("user")
                .password("bitnami")
                .clientId("admin-cli")
                .build();

                // Define user
                UserRepresentation user = new UserRepresentation();
                user.setEnabled(true);
                user.setUsername(userE.username);
                user.setFirstName(userE.firstName);
                user.setLastName(userE.lastName);
                user.setEmail(userE.email);

                 // Get realm
        RealmResource realmResource = keycloak.realm(realm);
        UsersResource usersRessource = realmResource.users();

        // Create user (requires manage-users role)
        Response response = usersRessource.create(user);
        System.out.printf("Repsonse: %s %s%n", response.getStatus(), response.getStatusInfo());
        System.out.println(response.getLocation());
        String userId = CreatedResponseUtil.getCreatedId(response);

        System.out.printf("User created with userId: %s%n", userId);

        // Define password credential
        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(userE.password);

        UserResource userResource = usersRessource.get(userId);

        // Set password credential
        userResource.resetPassword(passwordCred);

        // Get realm role "tester" (requires view-realm role)
        RoleRepresentation testerRealmRole = realmResource.roles()//
                .get(userE.role).toRepresentation();

        // Assign realm role tester to user
        userResource.roles().realmLevel() //
                .add(Arrays.asList(testerRealmRole));

       


        return "User created";
    }

    @GET
    @Path("me")
    @RolesAllowed("user")
    public  String me() {

        return securityIdentity.getPrincipal().getName();
    }


    @GET
    @Path("listusers")
    public  List<UserRepresentation> allUsers() {
        String serverUrl = "http://localhost:8180/auth/";

        Keycloak keycloak = KeycloakBuilder
        .builder()
        .serverUrl(serverUrl)
        .realm("master")
        .username("user")
        .password("bitnami")
        .clientId("admin-cli")
        .build();

        RealmResource realmResource = keycloak.realm("quarkus");
        UsersResource usersRessource = realmResource.users();

        // list of all users
        List<UserRepresentation> list = keycloak.realm("quarkus").users().list();

        return list;
    }


}