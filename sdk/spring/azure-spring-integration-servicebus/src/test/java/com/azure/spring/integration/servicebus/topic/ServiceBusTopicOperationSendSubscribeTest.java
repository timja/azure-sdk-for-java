// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.integration.servicebus.topic;

import com.azure.messaging.servicebus.ServiceBusReceivedMessageContext;
import com.azure.spring.integration.servicebus.factory.ServiceBusTopicClientFactory;
import com.azure.spring.integration.servicebus.support.ServiceBusTopicTestOperation;
import com.azure.spring.integration.test.support.SendSubscribeWithGroupOperationTest;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.messaging.Message;

import static com.azure.spring.integration.servicebus.converter.ServiceBusMessageHeaders.RECEIVED_MESSAGE_CONTEXT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ServiceBusTopicOperationSendSubscribeTest
    extends SendSubscribeWithGroupOperationTest<ServiceBusTopicOperation> {

    @Mock
    ServiceBusTopicClientFactory clientFactory;

    @Before
    @Override
    public void setUp() {
        this.sendSubscribeOperation = new ServiceBusTopicTestOperation(clientFactory);
    }

    @Override
    protected void verifyCheckpointSuccessCalled(int times) {
        verifyCompleteCalledTimes(times);
    }

    @Override
    protected void verifyCheckpointBatchSuccessCalled(int times) {
        // Nothing to verify since batch checkpoint unsupported
    }

    @Override
    protected void verifyCheckpointFailureCalled(int times) {
        verifyAbandonCalledTimes(times);
    }

    @Override
    protected void manualCheckpointHandler(Message<?> message) {
        assertTrue(message.getHeaders().containsKey(RECEIVED_MESSAGE_CONTEXT));
        final ServiceBusReceivedMessageContext receivedMessageContext = message.getHeaders()
                                                                               .get(RECEIVED_MESSAGE_CONTEXT,
                                                                                    ServiceBusReceivedMessageContext.class);
        assertNotNull(receivedMessageContext);

        receivedMessageContext.complete();
        verifyCompleteCalledTimes(1);

        receivedMessageContext.abandon();
        verifyAbandonCalledTimes(1);
    }

    protected void verifyCompleteCalledTimes(int times) {
        waitMillis(25);
        final int actualTimes = ((ServiceBusTopicTestOperation) sendSubscribeOperation).getCompleteCalledTimes();

        if (actualTimes != times) {
            assertEquals("Complete called times", times, actualTimes);
        }
    }

    protected void verifyAbandonCalledTimes(int times) {
        waitMillis(25);
        final int actualTimes = ((ServiceBusTopicTestOperation) sendSubscribeOperation).getCompleteCalledTimes();

        if (actualTimes != times) {
            assertEquals("Complete called times", times, actualTimes);
        }
    }
}
