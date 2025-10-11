import com.zhouxinbin.mysql.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String sql = "select * from users";
        ResultSet resultSet = DBUtils.executeQuery(sql);
        try {
            while (resultSet.next()) {
                // 假设有3列，按列号获取
                System.out.print(resultSet.getString(1) + "\t");
                System.out.print(resultSet.getString(2) + "\t");
                System.out.print(resultSet.getString(3) + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
