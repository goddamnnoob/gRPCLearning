package org.protobuf.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.protobuf.EmployeeRequest;
import org.protobuf.EmployeeResponse;
import org.protobuf.EmployeeServiceGrpc;

public class EmployeeClient {
    public static void main (String[] args){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",4666)
                .usePlaintext()
                .build();

        EmployeeServiceGrpc.EmployeeServiceBlockingStub stub = EmployeeServiceGrpc.newBlockingStub(channel);
        EmployeeRequest employeeRequest = EmployeeRequest.newBuilder()
                .setEmployeeId(123)
                .build();
        EmployeeResponse employeeResponse = stub.getEmployee(employeeRequest);
        System.out.println("############# Firstname: "+employeeResponse.getFirstName());
        System.out.println("############# LastName: "+employeeResponse.getLastName());
    }
}
