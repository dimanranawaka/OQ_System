package dao;

import model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentsDao {
    public static boolean doValidate(Student student){

        boolean status = false;

        try {

            DatabaseOperationsDao databaseOperationsDao = new DatabaseOperationsDao();

            String query = "SELECT * FROM studenttable where studentUserName=? and studentPassword=?";

            ResultSet resultSet = databaseOperationsDao.retrieveData(query);

            if (resultSet == student){

                status=true;

            }else{

                status=false;

            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return  status;

    }
}
