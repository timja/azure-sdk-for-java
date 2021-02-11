/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute.v2020_12_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.Resource;
import com.microsoft.azure.arm.resources.models.GroupableResourceCore;
import com.microsoft.azure.arm.resources.models.HasResourceGroup;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.compute.v2020_12_01.implementation.ComputeManager;
import org.joda.time.DateTime;
import com.microsoft.azure.management.compute.v2020_12_01.implementation.SnapshotInner;

/**
 * Type representing Snapshot.
 */
public interface Snapshot extends HasInner<SnapshotInner>, Resource, GroupableResourceCore<ComputeManager, SnapshotInner>, HasResourceGroup, Refreshable<Snapshot>, Updatable<Snapshot.Update>, HasManager<ComputeManager> {
    /**
     * @return the creationData value.
     */
    CreationData creationData();

    /**
     * @return the diskAccessId value.
     */
    String diskAccessId();

    /**
     * @return the diskSizeBytes value.
     */
    Long diskSizeBytes();

    /**
     * @return the diskSizeGB value.
     */
    Integer diskSizeGB();

    /**
     * @return the diskState value.
     */
    DiskState diskState();

    /**
     * @return the encryption value.
     */
    Encryption encryption();

    /**
     * @return the encryptionSettingsCollection value.
     */
    EncryptionSettingsCollection encryptionSettingsCollection();

    /**
     * @return the extendedLocation value.
     */
    ExtendedLocation extendedLocation();

    /**
     * @return the hyperVGeneration value.
     */
    HyperVGeneration hyperVGeneration();

    /**
     * @return the incremental value.
     */
    Boolean incremental();

    /**
     * @return the managedBy value.
     */
    String managedBy();

    /**
     * @return the networkAccessPolicy value.
     */
    NetworkAccessPolicy networkAccessPolicy();

    /**
     * @return the osType value.
     */
    OperatingSystemTypes osType();

    /**
     * @return the provisioningState value.
     */
    String provisioningState();

    /**
     * @return the purchasePlan value.
     */
    PurchasePlan purchasePlan();

    /**
     * @return the sku value.
     */
    SnapshotSku sku();

    /**
     * @return the timeCreated value.
     */
    DateTime timeCreated();

    /**
     * @return the uniqueId value.
     */
    String uniqueId();

    /**
     * The entirety of the Snapshot definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithGroup, DefinitionStages.WithCreationData, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of Snapshot definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a Snapshot definition.
         */
        interface Blank extends GroupableResourceCore.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of the Snapshot definition allowing to specify the resource group.
         */
        interface WithGroup extends GroupableResourceCore.DefinitionStages.WithGroup<WithCreationData> {
        }

        /**
         * The stage of the snapshot definition allowing to specify CreationData.
         */
        interface WithCreationData {
           /**
            * Specifies creationData.
            * @param creationData Disk source information. CreationData information cannot be changed after the disk has been created
            * @return the next definition stage
*/
            WithCreate withCreationData(CreationData creationData);
        }

        /**
         * The stage of the snapshot definition allowing to specify DiskAccessId.
         */
        interface WithDiskAccessId {
            /**
             * Specifies diskAccessId.
             * @param diskAccessId ARM id of the DiskAccess resource for using private endpoints on disks
             * @return the next definition stage
             */
            WithCreate withDiskAccessId(String diskAccessId);
        }

        /**
         * The stage of the snapshot definition allowing to specify DiskSizeGB.
         */
        interface WithDiskSizeGB {
            /**
             * Specifies diskSizeGB.
             * @param diskSizeGB If creationData.createOption is Empty, this field is mandatory and it indicates the size of the disk to create. If this field is present for updates or creation with other options, it indicates a resize. Resizes are only allowed if the disk is not attached to a running VM, and can only increase the disk's size
             * @return the next definition stage
             */
            WithCreate withDiskSizeGB(Integer diskSizeGB);
        }

        /**
         * The stage of the snapshot definition allowing to specify DiskState.
         */
        interface WithDiskState {
            /**
             * Specifies diskState.
             * @param diskState The state of the snapshot. Possible values include: 'Unattached', 'Attached', 'Reserved', 'ActiveSAS', 'ReadyToUpload', 'ActiveUpload'
             * @return the next definition stage
             */
            WithCreate withDiskState(DiskState diskState);
        }

        /**
         * The stage of the snapshot definition allowing to specify Encryption.
         */
        interface WithEncryption {
            /**
             * Specifies encryption.
             * @param encryption Encryption property can be used to encrypt data at rest with customer managed keys or platform managed keys
             * @return the next definition stage
             */
            WithCreate withEncryption(Encryption encryption);
        }

        /**
         * The stage of the snapshot definition allowing to specify EncryptionSettingsCollection.
         */
        interface WithEncryptionSettingsCollection {
            /**
             * Specifies encryptionSettingsCollection.
             * @param encryptionSettingsCollection Encryption settings collection used be Azure Disk Encryption, can contain multiple encryption settings per disk or snapshot
             * @return the next definition stage
             */
            WithCreate withEncryptionSettingsCollection(EncryptionSettingsCollection encryptionSettingsCollection);
        }

        /**
         * The stage of the snapshot definition allowing to specify ExtendedLocation.
         */
        interface WithExtendedLocation {
            /**
             * Specifies extendedLocation.
             * @param extendedLocation The extended location where the snapshot will be created. Extended location cannot be changed
             * @return the next definition stage
             */
            WithCreate withExtendedLocation(ExtendedLocation extendedLocation);
        }

        /**
         * The stage of the snapshot definition allowing to specify HyperVGeneration.
         */
        interface WithHyperVGeneration {
            /**
             * Specifies hyperVGeneration.
             * @param hyperVGeneration The hypervisor generation of the Virtual Machine. Applicable to OS disks only. Possible values include: 'V1', 'V2'
             * @return the next definition stage
             */
            WithCreate withHyperVGeneration(HyperVGeneration hyperVGeneration);
        }

