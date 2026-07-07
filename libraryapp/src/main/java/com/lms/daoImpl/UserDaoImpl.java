package com.lms.daoImpl;

import java.sql.*;

import com.lms.dao.UserDao;
import com.lms.pojo.User;
import com.lms.util.DbUtil;

public class UserDaoImpl implements UserDao {
    
    @Override
    public User checkLogin(String username, String password){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "SELECT * FROM users WHERE email = ? and password = ?";

            conn = DbUtil.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username); 
            preparedStatement.setString(2, password); 

            rs = preparedStatement.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNo(rs.getString("phone_no"));

                return user;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            try {
                if(rs != null){
                    rs.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
