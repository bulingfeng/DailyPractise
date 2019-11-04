package com.es.hightlevel.documentapi;

import com.es.config.HightLevelConfig;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:bulingfeng
 * @Date: 2019-11-04
 * 官方提供了3种文档的插入方式
 * 自从es7.0以后开始去除了type的概念
 * 参考博客
 * https://blog.csdn.net/qq_32123821/article/details/97395023
 */
public class InsertApi {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient highLevelClient = HightLevelConfig.getHighLevvelClient();
        // 方式1
        IndexResponse result = highLevelClient.index(insertByJson(), RequestOptions.DEFAULT);
        System.out.println(result);

        // 关闭client 断开http连接
        highLevelClient.close();
    }


    /**
     * 以json格式的形式来插入到索引中
     */
    public static IndexRequest insertByJson() {
        IndexRequest request = new IndexRequest("twitter"); //索引
        request.id("3"); // 文档id
        // 插入的文档内容
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        request.source(jsonString, XContentType.JSON);
        return request;
    }

    /**
     * 创建索引
     * @param indexName 索引名称
     * @param highLevelClient
     * @throws IOException
     */
    public static void addIndex(String indexName, RestHighLevelClient highLevelClient) throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("twitter");
        highLevelClient.indices().create(request, RequestOptions.DEFAULT);
    }
}
