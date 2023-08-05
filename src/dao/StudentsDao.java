package dao;

import db.DBConnection;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentsDao {
    public static boolean doValidate(Student student){

        boolean status = false;

        try {

//            DatabaseOperationsDao databaseOperationsDao = new DatabaseOperationsDao();

            Connection connection = DBConnection.getInstance().getConnection();


            String query = "SELECT * FROM studenttable where studentUserName=? and studentPassword=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,student.getStudentUserName());
            preparedStatement.setString(2,student.getStudentPassword());

            ResultSet resultSet = preparedStatement.executeQuery();

//            ResultSet resultSet = databaseOperationsDao.retrieveData(query);


            

            if (resultSet.next()){

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
