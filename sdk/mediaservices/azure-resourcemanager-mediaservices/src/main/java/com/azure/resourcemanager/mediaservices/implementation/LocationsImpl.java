// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.mediaservices.MediaservicesManager;
import com.azure.resourcemanager.mediaservices.fluent.LocationsClient;
import com.azure.resourcemanager.mediaservices.fluent.models.EntityNameAvailabilityCheckOutputInner;
import com.azure.resourcemanager.mediaservices.models.CheckNameAvailabilityInput;
import com.azure.resourcemanager.mediaservices.models.EntityNameAvailabilityCheckOutput;
import com.azure.resourcemanager.mediaservices.models.Locations;
import com.fasterxml.jackson.annotation.JsonIgnore;

public final class LocationsImpl implements Locations {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(LocationsImpl.class);

    private final LocationsClient innerClient;

    private final MediaservicesManager serviceManager;

    public LocationsImpl(LocationsClient innerClient, MediaservicesManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public EntityNameAvailabilityCheckOutput checkNameAvailability(
        String locationName, CheckNameAvailabilityInput parameters) {
        EntityNameAvailabilityCheckOutputInner inner =
            this.serviceClient().checkNameAvailability(locationName, parameters);
        if (inner != null) {
            return new EntityNameAvailabilityCheckOutputImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<EntityNameAvailabilityCheckOutput> checkNameAvailabilityWithResponse(
        String locationName, CheckNameAvailabilityInput parameters, Context context) {
        Response<EntityNameAvailabilityCheckOutputInner> inner =
            this.serviceClient().checkNameAvailabilityWithResponse(locationName, parameters, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new EntityNameAvailabilityCheckOutputImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    private LocationsClient serviceClient() {
        return this.innerClient;
    }

    private MediaservicesManager manager() {
        return this.serviceManager;
    }
}