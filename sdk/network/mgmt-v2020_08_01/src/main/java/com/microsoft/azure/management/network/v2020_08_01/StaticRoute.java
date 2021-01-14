/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_08_01;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * List of all Static Routes.
 */
public class StaticRoute {
    /**
     * The name of the StaticRoute that is unique within a VnetRoute.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * List of all address prefixes.
     */
    @JsonProperty(value = "addressPrefixes")
    private List<String> addressPrefixes;

    /**
     * The ip address of the next hop.
     */
    @JsonProperty(value = "nextHopIpAddress")
    private String nextHopIpAddress;

    /**
     * Get the name of the StaticRoute that is unique within a VnetRoute.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name of the StaticRoute that is unique within a VnetRoute.
     *
     * @param name the name value to set
     * @return the StaticRoute object itself.
     */
    public StaticRoute withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get list of all address prefixes.
     *
     * @return the addressPrefixes value
     */
    public List<String> addressPrefixes() {
        return this.addressPrefixes;
    }

    /**
     * Set list of all address prefixes.
     *
     * @param addressPrefixes the addressPrefixes value to set
     * @return the StaticRoute object itself.
     */
    public StaticRoute withAddressPrefixes(List<String> addressPrefixes) {
        this.addressPrefixes = addressPrefixes;
        return this;
    }

    /**
     * Get the ip address of the next hop.
     *
     * @return the nextHopIpAddress value
     */
    public String nextHopIpAddress() {
        return this.nextHopIpAddress;
    }

    /**
     * Set the ip address of the next hop.
     *
     * @param nextHopIpAddress the nextHopIpAddress value to set
     * @return the StaticRoute object itself.
     */
    public StaticRoute withNextHopIpAddress(String nextHopIpAddress) {
        this.nextHopIpAddress = nextHopIpAddress;
        return this;
    }

}