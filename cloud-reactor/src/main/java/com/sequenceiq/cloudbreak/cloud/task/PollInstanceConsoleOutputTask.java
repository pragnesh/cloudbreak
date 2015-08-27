package com.sequenceiq.cloudbreak.cloud.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sequenceiq.cloudbreak.cloud.InstanceConnector;
import com.sequenceiq.cloudbreak.cloud.event.context.AuthenticatedContext;
import com.sequenceiq.cloudbreak.cloud.event.instance.InstanceConsoleOutputResult;
import com.sequenceiq.cloudbreak.cloud.model.CloudInstance;

public class PollInstanceConsoleOutputTask extends PollTask<InstanceConsoleOutputResult> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PollInstanceConsoleOutputTask.class);
    private static final String CB_FINGERPRINT_END = "-----END SSH HOST KEY FINGERPRINTS-----";

    private final CloudInstance instance;
    private final InstanceConnector instanceConnector;

    public PollInstanceConsoleOutputTask(InstanceConnector instanceConnector, AuthenticatedContext authenticatedContext, CloudInstance instance) {
        super(authenticatedContext);
        this.instance = instance;
        this.instanceConnector = instanceConnector;
    }

    @Override
    public InstanceConsoleOutputResult call() throws Exception {
        LOGGER.info("Get console output of instance: {}, for stack: {}.", instance.getInstanceId(), getAuthenticatedContext().getCloudContext().getStackName());
        String consoleOutput = instanceConnector.getConsoleOutput(getAuthenticatedContext(), instance);
        return new InstanceConsoleOutputResult(getAuthenticatedContext().getCloudContext(), instance, consoleOutput);
    }

    @Override
    public boolean completed(InstanceConsoleOutputResult instanceConsoleOutputResult) {
        return instanceConsoleOutputResult.getConsoleOutput().contains(CB_FINGERPRINT_END);
    }
}