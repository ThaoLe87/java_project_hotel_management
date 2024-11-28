package stage2_ThiThaoLe;

/**
 * This class defines all properties and methods for Staff objects
 * @author ThiThaoLe
 */
public class Staff {
    private int staffID;
    private String staffName;
    private String staffPosition;

    /**
     * The main constructor
     * @param aStaffID staff identifier
     * @param aStaffName staff name
     * @param aStaffPosition staff position
     */
    public Staff(int aStaffID, String aStaffName, String aStaffPosition) {
        this.staffID = aStaffID;
        this.staffName = aStaffName;
        this.staffPosition = aStaffPosition;
    }

    /**
     * Get the staff ID
     * @return
     */
    public int getStaffID() {
        return staffID;
    }

    /**
     * Set a staff ID
     * @param aStaffID staff ID
     */
    public void setStaffID(int aStaffID) {

        this.staffID = aStaffID;
    }

    /**
     * get staff name
     * @return staff name
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * set staff name
     * @param aStaffName staff name
     */
    public void setStaffName(String aStaffName) {
        this.staffName = aStaffName;
    }

    /**
     * get staff position
     * @return staff position
     */
    public String getStaffPosition() {
        return staffPosition;
    }

    /**
     * set staff position
     * @param aStaffPosition staff position
     */
    public void setStaffPosition(String aStaffPosition) {
        this.staffPosition = aStaffPosition;
    }

    /**
     * toString method
     * @return return a string describing a staff
     */
    @Override
    public String toString() {
        return "Staff ID: " + staffID + ", Name: " + staffName + ", Position: " + staffPosition;
    }
}
