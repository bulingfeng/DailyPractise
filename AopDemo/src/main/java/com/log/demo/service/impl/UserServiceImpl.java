package com.log.demo.service.impl;

import com.log.demo.anotation.OperationLogDetail;
import com.log.demo.enums.OperationType;
import com.log.demo.enums.OperationUnit;
import com.log.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-06
 */
@Service
public class UserServiceImpl implements UserService {

    @OperationLogDetail(detail = "通过手机号{tel}获取用户名",level = 3,operationUnit = OperationUnit.USER,operationType = OperationType.SELECT)
    @Override
    public String findUserName(String tel) {
        System.out.println("tel:" + tel);
        return "zhangsan";
    }
}
