package com.sequenceiq.cloudbreak.reactor.api.event.cluster;

import com.sequenceiq.cloudbreak.reactor.api.event.resource.AbstractClusterScaleRequest;

public class UpscaleClusterRequest extends AbstractClusterScaleRequest {

    public UpscaleClusterRequest(Long stackId, String hostGroupName) {
        super(stackId, hostGroupName);
    }
}
