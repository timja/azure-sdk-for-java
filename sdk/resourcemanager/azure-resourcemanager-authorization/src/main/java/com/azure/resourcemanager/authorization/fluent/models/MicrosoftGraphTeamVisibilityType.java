// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for MicrosoftGraphTeamVisibilityType. */
public final class MicrosoftGraphTeamVisibilityType extends ExpandableStringEnum<MicrosoftGraphTeamVisibilityType> {
    /** Static value private for MicrosoftGraphTeamVisibilityType. */
    public static final MicrosoftGraphTeamVisibilityType PRIVATE = fromString("private");

    /** Static value public for MicrosoftGraphTeamVisibilityType. */
    public static final MicrosoftGraphTeamVisibilityType PUBLIC = fromString("public");

    /** Static value hiddenMembership for MicrosoftGraphTeamVisibilityType. */
    public static final MicrosoftGraphTeamVisibilityType HIDDEN_MEMBERSHIP = fromString("hiddenMembership");

    /** Static value unknownFutureValue for MicrosoftGraphTeamVisibilityType. */
    public static final MicrosoftGraphTeamVisibilityType UNKNOWN_FUTURE_VALUE = fromString("unknownFutureValue");

    /**
     * Creates or finds a MicrosoftGraphTeamVisibilityType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding MicrosoftGraphTeamVisibilityType.
     */
    @JsonCreator
    public static MicrosoftGraphTeamVisibilityType fromString(String name) {
        return fromString(name, MicrosoftGraphTeamVisibilityType.class);
    }

    /** @return known MicrosoftGraphTeamVisibilityType values. */
    public static Collection<MicrosoftGraphTeamVisibilityType> values() {
        return values(MicrosoftGraphTeamVisibilityType.class);
    }
}