package com.example.designpattern.structure.proxy.start;

import com.example.designpattern.create.propertycount.version1.MetricsCollector;
import com.example.designpattern.create.propertycount.version1.RequestInfo;
import com.example.designpattern.structure.proxy.old.UserVo;

/**
 * Created by zyy on 20/2/24.
 */
public class UserControllerProxy implements IUserController {

        private MetricsCollector metricsCollector;
//        private UserController userController;

        public UserControllerProxy(UserController userController) {
            this.userController = userController;
            this.metricsCollector = new MetricsCollector();
        }

        @Override
        public UserVo login(String telephone, String password) {
            long startTimestamp = System.currentTimeMillis();

            // 委托
            UserVo userVo = userController.login(telephone, password);

            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
            metricsCollector.recordRequest(requestInfo);

            return userVo;
        }

        @Override
        public UserVo register(String telephone, String password) {
            long startTimestamp = System.currentTimeMillis();

            UserVo userVo = userController.register(telephone, password);

            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
            metricsCollector.recordRequest(requestInfo);

            return userVo;
        }

    //UserControllerProxy使用举例
//因为原始类和代理类实现相同的接口，是基于接口而非实现编程
//将UserController类对象替换为UserControllerProxy类对象，不需要改动太多代码
    IUserController userController = new UserControllerProxy(new UserController());
}
