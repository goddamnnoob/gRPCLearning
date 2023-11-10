package org.protobuf.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.protobuf.EmployeeRequest;
import org.protobuf.EmployeeResponse;
import org.protobuf.EmployeeServiceGrpc;

import java.util.ArrayList;

public class EmployeeClient {
    public static void main (String[] args){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",4666)
                .usePlaintext()
                .build();

        EmployeeServiceGrpc.EmployeeServiceBlockingStub stub = EmployeeServiceGrpc.newBlockingStub(channel);
        ArrayList<EmployeeRequest>  employeeRequests = new ArrayList<>();
        for(int i=0;i<2;i++){
            EmployeeRequest employeeRequest = EmployeeRequest.newBuilder()
                    .setEmployeeId(123+i)
                    .build();
            employeeRequests.add(employeeRequest);
        }
        for(int i=0;i<2;i++){
            EmployeeResponse employeeResponse = stub.getEmployee(employeeRequests.get(i));
            System.out.println("############# Firstname: "+employeeResponse.getFirstName());
            System.out.println("############# LastName: "+employeeResponse.getLastName());
        }

    }
}
