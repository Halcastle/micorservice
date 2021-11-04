package com.imooc.user.thrift;

import com.imooc.thrift.user.UserService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName ServiceProvider
 * @Description TODO
 * @Author pwang6
 * @Date 2021/11/2 10:49
 * @Version 1.0
 **/
@Component
public class ServiceProvider {

    @Value("${thrift.user.ip}")
    private String serverIp;

    @Value("${thrift.user.prot}")
    private int serverPort;

    @Value("${thrift.message.ip}")
    private String messageServerIp;

    @Value("${thrift.message.port}")
    private String messageServerPort;

    public UserService.Client getUserService(){
        TSocket socket = new TSocket(serverIp,serverPort,3000);
        TTransport transport = new TFramedTransport(socket);

        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
            return null;
        }
        TProtocol protocol = new TBinaryProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);

        return client;
    }
}
