package com.es.hightlevel.documentapi;

import com.es.config.HightLevelConfig;
import com.es.constants.IndexEnum;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;

import java.io.IOException;

/**
 * @Author:bulingfeng
 * @Date: 2019-11-05
 * 用来判断文档是否存在 相比之前的get方法，这个效率更高，而且只会返回true或者false
 * 参考文档：
 * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/7.3/java-rest-high-document-exists.html
 */
public class ExistsApi {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient highLevelClient = HightLevelConfig.getHighLevvelClient();
        GetRequest getRequest = new GetRequest(
                IndexEnum.HIGHT_INDEX_ENUM.getIndexName(),
                "1");
        // 不获取文档内容
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        // 返回内容的具体字段 默认是返回 _id和_type
        //参考文档
        // https://www.elastic.co/guide/en/elasticsearch/reference/7.0/search-request-stored-fields.html
        getRequest.storedFields("_none_");

        //同步方法
        boolean exists = highLevelClient.exists(getRequest, RequestOptions.DEFAULT);

        // 异步的方法可以参考官方文档或者GetApi

        System.out.println("index为:"+IndexEnum.HIGHT_INDEX_ENUM.getIndexName()+",id为1的文档是否存在"+exists);
    }
}
