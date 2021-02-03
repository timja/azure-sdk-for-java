/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.synapse.v2020_12_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.synapse.v2020_12_01.PrivateEndpointConnectionsPrivateLinkHubs;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.synapse.v2020_12_01.PrivateEndpointConnectionForPrivateLinkHub;

class PrivateEndpointConnectionsPrivateLinkHubsImpl extends WrapperImpl<PrivateEndpointConnectionsPrivateLinkHubsInner> implements PrivateEndpointConnectionsPrivateLinkHubs {
    private final SynapseManager manager;

    PrivateEndpointConnectionsPrivateLinkHubsImpl(SynapseManager manager) {
        super(manager.inner().privateEndpointConnectionsPrivateLinkHubs());
        this.manager = manager;
    }

    public SynapseManager manager() {
        return this.manager;
    }

    private PrivateEndpointConnectionForPrivateLinkHubImpl wrapModel(PrivateEndpointConnectionForPrivateLinkHubInner inner) {
        return  new PrivateEndpointConnectionForPrivateLinkHubImpl(inner, manager());
    }

    @Override
    public Observable<PrivateEndpointConnectionForPrivateLinkHub> listAsync(final String resourceGroupName, final String privateLinkHubName) {
        PrivateEndpointConnectionsPrivateLinkHubsInner client = this.inner();
        return client.listAsync(resourceGroupName, privateLinkHubName)
        .flatMapIterable(new Func1<Page<PrivateEndpointConnectionForPrivateLinkHubInner>, Iterable<PrivateEndpointConnectionForPrivateLinkHubInner>>() {
            @Override
            public Iterable<PrivateEndpointConnectionForPrivateLinkHubInner> call(Page<PrivateEndpointConnectionForPrivateLinkHubInner> page) {
                return page.items();
            }
        })
        .map(new Func1<PrivateEndpointConnectionForPrivateLinkHubInner, PrivateEndpointConnectionForPrivateLinkHub>() {
            @Override
            public PrivateEndpointConnectionForPrivateLinkHub call(PrivateEndpointConnectionForPrivateLinkHubInner inner) {
                return wrapModel(inner);
            }
        });
    }

}