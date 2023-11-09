package org.protobuf.server;

import io.grpc.stub.StreamObserver;
import org.protobuf.EmployeeRequest;
import org.protobuf.EmployeeResponse;
import org.protobuf.EmployeeServiceGrpc;

public class EmployeeServiceImpl extends EmployeeServiceGrpc.EmployeeServiceImplBase {

    @Override
    public void getEmployee(EmployeeRequest request, StreamObserver<EmployeeResponse> responseStreamObserver){
        Long employeeId = request.getEmployeeId();
        String firstName = "AAA-"+employeeId;
        String lastName = "BBB-"+employeeId;
        EmployeeResponse employeeResponse = EmployeeResponse
                .newBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmployeeId(employeeId)
                .build();
        responseStreamObserver.onNext(employeeResponse);
        responseStreamObserver.onCompleted();
    }
}
