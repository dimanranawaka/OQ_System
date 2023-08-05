package dao;

import model.Admin;

import java.sql.SQLException;

public class AdminsDao {
    public static boolean doValidate(Admin admin){

        boolean status = false;

        try {

            DatabaseOperationsDao databaseOperationsDao = new DatabaseOperationsDao();

            String query = "SELECT * FROM admintable WHERE adminUserName=? and adminPassword=?";

            boolean insertResult = databaseOperationsDao.insertData(query);

            if (insertResult) {
                status = true;
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return status;
    }
}
