package com.es.hightlevel.documentapi;

import com.es.config.HightLevelConfig;
import com.es.constants.IndexEnum;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.Map;

/**
 * @Author:bulingfeng
 * @Date: 2019-11-05
 */
public class GetApi {
    public static void main(String[] args) throws IOException {
//        asynchronousExe();


//        sychronousExe();

        getMetadata();
    }

    /**
     * 异步调用方法
     * @return
     * @throws IOException
     */
    public static void asynchronousExe() throws IOException {
        GetRequest getRequest=new GetRequest(
                IndexEnum.HIGHT_INDEX_ENUM.getIndexName(),
                "3"
        );
        RestHighLevelClient highLevelClient = HightLevelConfig.getHighLevvelClient();

        // 监听返回的数据
        ActionListener<GetResponse> listener = new ActionListener<GetResponse>() {
            @Override
            public void onResponse(GetResponse getResponse) {
                System.out.println("调用成功,返回的数据为："+getResponse);
            }

            @Override
            public void onFailure(Exception e) {
                System.out.println("调用异常,异常信息为:"+e);
            }
        };

        highLevelClient.getAsync(getRequest, RequestOptions.DEFAULT,listener);
    }

    /**
     * 同步的调用方法
     * @return
     * @throws IOException
     */
    public static GetResponse sychronousExe() throws IOException {
        GetRequest getRequest=new GetRequest(
                IndexEnum.HIGHT_INDEX_ENUM.getIndexName(),
                "3"
        );
        RestHighLevelClient highLevelClient = HightLevelConfig.getHighLevvelClient();
        GetResponse getResponse=highLevelClient.get(getRequest, RequestOptions.DEFAULT);
        highLevelClient.close();
        return getResponse;
    }

    /**
     * 获取数据数的具体元数据
     * 此api可以判断是否存在某个文档，但是不会使用该api来判断，毕竟这个是返回文档再判断
     * 可以使用exist这个api来判断是否存在
     * @throws IOException
     */
    public static void getMetadata() throws IOException {
        GetRequest getRequest=new GetRequest(
                IndexEnum.HIGHT_INDEX_ENUM.getIndexName(),
                "3"
        );
        RestHighLevelClient highLevelClient = HightLevelConfig.getHighLevvelClient();
        GetResponse getResponse=highLevelClient.get(getRequest, RequestOptions.DEFAULT);
        highLevelClient.close();
        String index = getResponse.getIndex();
        String id = getResponse.getId();
        if (getResponse.isExists()) {
            long version = getResponse.getVersion();
            String sourceAsString = getResponse.getSourceAsString();
            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
            byte[] sourceAsBytes = getResponse.getSourceAsBytes();
            String docConent=new String(sourceAsBytes);
            System.out.println("获取的内容为:"+sourceAsString);
            System.out.println("获取的内容为docConent:"+docConent);

        } else {
            System.out.println("没有获取到数据");
        }
    }
}
