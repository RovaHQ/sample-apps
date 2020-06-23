package com.rovahq.sample.api;

import com.rovahq.sample.model.CreateQuoteRequest;
import com.rovahq.sample.model.CreateQuoteResult;
import com.rovahq.sample.model.FailureResult;
import com.rovahq.sample.model.OrderStatus;
import com.rovahq.sample.model.Route;
import com.rovahq.sample.model.RouteList;
import com.rovahq.sample.model.SubmittedRoute;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Overview ROVA Dispatch API
 *
 * <p>Integrate with ROVA's robust API to power your business with more efficient on demand deliveries. A few lines of code will allow your deliveries to access ROVA’s courier network programmatically leaving you to focus on your unique business needs.</p><p>Here you will find information on how to setup the API integration.</p><p>Have questions? Reach out to us <a href=\"mailto:support@rovahq.com\">support@rovahq.com</a>
 */
@Path("/")
public interface DispatchApi {

    @POST
    @Path("/v3/entity/route/quote")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Quote was successfully created and is returned. The transaction id is included and can be used to create a route with the quoted price.", content = @Content(schema = @Schema(implementation = CreateQuoteResult.class))),
            @ApiResponse(responseCode = "400", description = "The quote cannot be successfully generated, most likely due to a validation error in the data model", content = @Content(schema = @Schema(implementation = FailureResult.class))),
            @ApiResponse(responseCode = "402", description = "Request failed due to reasons other than the data provided", content = @Content(schema = @Schema(implementation = FailureResult.class)))})
    public CreateQuoteResult createQuote(CreateQuoteRequest body);

    @GET
    @Path("/v3/entity/route")
    @Produces({"application/json"})
    @Operation(summary = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A list of routes", content = @Content(schema = @Schema(implementation = RouteList.class)))})
    public RouteList getRoutes(@QueryParam("sortByType") @DefaultValue("CREATED") String sortByType, @QueryParam("sortOrder") @DefaultValue("DESC") String sortOrder, @QueryParam("searchTerm") String searchTerm, @QueryParam("offset") @DefaultValue("0") Integer offset, @QueryParam("limit") @DefaultValue("50") Integer limit);

    @GET
    @Path("/v3/entity/route/{id}")
    @Produces({"application/json"})
    @Operation(summary = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "returns a single route", content = @Content(schema = @Schema(implementation = Route.class))),
            @ApiResponse(responseCode = "404", description = "Route cannot be found", content = @Content(schema = @Schema(implementation = FailureResult.class)))})
    public Route getSingleRoute(@PathParam("id") Integer id);

    @PUT
    @Path("/v3/entity/route/{id}/status")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success, the status has been updated"),
            @ApiResponse(responseCode = "400", description = "Error in the model provided", content = @Content(schema = @Schema(implementation = FailureResult.class))),
            @ApiResponse(responseCode = "402", description = "Request failed due to other reasons, eg route is not eligible for cancellation", content = @Content(schema = @Schema(implementation = FailureResult.class))),
            @ApiResponse(responseCode = "404", description = "Route cannot be found", content = @Content(schema = @Schema(implementation = FailureResult.class)))})
    public void modifyRouteStatus(@PathParam("id") Integer id, OrderStatus body);

    @POST
    @Path("/v3/entity/route")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Route was created successfully", content = @Content(schema = @Schema(implementation = Route.class))),
            @ApiResponse(responseCode = "400", description = "The route cannot be successfully generated, most likely due to a validation error in the data model", content = @Content(schema = @Schema(implementation = FailureResult.class))),
            @ApiResponse(responseCode = "402", description = "Request failed due to reasons other than the data provided", content = @Content(schema = @Schema(implementation = FailureResult.class)))})
    public Route submitRoute(SubmittedRoute body);
}
