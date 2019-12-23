import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import static java.lang.Thread.sleep;
/*
 * Created by JFormDesigner on Mon Dec 23 13:18:10 CST 2019
 */



/**
 * @author 1
 */
public class servlet extends JFrame {
    Connection con = null;
    String name;
//            执行查询语句

    //jdbc驱动
    String driver="com.mysql.cj.jdbc.Driver";
    //这里我的数据库是cxxt
    String url="jdbc:mysql://localhost:3306/test?&useSSL=false&serverTimezone=UTC";
    String user="root";
    String password="123456";
    private int i = 0;

    public servlet() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("servlet");
        panel1 = new JPanel();
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout());

            //---- label1 ----
            label1.setText(bundle.getString("label1.text"));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(label1, BorderLayout.CENTER);
            label1.setText("0");
            button1.setSize(200,100);

            //---- button1 ----
            button1.setText(bundle.getString("button1.text"));
            panel1.add(button1, BorderLayout.SOUTH);
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                i++;
                System.out.println(i+" ");
                try {
                    Class.forName(driver);
                    con = DriverManager.getConnection(url, user, password);
                    String sql = "select * from course;";//我的表格叫persons
                    Statement statement = con.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    if (!con.isClosed()) {
                        System.out.println("数据库连接成功");
                    }
                    while (resultSet.next()) {
                        int id = Integer.parseInt(resultSet.getString("id"));
                        System.out.println("id"+id);
                        if (id == i){
                            name = resultSet.getString("name");
                            label1.setText(id+" "+name+" ");
                            System.out.println(id+'\t'+name);
                        }

                    }

                    con.close();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                //建立连接
            }
        });
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JButton button1;

    // JFormDesigner - End of variables declaration  //GEN-END:variables


    class button1ActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            i++;
            System.out.println(i+" ");
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, password);
                String sql = "select * from course;";//我的表格叫persons
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                if (!con.isClosed()) {
                    System.out.println("数据库连接成功");
                }
                while (resultSet.next()) {
                    int id = Integer.parseInt(resultSet.getString("id"));
                    name = resultSet.getString("name");
                    label1.setText(name+" ");
                    System.out.println(id+'\t'+name);}
                con.close();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            //建立连接

        }
    }

    public static void main(String[] args)
    {
        servlet frame=new servlet();
        frame.setVisible(true);
    }


}
