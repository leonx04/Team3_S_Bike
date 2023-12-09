package com.raven.swing;

import com.raven.model.Model_NhanVien;

public class Helper {

    public static Model_NhanVien user = null;

    public static void clear() {
        Helper.user = null;
    }

    public static boolean isLogin() {
        return Helper.user != null;
    }

    public static boolean isManager() {
        if (!isLogin()) {
            return false;
        }

        // Kiểm tra xem đã là manager hay chưa
        if ("manager".equals(user.getChucvu())) {
            return true;
        }

        return false;
    }

    public static Model_NhanVien getUser() {
        return user;
    }

    public static void setUser(Model_NhanVien user) {
        Helper.user = user;
    }
}
