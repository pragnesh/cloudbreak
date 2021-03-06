package com.sequenceiq.cloudbreak.api.endpoint;

import java.util.Set;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sequenceiq.cloudbreak.api.model.BlueprintRequest;
import com.sequenceiq.cloudbreak.api.model.BlueprintResponse;
import com.sequenceiq.cloudbreak.api.model.IdJson;
import com.sequenceiq.cloudbreak.doc.ContentType;
import com.sequenceiq.cloudbreak.doc.ControllerDescription;
import com.sequenceiq.cloudbreak.doc.Notes;
import com.sequenceiq.cloudbreak.doc.OperationDescriptions;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/blueprints")
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "/blueprints", description = ControllerDescription.BLUEPRINT_DESCRIPTION)
public interface BlueprintEndpoint {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = OperationDescriptions.BlueprintOpDescription.GET_BY_ID, produces = ContentType.JSON, notes = Notes.BLUEPRINT_NOTES)
    BlueprintResponse get(@PathParam(value = "id") Long id);

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = OperationDescriptions.BlueprintOpDescription.DELETE_BY_ID, produces = ContentType.JSON, notes = Notes.BLUEPRINT_NOTES)
    void delete(@PathParam(value = "id") Long id);

    @POST
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = OperationDescriptions.BlueprintOpDescription.POST_PRIVATE, produces = ContentType.JSON, notes = Notes.BLUEPRINT_NOTES)
    IdJson postPrivate(@Valid BlueprintRequest blueprintRequest);

    @GET
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = OperationDescriptions.BlueprintOpDescription.GET_PRIVATE, produces = ContentType.JSON, notes = Notes.BLUEPRINT_NOTES)
    Set<BlueprintResponse> getPrivates();

    @GET
    @Path("user/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = OperationDescriptions.BlueprintOpDescription.GET_PRIVATE_BY_NAME, produces = ContentType.JSON, notes = Notes.BLUEPRINT_NOTES)
    BlueprintResponse getPrivate(@PathParam(value = "name") String name);

    @DELETE
    @Path("user/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = OperationDescriptions.BlueprintOpDescription.DELETE_PRIVATE_BY_NAME, produces = ContentType.JSON, notes = Notes.BLUEPRINT_NOTES)
    void deletePrivate(@PathParam(value = "name") String name);

    @POST
    @Path("account")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = OperationDescriptions.BlueprintOpDescription.POST_PUBLIC, produces = ContentType.JSON, notes = Notes.BLUEPRINT_NOTES)
    IdJson postPublic(@Valid BlueprintRequest blueprintRequest);

    @GET
    @Path("account")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = OperationDescriptions.BlueprintOpDescription.GET_PUBLIC, produces = ContentType.JSON, notes = Notes.BLUEPRINT_NOTES)
    Set<BlueprintResponse> getPublics();

    @GET
    @Path("account/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = OperationDescriptions.BlueprintOpDescription.GET_PUBLIC_BY_NAME, produces = ContentType.JSON, notes = Notes.BLUEPRINT_NOTES)
    BlueprintResponse getPublic(@PathParam(value = "name") String name);

    @DELETE
    @Path("account/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = OperationDescriptions.BlueprintOpDescription.DELETE_PUBLIC_BY_NAME, produces = ContentType.JSON, notes = Notes.BLUEPRINT_NOTES)
    void deletePublic(@PathParam(value = "name") String name);

}
