package zhenda_liu.service;

import zhenda_liu.domain.Admin;

//规范和Admin相关的业务接口定义
public interface AdminService {
    //业务目的是添加新管理员
    public boolean regNewAdmin(Admin admin);
}
