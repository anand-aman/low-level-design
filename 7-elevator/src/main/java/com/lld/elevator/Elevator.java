package com.lld.elevator;

import lombok.Getter;

import java.util.Set;

@Getter
public class Elevator {
    Set<Requests> requests;
    int currentFloor;

    void addRequest(int floor, RequestType requestType) {

    }

    void step() {

    }
}
