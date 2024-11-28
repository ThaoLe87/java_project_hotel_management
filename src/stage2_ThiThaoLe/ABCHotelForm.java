package stage2_ThiThaoLe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Main GUI form of the ABCHotel application
 * @author ThiThaoLe
 */
class ABCHotelForm extends JFrame implements ActionListener {
    private JTabbedPane tabs;
    private JPanel panelStaffTab, panelRoomTab;
    private JPanel panelStaff, panelList, panelButton, panelRoom, panelListRoom, panelButton2;
    private JTextField tfId, tfName, tfPosition, tfRoomId, tfRoomType, tfRoomStatus, tfCleaningStatus;
    private JTextArea outputList, outputListRoom;
    private JButton btnAdd, btnUpdate, btnDelete, btnList, btnAddRoom, btnUpdateRoom, btnListRoom;
    private DBConnector dbConnector;

    /**
     * Default constructor
     * Creates layout and insert GUI elements
     */
    public ABCHotelForm() {

        this.setTitle("Hotel Management");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);

        JTabbedPane tabs = new JTabbedPane();
        this.add(tabs);

        JPanel panelStaffTab = new JPanel();
        JPanel panelRoomTab = new JPanel();
        tabs.addTab("Staff", panelStaffTab);
        tabs.addTab("Room", panelRoomTab);

        panelStaff = new JPanel(new GridLayout(3, 2, 0, 10));
        panelStaff.setPreferredSize(new Dimension(400, 150));
        tfId = new JTextField();
        tfId.setPreferredSize(new Dimension(350, 20));
        tfName = new JTextField();
        tfName.setPreferredSize(new Dimension(350, 20));
        tfPosition = new JTextField();
        tfPosition.setPreferredSize(new Dimension(350, 20));
        panelStaffTab.add(panelStaff);

        panelList = new JPanel();
        outputList = new JTextArea();
        outputList.setPreferredSize(new Dimension(300, 200));
        panelList.add(outputList);
        panelStaffTab.add(panelList, BorderLayout.CENTER);

        panelButton = new JPanel(new GridLayout(1, 4, 0, 10));
        btnAdd = new JButton("Add");
        btnAdd.setPreferredSize(new Dimension(80, 40));
        btnUpdate = new JButton("Update");
        btnUpdate.setPreferredSize(new Dimension(80, 40));
        btnDelete = new JButton("Delete");
        btnDelete.setPreferredSize(new Dimension(80, 40));
        btnList = new JButton("List");
        btnList.setPreferredSize(new Dimension(80, 40));
        panelStaffTab.add(panelButton, BorderLayout.SOUTH);


        panelStaff.add(new JLabel("Staff ID:"));
        panelStaff.add(tfId);
        panelStaff.add(new JLabel("Staff Name:"));
        panelStaff.add(tfName);
        panelStaff.add(new JLabel("Position:"));
        panelStaff.add(tfPosition);
        EmptyBorder eb = new EmptyBorder(10, 25, 10, 25);
        panelStaff.setBorder(eb);

        //this.add(panelButton,BorderLayout.SOUTH);
        panelButton.add(btnAdd);
        panelButton.add(btnUpdate);
        panelButton.add(btnDelete);
        panelButton.add(btnList);

        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnList.addActionListener(this);

        //List all the room in TextArea

        panelRoom = new JPanel(new GridLayout(4, 2, 0, 10));
        panelRoom.setPreferredSize(new Dimension(400, 200));
        tfRoomId = new JTextField();
        tfRoomId.setPreferredSize(new Dimension(350, 20));
        tfRoomType = new JTextField();
        tfName.setPreferredSize(new Dimension(350, 20));
        tfRoomStatus = new JTextField();
        tfRoomStatus.setPreferredSize(new Dimension(350, 20));
        tfCleaningStatus = new JTextField();
        tfCleaningStatus.setPreferredSize(new Dimension(350, 20));
        panelRoomTab.add(panelRoom);

        panelListRoom = new JPanel();
        outputListRoom = new JTextArea();
        outputListRoom.setPreferredSize(new Dimension(350, 150));
        panelListRoom.add(outputListRoom);
        panelRoomTab.add(panelListRoom, BorderLayout.CENTER);

