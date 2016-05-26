/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.resources.implementation;

import com.microsoft.azure.management.resources.fluentcore.arm.ResourceUtils;
import com.microsoft.azure.management.resources.fluentcore.model.implementation.IndexableRefreshableWrapperImpl;
import com.microsoft.azure.management.resources.implementation.api.DeploymentOperationsInner;
import com.microsoft.azure.management.resources.DeploymentOperation;
import com.microsoft.azure.management.resources.implementation.api.DeploymentOperationInner;
import com.microsoft.azure.management.resources.implementation.api.TargetResource;
import org.joda.time.DateTime;

/**
 * An instance of this class provides access to a deployment operation in Azure.
 */
final class DeploymentOperationImpl extends
        IndexableRefreshableWrapperImpl<DeploymentOperation, DeploymentOperationInner>
        implements
        DeploymentOperation {
    private String resourceGroupName;
    private String deploymentName;

    private final DeploymentOperationsInner client;

    DeploymentOperationImpl(DeploymentOperationInner innerModel, final DeploymentOperationsInner client) {
        super(innerModel.id(), innerModel);
        this.client = client;
        this.resourceGroupName = ResourceUtils.groupFromResourceId(innerModel.id());
        this.deploymentName = ResourceUtils.extractFromResourceId(innerModel.id(), "deployments");
    }

    @Override
    public String operationId() {
        return inner().operationId();
    }

    @Override
    public String provisioningState() {
        if (this.inner().properties() == null) {
            return null;
        }
        return this.inner().properties().provisioningState();
    }

    @Override
    public DateTime timestamp() {
        if (this.inner().properties() == null) {
            return null;
        }
        return this.inner().properties().timestamp();
    }

    @Override
    public String statusCode() {
        if (this.inner().properties() == null) {
            return null;
        }
        return this.inner().properties().statusCode();
    }

    @Override
    public Object statusMessage() {
        if (this.inner().properties() == null) {
            return null;
        }
        return this.inner().properties().statusMessage();
    }

    @Override
    public TargetResource targetResource() {
        if (this.inner().properties() == null) {
            return null;
        }
        return this.inner().properties().targetResource();
    }

    @Override
    public DeploymentOperation refresh() throws Exception {
        this.setInner(client.get(resourceGroupName, deploymentName, operationId()).getBody());
        return this;
    }
}
