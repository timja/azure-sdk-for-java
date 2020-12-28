// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for AccumulatedType. */
public final class AccumulatedType extends ExpandableStringEnum<AccumulatedType> {
    /** Static value true for AccumulatedType. */
    public static final AccumulatedType TRUE = fromString("true");

    /** Static value false for AccumulatedType. */
    public static final AccumulatedType FALSE = fromString("false");

    /**
     * Creates or finds a AccumulatedType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding AccumulatedType.
     */
    @JsonCreator
    public static AccumulatedType fromString(String name) {
        return fromString(name, AccumulatedType.class);
    }

    /** @return known AccumulatedType values. */
    public static Collection<AccumulatedType> values() {
        return values(AccumulatedType.class);
    }
}