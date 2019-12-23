////导入包
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///*
// * 数据库连接
// */
//public class CourseDao{
//    public static void getCourseById(int id){
//        Connection con = null;
//        String name;
////            执行查询语句
//
//        //jdbc驱动
//        String driver="com.mysql.cj.jdbc.Driver";
//        //这里我的数据库是cxxt
//        String url="jdbc:mysql://localhost:3306/test?&useSSL=false&serverTimezone=UTC";
//        String user="root";
//        String password="123456";
//        try {
//            //注册JDBC驱动程序
//            Class.forName(driver);
//            //建立连接
//            con = DriverManager.getConnection(url, user, password);
//            String sql = "select * from course;";//我的表格叫persons
//            Statement statement = con.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//            if (!con.isClosed()) {
//                System.out.println("数据库连接成功");
//            }
//            while (resultSet.next()) {
//                id = Integer.parseInt(resultSet.getString("id"));
//                name = resultSet.getString("name");
//                System.out.println(id+'\t'+name);}
//            con.close();
//        } catch (ClassNotFoundException e) {
//            System.out.println("数据库驱动没有安装");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("数据库连接失败");
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//    CourseDao courseDao = new CourseDao();
//
//    }
//}