        panelButton2 = new JPanel(new GridLayout(1, 3, 0, 10));
        btnAddRoom = new JButton("Add Room");
        btnAddRoom.setPreferredSize(new Dimension(120, 40));
        btnUpdateRoom = new JButton("Update Room");
        btnUpdateRoom.setPreferredSize(new Dimension(120, 40));
        btnListRoom = new JButton("List Room");
        btnListRoom.setPreferredSize(new Dimension(120, 40));
        panelRoomTab.add(panelButton2, BorderLayout.SOUTH);


        panelRoom.add(new JLabel("Room No:"));
        panelRoom.add(tfRoomId);
        panelRoom.add(new JLabel("Room Type:"));
        panelRoom.add(tfRoomType);
        panelRoom.add(new JLabel("Room Status:"));
        panelRoom.add(tfRoomStatus);
        panelRoom.add(new JLabel("Cleaning Status:"));
        panelRoom.add(tfCleaningStatus);
        EmptyBorder emptyBorder = new EmptyBorder(10, 25, 10, 25);
        panelRoom.setBorder(emptyBorder);

        panelButton2.add(btnAddRoom);
        panelButton2.add(btnUpdateRoom);
        panelButton2.add(btnListRoom);

        btnAddRoom.addActionListener(this);
        btnUpdateRoom.addActionListener(this);
        btnListRoom.addActionListener(this);


        dbConnector = new DBConnector();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * perform actions depending on the event, e.g., when a button is clicked
     *
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        // Check where the event comes from and
        // handle them accordingly depending on the source of the event
        if (e.getSource() == btnAdd) {
            // If the event comes from the Add button

            // Prepare the data: create a staff object from the user input
            int staffID = Integer.parseInt(tfId.getText());
            String staffName = tfName.getText();
            String staffPosition = tfPosition.getText();
            Staff staff = new Staff(staffID, staffName, staffPosition);

            // Call the insertStaff method of the dbConnector object to
            // add a new staff into the database
            dbConnector.insertStaff(staff);

        } else if (e.getSource() == btnUpdate) {
            // If the event comes from the update button

            // Update staff information based on user input
            int staffID = Integer.parseInt(tfId.getText());
            String staffName = tfName.getText();
            String staffPosition = tfPosition.getText();
            Staff staff = new Staff(staffID, staffName, staffPosition);

            // Call the updateStaff method of the dbConnector object to
            // update the staff information, keeping the staff ID unchanged
            dbConnector.updateStaff(staff);

        } else if (e.getSource() == btnDelete) {
            // If the event comes from the delete button

            // Delete the staff having the same id with the user input
            int staffID = Integer.parseInt(tfId.getText());
            dbConnector.deleteStaff(staffID);

        } else if (e.getSource() == btnList) {
            // If the event comes from the list button

            // Get all the staffs from the database and then
            // write them to the outputList text area
            outputList.setText("");

            // call the listStaff method of the dbConnector object
            // to get all staffs stored as strings in an ArrayList object
            ArrayList<String> results = dbConnector.listStaff();
            for (String staff : results) {
                outputList.append(staff + "\n");
            }
        }
        else if (e.getSource() == btnAddRoom) {
            int roomNo = Integer.parseInt(tfRoomId.getText());
            String roomType = tfRoomType.getText();
            String roomStatus = tfRoomStatus.getText();
            String cleaningStatus = tfCleaningStatus.getText();
            Room room = new Room(roomNo, roomType, roomStatus, cleaningStatus);
            dbConnector.insertRoom(room);
        }
        else if (e.getSource() == btnUpdateRoom) {
            // If the event comes from the update button

            // Update room information based on user input
            int roomId = Integer.parseInt(tfRoomId.getText());
            String roomType = tfRoomType.getText();
            String roomStatus = tfRoomStatus.getText();
            String cleaningStatus = tfCleaningStatus.getText();
            Room room = new Room (roomId, roomType, roomStatus, cleaningStatus);

            // Call the updateRoom method of the dbConnector object to
            // update the staff information, keeping the staff ID unchanged
            dbConnector.updateRoom(room);

        }
        else if (e.getSource() == btnListRoom) {
            // If the event comes from the list button

            // Get all the rooms from the database and then
            // write them to the outputList text area
            outputListRoom.setText("");

            // call the list rooms method of the dbConnector object
            // to get all rooms stored as strings in an ArrayList object
            ArrayList<String> result = dbConnector.listRoom();
            for (String room : result) {
                outputListRoom.append(room + "\n");
            }
        }
    }
}


