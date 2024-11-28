package stage2_ThiThaoLe;

/**
 * Room class
 */
public class Room {
    private int roomNo;
    private String roomStatus;
    private String roomType;
    private String cleaningStatus;

    /**
     * Main constructor of the Room class
     * @param aRoomNo room number
     * @param aRoomStatus room status (vacant or not)
     * @param aRoomType room type
     * @param aCleaningStatus cleaning status
     */
    public Room(int aRoomNo, String aRoomStatus, String aRoomType, String aCleaningStatus) {
        this.roomNo = aRoomNo;
        this.roomStatus = aRoomStatus;
        this.roomType = aRoomType;
        this.cleaningStatus = aCleaningStatus;
    }

    /**
     * getter method for room number
     * @return room number
     */
    public int getRoomNo() {
        return roomNo;
    }

    /**
     * setter method for room number
     * @param aRoomNo room number
     */
    public void setRoomNo(int aRoomNo) {
        this.roomNo = aRoomNo;
    }

    /**
     * getter method for room status
     * @return room status
     */
    public String getRoomStatus() {
        return roomStatus;
    }

    /**
     * setter method for room status
     * @param aRoomStatus room status
     */
    public void setRoomStatus(String aRoomStatus) {
        this.roomStatus = aRoomStatus;
    }

    /**
     * getter method for room type
     * @return room type
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * setter method for room type
     * @param aRoomType room type
     */
    public void setRoomType(String aRoomType) {
        this.roomType = aRoomType;
    }

    /**
     * getter method for cleaning status
     * @return
     */
    public String getCleaningStatus() {
        return cleaningStatus;
    }

    /**
     * setter method for cleaning status
     * @param aCleaningStatus room type
     */
    public void setCleaningStatus(String aCleaningStatus) {
        this.cleaningStatus = aCleaningStatus;
    }

    /**
     * toString method
     * @return a description of a Room object
     */
    @Override
    public String toString() {
        return "roomNo=" + roomNo + ", roomStatus=" + roomStatus + ", roomType=" + roomType + ", cleaningStatus=" + cleaningStatus;
    }
}
