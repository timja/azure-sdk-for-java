/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.compute.v2020_12_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.compute.v2020_12_01.VirtualMachineScaleSets;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import rx.Completable;
import com.microsoft.azure.management.compute.v2020_12_01.VirtualMachineScaleSet;
import com.microsoft.azure.management.compute.v2020_12_01.VirtualMachineScaleSetInstanceView;
import com.microsoft.azure.management.compute.v2020_12_01.UpgradeOperationHistoricalStatusInfo;
import com.microsoft.azure.management.compute.v2020_12_01.RecoveryWalkResponse;
import java.util.List;
import com.microsoft.azure.management.compute.v2020_12_01.OrchestrationServiceStateAction;
import com.microsoft.azure.management.compute.v2020_12_01.VirtualMachineScaleSetSku;

class VirtualMachineScaleSetsImpl extends WrapperImpl<VirtualMachineScaleSetsInner> implements VirtualMachineScaleSets {
    private final ComputeManager manager;

    VirtualMachineScaleSetsImpl(ComputeManager manager) {
        super(manager.inner().virtualMachineScaleSets());
        this.manager = manager;
    }

    public ComputeManager manager() {
        return this.manager;
    }

    @Override
    public VirtualMachineScaleSetImpl define(String name) {
        return wrapModel(name);
    }

    private VirtualMachineScaleSetImpl wrapModel(VirtualMachineScaleSetInner inner) {
        return  new VirtualMachineScaleSetImpl(inner, manager());
    }

