/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.v2020_09_01;

import rx.Observable;

/**
 * Type representing ResourceHealthMetadatas.
 */
public interface ResourceHealthMetadatas {
    /**
     * Gets the category of ResourceHealthMetadata to use for the given site as a collection.
     * Description for Gets the category of ResourceHealthMetadata to use for the given site as a collection.
     *
     * @param resourceGroupName Name of the resource group to which the resource belongs.
     * @param name Name of web app.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ResourceHealthMetadata> listBySiteAsync(final String resourceGroupName, final String name);

    /**
     * Gets the category of ResourceHealthMetadata to use for the given site.
     * Description for Gets the category of ResourceHealthMetadata to use for the given site.
     *
     * @param resourceGroupName Name of the resource group to which the resource belongs.
     * @param name Name of web app
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ResourceHealthMetadata> getBySiteAsync(String resourceGroupName, String name);

    /**
     * List all ResourceHealthMetadata for all sites in the subscription.
     * Description for List all ResourceHealthMetadata for all sites in the subscription.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ResourceHealthMetadata> listAsync();

    /**
     * List all ResourceHealthMetadata for all sites in the resource group in the subscription.
     * Description for List all ResourceHealthMetadata for all sites in the resource group in the subscription.
     *
     * @param resourceGroupName Name of the resource group to which the resource belongs.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ResourceHealthMetadata> listByResourceGroupAsync(final String resourceGroupName);

    /**
     * Gets the category of ResourceHealthMetadata to use for the given site as a collection.
     * Description for Gets the category of ResourceHealthMetadata to use for the given site as a collection.
     *
     * @param resourceGroupName Name of the resource group to which the resource belongs.
     * @param name Name of web app.
     * @param slot Name of web app slot. If not specified then will default to production slot.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ResourceHealthMetadata> listBySiteSlotAsync(final String resourceGroupName, final String name, final String slot);

    /**
     * Gets the category of ResourceHealthMetadata to use for the given site.
     * Description for Gets the category of ResourceHealthMetadata to use for the given site.
     *
     * @param resourceGroupName Name of the resource group to which the resource belongs.
     * @param name Name of web app
     * @param slot Name of web app slot. If not specified then will default to production slot.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ResourceHealthMetadata> getBySiteSlotAsync(String resourceGroupName, String name, String slot);

}