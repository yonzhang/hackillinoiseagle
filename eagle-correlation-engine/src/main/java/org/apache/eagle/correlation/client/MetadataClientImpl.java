package org.apache.eagle.correlation.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.URLConnectionClientHandler;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yonzhang on 2/20/16.
 */
public class MetadataClientImpl implements IMetadataClient {
    protected static final String CONTENT_TYPE = "Content-Type";
    protected static final String DEFAULT_HTTP_HEADER_CONTENT_TYPE = "application/json";
    String basePath;

    Client client;
    public MetadataClientImpl(String basePath){
        this.basePath = basePath;
        ClientConfig cc = new DefaultClientConfig();
        cc.getProperties().put(DefaultClientConfig.PROPERTY_CONNECT_TIMEOUT, 60 * 1000);
        cc.getProperties().put(DefaultClientConfig.PROPERTY_READ_TIMEOUT, 60 * 1000);
        cc.getClasses().add(JacksonJsonProvider.class);
        cc.getProperties().put(URLConnectionClientHandler.PROPERTY_HTTP_URL_CONNECTION_SET_METHOD_WORKAROUND, true);
        this.client = Client.create(cc);
    }

    @Override
    public List findAllTopics() {
        WebResource r = client.resource(basePath + "/api/metrics");
        String xyz = r.header(CONTENT_TYPE, DEFAULT_HTTP_HEADER_CONTENT_TYPE).get(String.class);

        return Arrays.asList(xyz);
    }

    @Override
    public List findAllGroups() {
        return null;
    }
    

    public static void main(String[] args){
        MetadataClientImpl impl = new MetadataClientImpl("http://localhost:38080");
        System.out.println(impl.findAllTopics());
    }
}
