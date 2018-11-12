package model.back;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDao {

    public static String getRoleName(int id) throws SQLException {
        try{
            Connection conn = DBUtils.getConn();

            String sql = "SELECT roleName FROM role WHERE id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String roleName = rs.getString("roleName");
                conn.close();
                return (roleName);

            }
            conn.close();
            return null;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }
}
