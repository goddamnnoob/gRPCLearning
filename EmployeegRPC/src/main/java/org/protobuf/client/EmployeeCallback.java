package org.protobuf.client;

import io.grpc.stub.StreamObserver;
import org.protobuf.EmployeeResponse;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class EmployeeCallback implements StreamObserver<EmployeeResponse> {
    @Override
    public void onNext(EmployeeResponse employeeResponse) {
        System.out.println("Response received in thread ID: "+Thread.currentThread().getId());
        System.out.println("["+Thread.currentThread().getId()+"]"+"Employee FirstName: "+employeeResponse.getFirstName());
        System.out.println("["+Thread.currentThread().getId()+"]"+"Employee LastName: "+employeeResponse.getLastName());
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Exception occurred");
        throwable.printStackTrace();
    }

    @Override
    public void onCompleted() {
        System.out.println("Connection is closed");
    }
}
