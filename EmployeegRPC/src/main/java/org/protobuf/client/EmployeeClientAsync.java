package org.protobuf.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.protobuf.EmployeeRequest;
import org.protobuf.EmployeeServiceGrpc;

public class EmployeeClientAsync {

    public static void main (String[] args){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",4666)
                .usePlaintext()
                .build();
        EmployeeServiceGrpc.EmployeeServiceStub employeeServiceStub = EmployeeServiceGrpc.newStub(channel);
        EmployeeRequest employeeRequest = EmployeeRequest.newBuilder()
                .setEmployeeId(102)
                .build();
        employeeServiceStub.getEmployee(employeeRequest,new EmployeeCallback());
        employeeRequest = EmployeeRequest.newBuilder()
                .setEmployeeId(103)
                .build();
        employeeServiceStub.getEmployee(employeeRequest,new EmployeeCallback());
        System.out.println("Request is sent in the thread id: "+Thread.currentThread().getId());
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
