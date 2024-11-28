package stage2_ThiThaoLe;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class connects to the database and
 * handle all requests to insert, update, delete, and list staffs
 * @author ThiThaoLe
 */
public class DBConnector {
    Connection connection;

    /**
     * Default constructor
     */
    public DBConnector() {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //create a connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost/abchotel_db",
                    "root", "");
        } catch (Exception e) {
            e.printStackTrace(); //print errors message for debugging purpose

        }
    }

    /**
     * This method inserts a new staff into the database
     * @param staff specifies information of the new staff to be inserted
     */
    public void insertStaff(Staff staff) {
        try {
            String query = "INSERT INTO staff (staffID, staffName, staffPosition) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, staff.getStaffID());
            preparedStatement.setString(2, staff.getStaffName());
            preparedStatement.setString(3, staff.getStaffPosition());
            preparedStatement.executeUpdate();
            System.out.println("Record Added");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method updates the information of an existing staff
     * @param staff specifies a temporary staff object containing information to be updated
     */
    public void updateStaff(Staff staff) {
        //
        try {
            String query = "UPDATE staff SET staffName= ?, staffPosition= ? WHERE staffID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, staff.getStaffName());
            preparedStatement.setString(2, staff.getStaffPosition());
            preparedStatement.setInt(3, staff.getStaffID());

            preparedStatement.executeUpdate();
            System.out.println("Staff Updated");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method deletes a staff from the database
     * @param staffID specifies the ID of the staff to be deleted
     */
    public void deleteStaff(int staffID) {
        try {
            String query = "DELETE FROM staff WHERE staffID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, staffID);
            //preparedStatement.setString(2, staffName());
            //preparedStatement.setString(3, staffPosition());
            preparedStatement.executeUpdate();
            System.out.println("Staff Deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method gets all staffs from the database
     * @return an ArrayList object containing all staffs
     */
    public ArrayList<String> listStaff() {
        ArrayList<String> results = new ArrayList<>();
        try {
            // Create a query to get all rows from the staff table
            String query = "SELECT * FROM staff";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Execute the query and store all rows in resultSet
            ResultSet resultSet = preparedStatement.executeQuery();

            // Loop over the result and print out all staffs
            while (resultSet.next()) {
                int id = resultSet.getInt("staffID");
                String name = resultSet.getString("staffName");
                String position = resultSet.getString("staffPosition");
                System.out.println("staffId: " + id + ", staffName: " + name + ", staffPosition: " + position);
                results.add("staffId: " + id + ", staffName: " + name + ", staffPosition: " + position);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results;
    }

    /**
     * insert a new room
     * @param room a new room to be inserted
     */
    public void insertRoom(Room room) {
        try {
            String query = "INSERT INTO room (roomNo, roomType, roomStatus, cleaningStatus) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, room.getRoomNo());
            preparedStatement.setString(2, room.getRoomType());
            preparedStatement.setString(3, room.getRoomStatus());
            preparedStatement.setString(4, room.getCleaningStatus());
            preparedStatement.executeUpdate();
            System.out.println("Record Added");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Update information for a given room
     * @param room a Room object containing the updated information
     */
    public void updateRoom(Room room) {
        //
        try {
            String query = "UPDATE room SET roomType= ?, roomStatus= ?, cleaningStatus= ? WHERE roomNo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, room.getRoomType());
            preparedStatement.setString(2, room.getRoomStatus());
            preparedStatement.setString(3, room.getCleaningStatus());
            preparedStatement.setInt(4, room.getRoomNo());

            preparedStatement.executeUpdate();
            System.out.println("Room Updated");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * List all rooms of the hotel
     * @return an ArrayList containing all Room information
     */
    public ArrayList<String> listRoom() {
        ArrayList<String> result = new ArrayList<>();
        try {
            // Create a query to get all rows from the room table
            String query = "SELECT * FROM room";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Execute the query and store all rows in resultSet
            ResultSet resultSet = preparedStatement.executeQuery();

            // Loop over the result and print out all rooms
            while (resultSet.next()) {
                int roomId = resultSet.getInt("roomNo");
                String roomType = resultSet.getString("roomType");
                String roomStatus = resultSet.getString("roomStatus");
                String cleaningStatus = resultSet.getString("cleaningStatus");
                System.out.println("roomNo: " + roomId + ", roomType: " + roomType + ", roomStatus: " + roomStatus + "\n" + ", cleaningStatus: " + cleaningStatus);
                result.add("roomNo: " + roomId + ", roomType: " + roomType + ", roomStatus: " + roomStatus + "\n" + ". cleaningStatus: " + cleaningStatus);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}



