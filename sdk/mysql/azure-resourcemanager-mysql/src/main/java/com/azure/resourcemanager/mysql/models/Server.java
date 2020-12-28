// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mysql.models;

import com.azure.core.management.Region;
import com.azure.core.util.Context;
import com.azure.resourcemanager.mysql.fluent.models.ServerInner;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/** An immutable client-side representation of Server. */
public interface Server {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the location property: The geo-location where the resource lives.
     *
     * @return the location value.
     */
    String location();

    /**
     * Gets the tags property: Resource tags.
     *
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the identity property: The Azure Active Directory identity of the server.
     *
     * @return the identity value.
     */
    ResourceIdentity identity();

    /**
     * Gets the sku property: The SKU (pricing tier) of the server.
     *
     * @return the sku value.
     */
    Sku sku();

    /**
     * Gets the administratorLogin property: The administrator's login name of a server. Can only be specified when the
     * server is being created (and is required for creation).
     *
     * @return the administratorLogin value.
     */
    String administratorLogin();

    /**
     * Gets the version property: Server version.
     *
     * @return the version value.
     */
    ServerVersion version();

    /**
     * Gets the sslEnforcement property: Enable ssl enforcement or not when connect to server.
     *
     * @return the sslEnforcement value.
     */
    SslEnforcementEnum sslEnforcement();

    /**
     * Gets the minimalTlsVersion property: Enforce a minimal Tls version for the server.
     *
     * @return the minimalTlsVersion value.
     */
    MinimalTlsVersionEnum minimalTlsVersion();

    /**
     * Gets the byokEnforcement property: Status showing whether the server data encryption is enabled with
     * customer-managed keys.
     *
     * @return the byokEnforcement value.
     */
    String byokEnforcement();

    /**
     * Gets the infrastructureEncryption property: Status showing whether the server enabled infrastructure encryption.
     *
     * @return the infrastructureEncryption value.
     */
    InfrastructureEncryption infrastructureEncryption();

    /**
     * Gets the userVisibleState property: A state of a server that is visible to user.
     *
     * @return the userVisibleState value.
     */
    ServerState userVisibleState();

    /**
     * Gets the fullyQualifiedDomainName property: The fully qualified domain name of a server.
     *
     * @return the fullyQualifiedDomainName value.
     */
    String fullyQualifiedDomainName();

    /**
     * Gets the earliestRestoreDate property: Earliest restore point creation time (ISO8601 format).
     *
     * @return the earliestRestoreDate value.
     */
    OffsetDateTime earliestRestoreDate();

    /**
     * Gets the storageProfile property: Storage profile of a server.
     *
     * @return the storageProfile value.
     */
    StorageProfile storageProfile();

    /**
     * Gets the replicationRole property: The replication role of the server.
     *
     * @return the replicationRole value.
     */
    String replicationRole();

    /**
     * Gets the masterServerId property: The master server id of a replica server.
     *
     * @return the masterServerId value.
     */
    String masterServerId();

    /**
     * Gets the replicaCapacity property: The maximum number of replicas that a master server can have.
     *
     * @return the replicaCapacity value.
     */
    Integer replicaCapacity();

    /**
     * Gets the publicNetworkAccess property: Whether or not public network access is allowed for this server. Value is
     * optional but if passed in, must be 'Enabled' or 'Disabled'.
     *
     * @return the publicNetworkAccess value.
     */
    PublicNetworkAccessEnum publicNetworkAccess();

    /**
     * Gets the privateEndpointConnections property: List of private endpoint connections on a server.
     *
     * @return the privateEndpointConnections value.
     */
    List<ServerPrivateEndpointConnection> privateEndpointConnections();

    /**
     * Gets the region of the resource.
     *
     * @return the region of the resource.
     */
    Region region();

    /**
     * Gets the name of the resource region.
     *
     * @return the name of the resource region.
     */
    String regionName();

    /**
     * Gets the inner com.azure.resourcemanager.mysql.fluent.models.ServerInner object.
     *
     * @return the inner object.
     */
    ServerInner innerModel();

    /** The entirety of the Server definition. */
    interface Definition
        extends DefinitionStages.Blank,
            DefinitionStages.WithLocation,
            DefinitionStages.WithResourceGroup,
            DefinitionStages.WithProperties,
            DefinitionStages.WithCreate {
    }
    /** The Server definition stages. */
    interface DefinitionStages {
        /** The first stage of the Server definition. */
        interface Blank extends WithLocation {
        }
        /** The stage of the Server definition allowing to specify location. */
        interface WithLocation {
            /**
             * Specifies the region for the resource.
             *
             * @param location The location the resource resides in.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(Region location);

            /**
             * Specifies the region for the resource.
             *
             * @param location The location the resource resides in.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(String location);
        }
        /** The stage of the Server definition allowing to specify parent resource. */
        interface WithResourceGroup {
            /**
             * Specifies resourceGroupName.
             *
             * @param resourceGroupName The name of the resource group. The name is case insensitive.
             * @return the next definition stage.
             */
            WithProperties withExistingResourceGroup(String resourceGroupName);
        }
        /** The stage of the Server definition allowing to specify properties. */
        interface WithProperties {
            /**
             * Specifies the properties property: Properties of the server..
             *
             * @param properties Properties of the server.
             * @return the next definition stage.
             */
            WithCreate withProperties(ServerPropertiesForCreate properties);
        }
        /**
         * The stage of the Server definition which contains all the minimum required properties for the resource to be
         * created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate
            extends DefinitionStages.WithTags, DefinitionStages.WithIdentity, DefinitionStages.WithSku {
            /**
             * Executes the create request.
             *
             * @return the created resource.
             */
            Server create();

