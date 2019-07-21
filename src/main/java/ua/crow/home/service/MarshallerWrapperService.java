package ua.crow.home.service;

public interface MarshallerWrapperService {
    <T> String marshallXml(T obj);
    <T> T unmarshallXml(String response);

}
