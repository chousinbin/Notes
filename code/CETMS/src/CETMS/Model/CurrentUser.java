package CETMS.Model;

public class CurrentUser {
    private static String userId;
    private static String userPwd;
    private static String userType;

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        CurrentUser.userId = userId;
    }

    public static String getUserPwd() {
        return userPwd;
    }

    public static void setUserPwd(String userPwd) {
        CurrentUser.userPwd = userPwd;
    }

    public static String getUserType() {
        return userType;
    }

    public static void setUserType(String userType) {
        CurrentUser.userType = userType;
    }
}
