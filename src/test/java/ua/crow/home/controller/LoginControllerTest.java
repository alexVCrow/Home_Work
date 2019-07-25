package ua.crow.home.controller;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.net.www.http.HttpClient;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class LoginControllerTest {

    @Mock
    AsyncHttpClient asyncHttpClient;

    @InjectMocks
    LoginController loginController;

    @BeforeEach
    void setUp() { }

    @Test
    void sayHello() throws ExecutionException, InterruptedException, IOException, JAXBException {

        Response responseMock = mock(Response.class);
        when(responseMock.getStatusCode()).thenReturn(203);
        when(responseMock.getStatusText()).thenReturn("Coll");
        when(responseMock.getResponseBody()).thenReturn(
                "{\n \"name\":\"Ворона\",\n \"lastUpdated\":\"2016-01-01\"\n}"
        );

        when(asyncHttpClient.prepareGet(anyString())).thenReturn(mock(AsyncHttpClient.BoundRequestBuilder.class));
        when(asyncHttpClient.prepareGet(anyString()).execute()).thenReturn(mock(ListenableFuture.class));
        when(asyncHttpClient.prepareGet(anyString()).execute().get()).thenReturn(responseMock);

        System.out.println(loginController.sayHello());
    }
}