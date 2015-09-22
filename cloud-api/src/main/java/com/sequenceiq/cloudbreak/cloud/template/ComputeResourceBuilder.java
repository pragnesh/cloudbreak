package com.sequenceiq.cloudbreak.cloud.template;

import java.util.List;

import com.sequenceiq.cloudbreak.cloud.CloudPlatformAware;
import com.sequenceiq.cloudbreak.cloud.event.context.AuthenticatedContext;
import com.sequenceiq.cloudbreak.cloud.event.context.ResourceBuilderContext;
import com.sequenceiq.cloudbreak.cloud.model.CloudInstance;
import com.sequenceiq.cloudbreak.cloud.model.CloudResource;
import com.sequenceiq.cloudbreak.cloud.model.CloudVmInstanceStatus;
import com.sequenceiq.cloudbreak.cloud.model.Group;
import com.sequenceiq.cloudbreak.cloud.model.Image;
import com.sequenceiq.cloudbreak.domain.ResourceType;

public interface ComputeResourceBuilder<C extends ResourceBuilderContext> extends CloudPlatformAware, OrderedBuilder, ResourceChecker<C> {

    List<CloudResource> create(C context, long privateId, AuthenticatedContext auth, Group group, Image image);

    List<CloudResource> build(C context, long privateId, AuthenticatedContext auth, Group group, Image image, List<CloudResource> buildableResource)
            throws Exception;

    List<CloudVmInstanceStatus> checkInstances(C context, AuthenticatedContext auth, List<CloudInstance> instances);

    CloudResource delete(C context, AuthenticatedContext auth, CloudResource resource) throws Exception;

    CloudResource rollback(C context, CloudResource resource) throws Exception;

    CloudVmInstanceStatus start(C context, AuthenticatedContext auth, CloudInstance instance);

    CloudVmInstanceStatus stop(C context, AuthenticatedContext auth, CloudInstance instance);

    ResourceType resourceType();

}