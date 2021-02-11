/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute.v2020_12_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Boot Diagnostics is a debugging feature which allows you to view Console
 * Output and Screenshot to diagnose VM status. &lt;br&gt;&lt;br&gt; You can
 * easily view the output of your console log. &lt;br&gt;&lt;br&gt; Azure also
 * enables you to see a screenshot of the VM from the hypervisor.
 */
public class BootDiagnostics {
    /**
     * Whether boot diagnostics should be enabled on the Virtual Machine.
     */
    @JsonProperty(value = "enabled")
    private Boolean enabled;

    /**
     * Uri of the storage account to use for placing the console output and
     * screenshot. &lt;br&gt;&lt;br&gt;If storageUri is not specified while
     * enabling boot diagnostics, managed storage will be used.
     */
    @JsonProperty(value = "storageUri")
    private String storageUri;

    /**
     * Get whether boot diagnostics should be enabled on the Virtual Machine.
     *
     * @return the enabled value
     */
    public Boolean enabled() {
        return this.enabled;
    }

    /**
     * Set whether boot diagnostics should be enabled on the Virtual Machine.
     *
     * @param enabled the enabled value to set
     * @return the BootDiagnostics object itself.
     */
    public BootDiagnostics withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get uri of the storage account to use for placing the console output and screenshot. &lt;br&gt;&lt;br&gt;If storageUri is not specified while enabling boot diagnostics, managed storage will be used.
     *
     * @return the storageUri value
     */
    public String storageUri() {
        return this.storageUri;
    }

    /**
     * Set uri of the storage account to use for placing the console output and screenshot. &lt;br&gt;&lt;br&gt;If storageUri is not specified while enabling boot diagnostics, managed storage will be used.
     *
     * @param storageUri the storageUri value to set
     * @return the BootDiagnostics object itself.
     */
    public BootDiagnostics withStorageUri(String storageUri) {
        this.storageUri = storageUri;
        return this;
    }

}