package com.example.designpattern.structure.proxy.start;

import com.example.designpattern.structure.proxy.old.UserVo;

/**
 * Created by zyy on 20/2/24.
 */
public interface IUserController {

    UserVo login(String telephone, String password);

    UserVo register(String telephone, String password);
}
