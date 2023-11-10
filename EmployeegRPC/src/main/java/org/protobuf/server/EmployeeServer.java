package org.protobuf.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOError;
import java.io.IOException;

public class EmployeeServer {
    public static void main(String[] args) throws IOException,InterruptedException {
        System.out.println("Starting Server");
        Server server = ServerBuilder
                .forPort(4666)
                .addService(new EmployeeServiceImpl())
                .build();
        server.start();
        System.out.println("Server Started");
        server.awaitTermination();
    }
}
