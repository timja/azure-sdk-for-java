/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appplatform.v2020_11_01_preview.implementation;

import com.microsoft.azure.management.appplatform.v2020_11_01_preview.ResourceUploadDefinition;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;

class ResourceUploadDefinitionImpl extends WrapperImpl<ResourceUploadDefinitionInner> implements ResourceUploadDefinition {
    private final AppPlatformManager manager;
    ResourceUploadDefinitionImpl(ResourceUploadDefinitionInner inner, AppPlatformManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public AppPlatformManager manager() {
        return this.manager;
    }

    @Override
    public String relativePath() {
        return this.inner().relativePath();
    }

    @Override
    public String uploadUrl() {
        return this.inner().uploadUrl();
    }

}