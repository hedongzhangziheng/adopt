package club.service;

import club.pojo.Admins;
import club.pojo.User;

public interface AdminService {
    Admins login(String adminName, String adminPwd);
}
