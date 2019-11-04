package com.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @Author:bulingfeng
 * @Date: 2019-11-04
 */
public class HightLevelConfig {
    public static final String hostIp="127.0.0.1";

    public static RestHighLevelClient getHighLevvelClient(){
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(hostIp, 9200, "http")));
        return client;
    }

}
