package com.jackson.test.test;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jackson.test.entity.Person;
import com.jackson.test.entity.PersonDiff;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-06
 * 参考博客:
 * https://blog.csdn.net/m0_37076574/article/details/81317403
 */
public class Main {
    public static void main(String[] args) throws JsonProcessingException {

    }

    /**
     * 完整的数据绑定
     *
     * @throws JsonProcessingException
     */
    private void allVariableBind() throws JsonProcessingException {
        Person person=new Person();
        person.setAddress("china");
        person.setAge(18);
        person.setName("peak");

        // 1：完整的数据绑定
        // {"name":null,"age":18,"address":"china"}
        // {"name":null,"age":18,"address":"china","sex":"man"}
        ObjectMapper mapper = new ObjectMapper();
        String personStr=mapper.writeValueAsString(person);
        System.out.println(personStr);

        // json转换为bean
        String converStr1="{\"name\":null,\"age\":18,\"address\":\"china\"}";
        String converStr2="{\"name\":null,\"age\":18}";
        String coverStr3="{\"name\":null,\"age\":18,\"address\":\"china\",\"sex\":\"man\"}";
        Person person1=mapper.readValue(converStr1,Person.class);
        System.out.println("person1:"+person1.toString());
        Person person2=mapper.readValue(converStr2,Person.class);
        System.out.println("person2:"+person2.toString());

        PersonDiff person3=mapper.readValue(converStr1,PersonDiff.class);
        System.out.println("person3:"+person3.toString());

        // 此处抛出异常
        // 得出结论：json转bean时候，json的字段一定小于等于bean中的，否则会抛出异常
        Person person4=mapper.readValue(coverStr3,Person.class);
        System.out.println("person4:"+person4.toString());
    }

    /**
     * 把数据直接映射成一个map对象
     */
    private void bindToMap() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>(16);
        String s = "{\"id\": 1,\"name\": \"小明\",\"array\": [\"1\", \"2\"]," +
                "\"test\":\"I'm test\",\"base\": {\"major\": \"物联网\",\"class\": \"3\"}}";
        ObjectMapper mapper = new ObjectMapper();
        map = mapper.readValue(s, map.getClass());

        String id=map.get("id").toString();
        System.out.println("map中的id:"+id);

    }

    /**
     * 感觉这个方式用途用途不大 其实只要有bean和string之间的互相转换就可以了
     * @throws JsonProcessingException
     */
    private void bindToTree() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //以下是对象转化为Json
        JsonNode root = mapper.createObjectNode();
        ((ObjectNode) root).putArray("array");
        ArrayNode arrayNode = (ArrayNode) root.get("array");
        ((ArrayNode) arrayNode).add("args1");
        ((ArrayNode) arrayNode).add("args2");
        ((ObjectNode) root).put("name", "小红");
        String json = mapper.writeValueAsString(root);
        System.out.println("使用树型模型构建的json:"+json);
        //以下是树模型的解析Json
        String s = "{\"id\": 1,\"name\": \"小明\",\"array\": [\"1\", \"2\"]," +
                "\"test\":\"I'm test\",\"nullNode\":null,\"base\": {\"major\": \"物联网\",\"class\": \"3\"}}";
        //读取rootNode
        JsonNode rootNode = mapper.readTree(s);
        //通过path获取
        System.out.println("通过path获取值：" + rootNode.path("name").asText());
        //通过JsonPointer可以直接按照路径获取
        JsonPointer pointer = JsonPointer.valueOf("/base/major");
        JsonNode node = rootNode.at(pointer);
        System.out.println("通过at获取值:" + node.asText());
        //通过get可以取对应的value
        JsonNode classNode = rootNode.get("base");
        System.out.println("通过get获取值：" + classNode.get("major").asText());

        //获取数组的值
        System.out.print("获取数组的值：");
        JsonNode arrayNode2 = rootNode.get("array");
        for (int i = 0; i < arrayNode2.size(); i++) {
            System.out.print(arrayNode2.get(i).asText()+" ");
        }
        System.out.println();
        //path和get方法看起来很相似，其实他们的细节不同，get方法取不存在的值的时候，会返回null。而path方法会
        //返回一个"missing node"，该"missing node"的isMissingNode方法返回值为true，如果调用该node的asText方法的话，
        // 结果是一个空字符串。
        System.out.println("get方法取不存在的节点，返回null:" + (rootNode.get("notExist") == null));
        JsonNode notExistNode = rootNode.path("notExist");
        System.out.println("notExistNode的value：" + notExistNode.asText());
        System.out.println("isMissingNode方法返回true:" + notExistNode.isMissingNode());

        //当key存在，而value为null的时候，get和path都会返回一个NullNode节点。
        System.out.println(rootNode.get("nullNode") instanceof NullNode);
        System.out.println(rootNode.path("nullNode") instanceof NullNode);
    }

    /**
     * 后面还有个 流式的api 太麻烦没复制粘贴 想看的 可以看博主的
     */
}
