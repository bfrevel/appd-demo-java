#!/bin/bash
PID_FILE=services.pid
if [ -f "$PID_FILE" ]; then
    echo "PID file $PID_FILE exists. Can't start services"
else 
    echo "Starting services"
    nohup java \
    -javaagent:${APPDYNAMICS_AGENT_LOCATION} \
    -Dappdynamics.agent.tierName=customer \
    -Dappdynamics.agent.nodeName=customer-1 \
    -Dspring.profiles.active=local \
    -jar services/customer/build/libs/customer-0.0.1-SNAPSHOT.jar \
    > nohup.customer.out 2>&1 &
    echo $! >> $PID_FILE

    nohup java \
    -javaagent:${APPDYNAMICS_AGENT_LOCATION} \
    -Dappdynamics.agent.tierName=product \
    -Dappdynamics.agent.nodeName=product-1 \
    -Dspring.profiles.active=local \
    -jar services/product/build/libs/product-0.0.1-SNAPSHOT.jar \
    > nohup.product.out 2>&1 &
    echo $! >> $PID_FILE

    nohup java \
    -javaagent:${APPDYNAMICS_AGENT_LOCATION} \
    -Dappdynamics.agent.tierName=order \
    -Dappdynamics.agent.nodeName=order-1 \
    -Dspring.profiles.active=local \
    -jar services/order/build/libs/order-0.0.1-SNAPSHOT.jar \
    > nohup.order.out 2>&1 &
    echo $! >> $PID_FILE

    nohup java \
    -Dspring.profiles.active=local \
    -jar services/load/build/libs/load-0.0.1-SNAPSHOT.jar \
    > nohup.load.out 2>&1 &
    echo $! >> $PID_FILE

    sleep 1
    cat $PID_FILE
    echo "Started services"
fi
