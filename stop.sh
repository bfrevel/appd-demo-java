#!/bin/bash

PID_FILE=services.pid
if [ -f "$PID_FILE" ]; then
    echo "Stopping services"
    cat $PID_FILE
    kill $(cat $PID_FILE)
    rm -f $PID_FILE
    echo "Stopped services"
else 
    echo "PID file $PID_FILE not existing. Can't stop services"
fi