            /**
             * Executes the create request.
             *
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            Server create(Context context);
        }
        /** The stage of the Server definition allowing to specify tags. */
        interface WithTags {
            /**
             * Specifies the tags property: Application-specific metadata in the form of key-value pairs..
             *
             * @param tags Application-specific metadata in the form of key-value pairs.
             * @return the next definition stage.
             */
            WithCreate withTags(Map<String, String> tags);
        }
        /** The stage of the Server definition allowing to specify identity. */
        interface WithIdentity {
            /**
             * Specifies the identity property: The Azure Active Directory identity of the server..
             *
             * @param identity The Azure Active Directory identity of the server.
             * @return the next definition stage.
             */
            WithCreate withIdentity(ResourceIdentity identity);
        }
        /** The stage of the Server definition allowing to specify sku. */
        interface WithSku {
            /**
             * Specifies the sku property: The SKU (pricing tier) of the server..
             *
             * @param sku The SKU (pricing tier) of the server.
             * @return the next definition stage.
             */
            WithCreate withSku(Sku sku);
        }
    }
    /**
     * Begins update for the Server resource.
     *
     * @return the stage of resource update.
     */
    Server.Update update();

    /** The template for Server update. */
    interface Update
        extends UpdateStages.WithTags,
            UpdateStages.WithIdentity,
            UpdateStages.WithSku,
            UpdateStages.WithStorageProfile,
            UpdateStages.WithAdministratorLoginPassword,
            UpdateStages.WithVersion,
            UpdateStages.WithSslEnforcement,
            UpdateStages.WithMinimalTlsVersion,
            UpdateStages.WithPublicNetworkAccess,
            UpdateStages.WithReplicationRole {
        /**
         * Executes the update request.
         *
         * @return the updated resource.
         */
        Server apply();

        /**
         * Executes the update request.
         *
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        Server apply(Context context);
    }
    /** The Server update stages. */
    interface UpdateStages {
        /** The stage of the Server update allowing to specify tags. */
        interface WithTags {
            /**
             * Specifies the tags property: Application-specific metadata in the form of key-value pairs..
             *
             * @param tags Application-specific metadata in the form of key-value pairs.
             * @return the next definition stage.
             */
            Update withTags(Map<String, String> tags);
        }
        /** The stage of the Server update allowing to specify identity. */
        interface WithIdentity {
            /**
             * Specifies the identity property: The Azure Active Directory identity of the server..
             *
             * @param identity The Azure Active Directory identity of the server.
             * @return the next definition stage.
             */
            Update withIdentity(ResourceIdentity identity);
        }
        /** The stage of the Server update allowing to specify sku. */
        interface WithSku {
            /**
             * Specifies the sku property: The SKU (pricing tier) of the server..
             *
             * @param sku The SKU (pricing tier) of the server.
             * @return the next definition stage.
             */
            Update withSku(Sku sku);
        }
        /** The stage of the Server update allowing to specify storageProfile. */
        interface WithStorageProfile {
            /**
             * Specifies the storageProfile property: Storage profile of a server..
             *
             * @param storageProfile Storage profile of a server.
             * @return the next definition stage.
             */
            Update withStorageProfile(StorageProfile storageProfile);
        }
        /** The stage of the Server update allowing to specify administratorLoginPassword. */
        interface WithAdministratorLoginPassword {
            /**
             * Specifies the administratorLoginPassword property: The password of the administrator login..
             *
             * @param administratorLoginPassword The password of the administrator login.
             * @return the next definition stage.
             */
            Update withAdministratorLoginPassword(String administratorLoginPassword);
        }
        /** The stage of the Server update allowing to specify version. */
        interface WithVersion {
            /**
             * Specifies the version property: The version of a server..
             *
             * @param version The version of a server.
             * @return the next definition stage.
             */
            Update withVersion(ServerVersion version);
        }
        /** The stage of the Server update allowing to specify sslEnforcement. */
        interface WithSslEnforcement {
            /**
             * Specifies the sslEnforcement property: Enable ssl enforcement or not when connect to server..
             *
             * @param sslEnforcement Enable ssl enforcement or not when connect to server.
             * @return the next definition stage.
             */
            Update withSslEnforcement(SslEnforcementEnum sslEnforcement);
        }
        /** The stage of the Server update allowing to specify minimalTlsVersion. */
        interface WithMinimalTlsVersion {
            /**
             * Specifies the minimalTlsVersion property: Enforce a minimal Tls version for the server..
             *
             * @param minimalTlsVersion Enforce a minimal Tls version for the server.
             * @return the next definition stage.
             */
            Update withMinimalTlsVersion(MinimalTlsVersionEnum minimalTlsVersion);
        }
        /** The stage of the Server update allowing to specify publicNetworkAccess. */
        interface WithPublicNetworkAccess {
            /**
             * Specifies the publicNetworkAccess property: Whether or not public network access is allowed for this
             * server. Value is optional but if passed in, must be 'Enabled' or 'Disabled'.
             *
             * @param publicNetworkAccess Whether or not public network access is allowed for this server. Value is
             *     optional but if passed in, must be 'Enabled' or 'Disabled'.
             * @return the next definition stage.
             */
            Update withPublicNetworkAccess(PublicNetworkAccessEnum publicNetworkAccess);
        }
        /** The stage of the Server update allowing to specify replicationRole. */
        interface WithReplicationRole {
            /**
             * Specifies the replicationRole property: The replication role of the server..
             *
             * @param replicationRole The replication role of the server.
             * @return the next definition stage.
             */
            Update withReplicationRole(String replicationRole);
        }
    }
    /**
     * Refreshes the resource to sync with Azure.
     *
     * @return the refreshed resource.
     */
    Server refresh();

    /**
     * Refreshes the resource to sync with Azure.
     *
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    Server refresh(Context context);
}