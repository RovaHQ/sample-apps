package com.rovahq.sample.api;

import com.rovahq.sample.model.AuthResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Overview ROVA Dispatch API
 *
 * <p>Integrate with ROVA's robust API to power your business with more efficient on demand deliveries. A few lines of code will allow your deliveries to access ROVA’s courier network programmatically leaving you to focus on your unique business needs.</p><p>Here you will find information on how to setup the API integration.</p><p>Have questions? Reach out to us <a href=\"mailto:support@rovahq.com\">support@rovahq.com</a>
 */
@Path("/")
public interface AuthorizationApi {

    /**
     * The OAuth 2.0 authentication flow
     * <p>
     * Lets Authenticate &lt;br&gt; &#x60;curl -v https://api.rovahq.com/v2/oauth/authorize?client_id&#x3D;&lt;CLIENT_ID&gt;&amp;response_type&#x3D;code&#x60;
     */
    @GET
    @Path("/v2/oauth/authorize")
    @Operation(summary = "The OAuth 2.0 authentication flow", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "302", description = "Receive Redirect<br>Once authorized, it would issue a HTTP 302 redirect.  The authorization code will expire in 10 mins <br><br>`GET http://redirect_uri/?code=AUTHORIZATION_CODE`"),
            @ApiResponse(responseCode = "401", description = "indiciates invalid client or invalid type or invalid scope")})
    public void v2OauthAuthorizeGet(@QueryParam("client_id") String clientId, @QueryParam("response_type") String responseType, @QueryParam("redirect_uri") String redirectUri, @QueryParam("scope") String scope);

    /**
     * Invalidates the bearer token
     * <p>
     * If a user would like to deactive a token, they could with&lt;br&gt;&#x60;curl \&quot;client_id&#x3D;&lt;CLIENT_ID&gt;\&quot; -F \&quot;client_secret&#x3D;&lt;CLIENT_SECRET&gt;\&quot; -F \&quot;token&#x3D;&lt;CODE&gt;\&quot; https://api.rovahq.com/v2/oauth/revoke&#x60;
     */
    @POST
    @Path("/v2/oauth/revoke")
    @Consumes({"application/x-www-form-urlencoded"})
    @Operation(summary = "Invalidates the bearer token", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "401", description = "invalid client"),
            @ApiResponse(responseCode = "200", description = "server error")})
    public void v2OauthRevokePost(@FormParam("client_id") String clientId, @FormParam("client_secret") String clientSecret, @FormParam("token") String token);

    /**
     * Retrieve Access Token
     * <p>
     * Example 1.&lt;br&gt;Lets retrieve the access token &#x60;curl -F “client_id&#x3D;&lt;CLIENT_ID&gt;” -F “client_secret&#x3D;&lt;CLIENT_SECRET” -F “code&#x3D;&lt;AUTHORIZATION_CODE&gt;” -F “grant_type&#x3D;authorization_code” https://api.rovahq.com/v2/oauth/token&#x60;&lt;br&gt;&lt;br&gt;Example 2.&lt;br&gt;Lets retrieve the access token with a refresh token &#x60;curl -F “client_id&#x3D;&lt;CLIENT_ID&gt;” -F “client_secret&#x3D;&lt;CLIENT_SECRET” -F “refresh_token&#x3D;&lt;REFRESH_TOKEN&gt;” -F “grant_type&#x3D;refresh_token” https://api.rovahq.com/v2/oauth/token&#x60;
     */
    @POST
    @Path("/v2/oauth/token")
    @Consumes({"application/x-www-form-urlencoded"})
    @Produces({"application/json"})
    @Operation(summary = "Retrieve Access Token", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = AuthResponse.class))),
            @ApiResponse(responseCode = "401", description = "indicates invalid client, invalid request, invalid grant"),
            @ApiResponse(responseCode = "200", description = "server error")})
    public AuthResponse v2OauthTokenPost(@FormParam("client_id") String clientId,
                                         @FormParam("client_secret") String clientSecret, @FormParam("code") String code,
                                         @FormParam("grant_type") String grantType, @FormParam("redirect_uri") String redirectUri);
}