    private VirtualMachineScaleSetImpl wrapModel(String name) {
        return new VirtualMachineScaleSetImpl(name, this.manager());
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String vmScaleSetName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, vmScaleSetName).toCompletable();
    }

    @Override
    public Observable<VirtualMachineScaleSet> getByResourceGroupAsync(String resourceGroupName, String vmScaleSetName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.getByResourceGroupAsync(resourceGroupName, vmScaleSetName)
        .map(new Func1<VirtualMachineScaleSetInner, VirtualMachineScaleSet>() {
            @Override
            public VirtualMachineScaleSet call(VirtualMachineScaleSetInner inner) {
                return new VirtualMachineScaleSetImpl(inner, manager());
            }
        });
    }

    @Override
    public Completable deallocateAsync(String resourceGroupName, String vmScaleSetName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.deallocateAsync(resourceGroupName, vmScaleSetName).toCompletable();
    }

    @Override
    public Completable deleteInstancesAsync(String resourceGroupName, String vmScaleSetName, List<String> instanceIds) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.deleteInstancesAsync(resourceGroupName, vmScaleSetName, instanceIds).toCompletable();
    }

    @Override
    public Observable<VirtualMachineScaleSetInstanceView> getInstanceViewAsync(String resourceGroupName, String vmScaleSetName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.getInstanceViewAsync(resourceGroupName, vmScaleSetName)
        .map(new Func1<VirtualMachineScaleSetInstanceViewInner, VirtualMachineScaleSetInstanceView>() {
            @Override
            public VirtualMachineScaleSetInstanceView call(VirtualMachineScaleSetInstanceViewInner inner) {
                return new VirtualMachineScaleSetInstanceViewImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<UpgradeOperationHistoricalStatusInfo> getOSUpgradeHistoryAsync(final String resourceGroupName, final String vmScaleSetName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.getOSUpgradeHistoryAsync(resourceGroupName, vmScaleSetName)
        .flatMapIterable(new Func1<Page<UpgradeOperationHistoricalStatusInfoInner>, Iterable<UpgradeOperationHistoricalStatusInfoInner>>() {
            @Override
            public Iterable<UpgradeOperationHistoricalStatusInfoInner> call(Page<UpgradeOperationHistoricalStatusInfoInner> page) {
                return page.items();
            }
        })
        .map(new Func1<UpgradeOperationHistoricalStatusInfoInner, UpgradeOperationHistoricalStatusInfo>() {
            @Override
            public UpgradeOperationHistoricalStatusInfo call(UpgradeOperationHistoricalStatusInfoInner inner) {
                return new UpgradeOperationHistoricalStatusInfoImpl(inner, manager());
            }
        });
    }

    @Override
    public Completable powerOffAsync(String resourceGroupName, String vmScaleSetName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.powerOffAsync(resourceGroupName, vmScaleSetName).toCompletable();
    }

    @Override
    public Completable restartAsync(String resourceGroupName, String vmScaleSetName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.restartAsync(resourceGroupName, vmScaleSetName).toCompletable();
    }

    @Override
    public Completable startAsync(String resourceGroupName, String vmScaleSetName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.startAsync(resourceGroupName, vmScaleSetName).toCompletable();
    }

    @Override
    public Completable redeployAsync(String resourceGroupName, String vmScaleSetName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.redeployAsync(resourceGroupName, vmScaleSetName).toCompletable();
    }

    @Override
    public Completable performMaintenanceAsync(String resourceGroupName, String vmScaleSetName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.performMaintenanceAsync(resourceGroupName, vmScaleSetName).toCompletable();
    }

    @Override
    public Completable updateInstancesAsync(String resourceGroupName, String vmScaleSetName, List<String> instanceIds) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.updateInstancesAsync(resourceGroupName, vmScaleSetName, instanceIds).toCompletable();
    }

    @Override
    public Completable reimageAsync(String resourceGroupName, String vmScaleSetName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.reimageAsync(resourceGroupName, vmScaleSetName).toCompletable();
    }

    @Override
    public Completable reimageAllAsync(String resourceGroupName, String vmScaleSetName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.reimageAllAsync(resourceGroupName, vmScaleSetName).toCompletable();
    }

    @Override
    public Observable<RecoveryWalkResponse> forceRecoveryServiceFabricPlatformUpdateDomainWalkAsync(String resourceGroupName, String vmScaleSetName, int platformUpdateDomain) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.forceRecoveryServiceFabricPlatformUpdateDomainWalkAsync(resourceGroupName, vmScaleSetName, platformUpdateDomain)
        .map(new Func1<RecoveryWalkResponseInner, RecoveryWalkResponse>() {
            @Override
            public RecoveryWalkResponse call(RecoveryWalkResponseInner inner) {
                return new RecoveryWalkResponseImpl(inner, manager());
            }
        });
    }

    @Override
    public Completable convertToSinglePlacementGroupAsync(String resourceGroupName, String vmScaleSetName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.convertToSinglePlacementGroupAsync(resourceGroupName, vmScaleSetName).toCompletable();
    }

    @Override
    public Completable setOrchestrationServiceStateAsync(String resourceGroupName, String vmScaleSetName, OrchestrationServiceStateAction action) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.setOrchestrationServiceStateAsync(resourceGroupName, vmScaleSetName, action).toCompletable();
    }

    @Override
    public Observable<VirtualMachineScaleSet> listByResourceGroupAsync(final String resourceGroupName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName)
        .flatMapIterable(new Func1<Page<VirtualMachineScaleSetInner>, Iterable<VirtualMachineScaleSetInner>>() {
            @Override
            public Iterable<VirtualMachineScaleSetInner> call(Page<VirtualMachineScaleSetInner> page) {
                return page.items();
            }
        })
        .map(new Func1<VirtualMachineScaleSetInner, VirtualMachineScaleSet>() {
            @Override
            public VirtualMachineScaleSet call(VirtualMachineScaleSetInner inner) {
                return new VirtualMachineScaleSetImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<VirtualMachineScaleSet> listAsync() {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.listAsync()
        .flatMapIterable(new Func1<Page<VirtualMachineScaleSetInner>, Iterable<VirtualMachineScaleSetInner>>() {
            @Override
            public Iterable<VirtualMachineScaleSetInner> call(Page<VirtualMachineScaleSetInner> page) {
                return page.items();
            }
        })
        .map(new Func1<VirtualMachineScaleSetInner, VirtualMachineScaleSet>() {
            @Override
            public VirtualMachineScaleSet call(VirtualMachineScaleSetInner inner) {
                return new VirtualMachineScaleSetImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<VirtualMachineScaleSet> listByLocationAsync(final String location) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.listByLocationAsync(location)
        .flatMapIterable(new Func1<Page<VirtualMachineScaleSetInner>, Iterable<VirtualMachineScaleSetInner>>() {
            @Override
            public Iterable<VirtualMachineScaleSetInner> call(Page<VirtualMachineScaleSetInner> page) {
                return page.items();
            }
        })
        .map(new Func1<VirtualMachineScaleSetInner, VirtualMachineScaleSet>() {
            @Override
            public VirtualMachineScaleSet call(VirtualMachineScaleSetInner inner) {
                return wrapModel(inner);
            }
        });
    }

    private VirtualMachineScaleSetSkuImpl wrapVirtualMachineScaleSetSkuModel(VirtualMachineScaleSetSkuInner inner) {
        return  new VirtualMachineScaleSetSkuImpl(inner, manager());
    }

    @Override
    public Observable<VirtualMachineScaleSetSku> listSkusAsync(final String resourceGroupName, final String vmScaleSetName) {
        VirtualMachineScaleSetsInner client = this.inner();
        return client.listSkusAsync(resourceGroupName, vmScaleSetName)
        .flatMapIterable(new Func1<Page<VirtualMachineScaleSetSkuInner>, Iterable<VirtualMachineScaleSetSkuInner>>() {
            @Override
            public Iterable<VirtualMachineScaleSetSkuInner> call(Page<VirtualMachineScaleSetSkuInner> page) {
                return page.items();
            }
        })
        .map(new Func1<VirtualMachineScaleSetSkuInner, VirtualMachineScaleSetSku>() {
            @Override
            public VirtualMachineScaleSetSku call(VirtualMachineScaleSetSkuInner inner) {
                return wrapVirtualMachineScaleSetSkuModel(inner);
            }
        });
    }

}