        /**
         * The stage of the snapshot definition allowing to specify Incremental.
         */
        interface WithIncremental {
            /**
             * Specifies incremental.
             * @param incremental Whether a snapshot is incremental. Incremental snapshots on the same disk occupy less space than full snapshots and can be diffed
             * @return the next definition stage
             */
            WithCreate withIncremental(Boolean incremental);
        }

        /**
         * The stage of the snapshot definition allowing to specify NetworkAccessPolicy.
         */
        interface WithNetworkAccessPolicy {
            /**
             * Specifies networkAccessPolicy.
             * @param networkAccessPolicy Possible values include: 'AllowAll', 'AllowPrivate', 'DenyAll'
             * @return the next definition stage
             */
            WithCreate withNetworkAccessPolicy(NetworkAccessPolicy networkAccessPolicy);
        }

        /**
         * The stage of the snapshot definition allowing to specify OsType.
         */
        interface WithOsType {
            /**
             * Specifies osType.
             * @param osType The Operating System type. Possible values include: 'Windows', 'Linux'
             * @return the next definition stage
             */
            WithCreate withOsType(OperatingSystemTypes osType);
        }

        /**
         * The stage of the snapshot definition allowing to specify PurchasePlan.
         */
        interface WithPurchasePlan {
            /**
             * Specifies purchasePlan.
             * @param purchasePlan Purchase plan information for the image from which the source disk for the snapshot was originally created
             * @return the next definition stage
             */
            WithCreate withPurchasePlan(PurchasePlan purchasePlan);
        }

        /**
         * The stage of the snapshot definition allowing to specify Sku.
         */
        interface WithSku {
            /**
             * Specifies sku.
             * @param sku the sku parameter value
             * @return the next definition stage
             */
            WithCreate withSku(SnapshotSku sku);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<Snapshot>, Resource.DefinitionWithTags<WithCreate>, DefinitionStages.WithDiskAccessId, DefinitionStages.WithDiskSizeGB, DefinitionStages.WithDiskState, DefinitionStages.WithEncryption, DefinitionStages.WithEncryptionSettingsCollection, DefinitionStages.WithExtendedLocation, DefinitionStages.WithHyperVGeneration, DefinitionStages.WithIncremental, DefinitionStages.WithNetworkAccessPolicy, DefinitionStages.WithOsType, DefinitionStages.WithPurchasePlan, DefinitionStages.WithSku {
        }
    }
    /**
     * The template for a Snapshot update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<Snapshot>, Resource.UpdateWithTags<Update>, UpdateStages.WithDiskAccessId, UpdateStages.WithDiskSizeGB, UpdateStages.WithEncryption, UpdateStages.WithEncryptionSettingsCollection, UpdateStages.WithNetworkAccessPolicy, UpdateStages.WithOsType, UpdateStages.WithSku {
    }

    /**
     * Grouping of Snapshot update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the snapshot update allowing to specify DiskAccessId.
         */
        interface WithDiskAccessId {
            /**
             * Specifies diskAccessId.
             * @param diskAccessId ARM id of the DiskAccess resource for using private endpoints on disks
             * @return the next update stage
             */
            Update withDiskAccessId(String diskAccessId);
        }

        /**
         * The stage of the snapshot update allowing to specify DiskSizeGB.
         */
        interface WithDiskSizeGB {
            /**
             * Specifies diskSizeGB.
             * @param diskSizeGB If creationData.createOption is Empty, this field is mandatory and it indicates the size of the disk to create. If this field is present for updates or creation with other options, it indicates a resize. Resizes are only allowed if the disk is not attached to a running VM, and can only increase the disk's size
             * @return the next update stage
             */
            Update withDiskSizeGB(Integer diskSizeGB);
        }

        /**
         * The stage of the snapshot update allowing to specify Encryption.
         */
        interface WithEncryption {
            /**
             * Specifies encryption.
             * @param encryption Encryption property can be used to encrypt data at rest with customer managed keys or platform managed keys
             * @return the next update stage
             */
            Update withEncryption(Encryption encryption);
        }

        /**
         * The stage of the snapshot update allowing to specify EncryptionSettingsCollection.
         */
        interface WithEncryptionSettingsCollection {
            /**
             * Specifies encryptionSettingsCollection.
             * @param encryptionSettingsCollection Encryption settings collection used be Azure Disk Encryption, can contain multiple encryption settings per disk or snapshot
             * @return the next update stage
             */
            Update withEncryptionSettingsCollection(EncryptionSettingsCollection encryptionSettingsCollection);
        }

        /**
         * The stage of the snapshot update allowing to specify NetworkAccessPolicy.
         */
        interface WithNetworkAccessPolicy {
            /**
             * Specifies networkAccessPolicy.
             * @param networkAccessPolicy Possible values include: 'AllowAll', 'AllowPrivate', 'DenyAll'
             * @return the next update stage
             */
            Update withNetworkAccessPolicy(NetworkAccessPolicy networkAccessPolicy);
        }

        /**
         * The stage of the snapshot update allowing to specify OsType.
         */
        interface WithOsType {
            /**
             * Specifies osType.
             * @param osType the Operating System type. Possible values include: 'Windows', 'Linux'
             * @return the next update stage
             */
            Update withOsType(OperatingSystemTypes osType);
        }

        /**
         * The stage of the snapshot update allowing to specify Sku.
         */
        interface WithSku {
            /**
             * Specifies sku.
             * @param sku the sku parameter value
             * @return the next update stage
             */
            Update withSku(SnapshotSku sku);
        }

    }
}