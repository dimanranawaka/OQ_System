package dao;

import db.DBConnection;
import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminsDao {
    public static boolean doValidate(Admin admin){

        boolean status = false;

        try {

//            DatabaseOperationsDao databaseOperationsDao = new DatabaseOperationsDao();

            Connection connection = DBConnection.getInstance().getConnection();

            String query = "SELECT * FROM admintable WHERE adminUserName=? and adminPassword=?";

//            ResultSet resultSet = databaseOperationsDao.retrieveData(query);

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, admin.getAdminUserName());
            preparedStatement.setString(2, admin.getAdminPassword());

            ResultSet resultSet = preparedStatement.executeQuery();

            /*String uN = resultSet.getString(1);
            String uP = resultSet.getString(2);

            String adminPassword = admin.getAdminPassword();
            String adminUserName = admin.getAdminUserName();*/


            if (resultSet.next()) {

                status = true;

            }else {

                status = false;

            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return status;
    }
}
