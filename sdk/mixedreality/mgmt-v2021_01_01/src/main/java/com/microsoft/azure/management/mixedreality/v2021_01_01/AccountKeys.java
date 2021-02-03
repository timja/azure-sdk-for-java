/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mixedreality.v2021_01_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.mixedreality.v2021_01_01.implementation.MixedRealityManager;
import com.microsoft.azure.management.mixedreality.v2021_01_01.implementation.AccountKeysInner;

/**
 * Type representing AccountKeys.
 */
public interface AccountKeys extends HasInner<AccountKeysInner>, HasManager<MixedRealityManager> {
    /**
     * @return the primaryKey value.
     */
    String primaryKey();

    /**
     * @return the secondaryKey value.
     */
    String secondaryKey();

}