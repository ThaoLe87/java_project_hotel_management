package stage2_ThiThaoLe;

/**
 * Tester class
 */
public class Tester {

    /**
     * main method of the Tester class
     * @param args parameters to run the Tester
     */
    public static void main(String[] args) {
        DBConnector dbConnector;
        dbConnector = new DBConnector();

        // Test adding a new staff
        Staff staff1 = new Staff(100, "Mary", "Test");
        Staff staff2 = new Staff(101, "John", "Test");
        Staff staff3 = new Staff(102, "Alex", "Test");
        Staff staff4 = new Staff(103, "Tom", "Test");
        dbConnector.insertStaff(staff1);
        dbConnector.insertStaff(staff2);
        dbConnector.insertStaff(staff3);
        dbConnector.insertStaff(staff4);

        // Test adding the same staff again
        dbConnector.insertStaff(staff4);

        // Test update a staff
        staff1.setStaffName("New Mary");
        staff1.setStaffPosition("Supervisor");
        dbConnector.updateStaff(staff1);

        // Test delete a staff
        dbConnector.deleteStaff(101);

        // Test listing all staffs
        dbConnector.listStaff();
    }
}
