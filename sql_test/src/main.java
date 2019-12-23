import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main{
    static String sql = "select * from information_test";//SQL语句    输入表名information_test
    static ResultSet rs = null;
    public static final String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";//输入数据库名test
    public static final String user = "root";//用户名
    public static final String password = "rootroot";//密码
    public static Connection conn = null;
    public static PreparedStatement ps = null;
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
            ps = conn.prepareStatement(sql);//准备执行语句
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //显示数据
        try {
            rs = ps.executeQuery();//执行语句

            while (rs.next()) {
                int co2 = rs.getInt("CO2");//输入要输出的元素名
                int co=rs.getInt("CO");
                System.out.println("CO2:"+co2+"  CO:"+co);
            }
            //关闭连接
            rs.close();
            conn.close();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
