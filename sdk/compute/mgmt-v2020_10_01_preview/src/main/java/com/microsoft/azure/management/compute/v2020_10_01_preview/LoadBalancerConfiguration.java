/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute.v2020_10_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes the load balancer configuration.
 */
public class LoadBalancerConfiguration {
    /**
     * Resource Name.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * The properties property.
     */
    @JsonProperty(value = "properties")
    private LoadBalancerConfigurationProperties properties;

    /**
     * Get resource Name.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set resource Name.
     *
     * @param name the name value to set
     * @return the LoadBalancerConfiguration object itself.
     */
    public LoadBalancerConfiguration withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the properties value.
     *
     * @return the properties value
     */
    public LoadBalancerConfigurationProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties value.
     *
     * @param properties the properties value to set
     * @return the LoadBalancerConfiguration object itself.
     */
    public LoadBalancerConfiguration withProperties(LoadBalancerConfigurationProperties properties) {
        this.properties = properties;
        return this;
    }

}