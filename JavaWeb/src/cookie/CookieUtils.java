package cookie;

import javax.servlet.http.Cookie;

public class CookieUtils {
    // 返回指定 name 的 Cookie 值
    public static Cookie readCookieByName(String name, Cookie[] cookies) {
        if (name == null || name.equals("") || cookies.length == 0 || cookies[0] == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }
        return null;
    }
    // 修改指定 cookie 的值
    public static void updateCookie(String newValue, Cookie cookie) {
        cookie.setValue(newValue);
    }
}
