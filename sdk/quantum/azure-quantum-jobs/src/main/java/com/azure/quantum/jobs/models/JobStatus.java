// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
//
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.quantum.jobs.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for JobStatus. */
public final class JobStatus extends ExpandableStringEnum<JobStatus> {
    /** Static value Waiting for JobStatus. */
    public static final JobStatus WAITING = fromString("Waiting");

    /** Static value Executing for JobStatus. */
    public static final JobStatus EXECUTING = fromString("Executing");

    /** Static value Succeeded for JobStatus. */
    public static final JobStatus SUCCEEDED = fromString("Succeeded");

    /** Static value Failed for JobStatus. */
    public static final JobStatus FAILED = fromString("Failed");

    /** Static value Cancelled for JobStatus. */
    public static final JobStatus CANCELLED = fromString("Cancelled");

    /**
     * Creates or finds a JobStatus from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding JobStatus.
     */
    @JsonCreator
    public static JobStatus fromString(String name) {
        return fromString(name, JobStatus.class);
    }

    /** @return known JobStatus values. */
    public static Collection<JobStatus> values() {
        return values(JobStatus.class);
    }
}