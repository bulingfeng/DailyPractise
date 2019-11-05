package com.es.constants;

/**
 * @Author:bulingfeng
 * @Date: 2019-11-05
 */
public enum IndexEnum {
    HIGHT_INDEX_ENUM("twitter","高级客户端使用的index"),
    LOW_INDEX_ENUM("lowIndex","低级客户端使用的index");

    private String indexName;
    private String indexDesc;

    IndexEnum(String indexName, String indexDesc) {
        this.indexName = indexName;
        this.indexDesc = indexDesc;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getIndexDesc() {
        return indexDesc;
    }

    public void setIndexDesc(String indexDesc) {
        this.indexDesc = indexDesc;
    }
}
