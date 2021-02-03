/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * abc
 */

package com.microsoft.azure.management.synapse.v2020_12_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.synapse.v2020_12_01.SqlPoolRecommendedSensitivityLabels;
import rx.Completable;

class SqlPoolRecommendedSensitivityLabelsImpl extends WrapperImpl<SqlPoolRecommendedSensitivityLabelsInner> implements SqlPoolRecommendedSensitivityLabels {
    private final SynapseManager manager;

    SqlPoolRecommendedSensitivityLabelsImpl(SynapseManager manager) {
        super(manager.inner().sqlPoolRecommendedSensitivityLabels());
        this.manager = manager;
    }

    public SynapseManager manager() {
        return this.manager;
    }

    @Override
    public Completable updateAsync(String resourceGroupName, String workspaceName, String sqlPoolName) {
        SqlPoolRecommendedSensitivityLabelsInner client = this.inner();
        return client.updateAsync(resourceGroupName, workspaceName, sqlPoolName).toCompletable();
    }

}