package devices;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;

public class Room {
	private String name;
	private int id;
	private int section;
	private ArrayList<Device> devices = new ArrayList<Device>();

	public Room(String name, int id) {
		this.name = name;
		this.id = id;
		this.section = 1;
	}

	Room() {

	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setSection(int sect) {
		section = sect;
	}
	public int getSection() {
		return section;
	}

	public void addDeviceToRoom(Device device) {
		devices.add(device);
	}

	public void removeDeviceFromRoom(Device device) {
		devices.remove(device);
	}

	public ArrayList<Device> getDevices() {
		return devices;
	}
	
	public Pane getPane(double length){
		Pane roomPane = new Pane();
		roomPane.setId("roomPane");
		roomPane.setPrefWidth(length);
		
		Label roomName = new Label("Room : " + getName());
		roomName.setLayoutX(0);
		roomName.setLayoutY(15);
		roomName.setId("roomName");
		
		roomPane.getChildren().addAll(roomName);
		return roomPane;
	}
	
	public Pane getDetailsPane(){
		final Pane pane = new Pane();
		pane.setPrefSize(740,70);
		pane.setId("roomDetails");
		
		final Label nameLabel = new Label(getName());
		nameLabel.setLayoutY(25);
		final Label deviceNum = new Label(devices.size() + " Devices");
		deviceNum.setLayoutX(250);
		deviceNum.setLayoutY(25);
		final Button button = new Button("Edit");
		button.setLayoutX(520);
		button.setLayoutY(20);
		button.setMaxWidth(100);
		button.setMinWidth(100);
		button.setId("passSubmit");
		button.setTooltip(new Tooltip("Click to edit the name"));
		final Button deleteB = new Button("Delete");
		deleteB.setLayoutX(640);
		deleteB.setLayoutY(20);
		deleteB.setMaxWidth(100);
		deleteB.setMinWidth(100);
		deleteB.setId("passSubmitRed");
		deleteB.setTooltip(new Tooltip("Click to delete Room"));
		final TextField editName = new TextField(getName());
		editName.setId("passFields");
		editName.setVisible(false);
		editName.setLayoutY(20);
		final Label warning = new Label("Name cannot be empty");
		warning.setVisible(false);
		warning.setLayoutY(44);
		warning.setStyle("-fx-text-fill:red");
		
		button.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				if(nameLabel.isVisible()){
					nameLabel.setVisible(false);
					editName.setVisible(true);
					button.setText("Save");
				}else{
					nameLabel.setVisible(true);
					editName.setVisible(false);
					button.setText("Edit");
				}
			}});
		
		editName.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				if(editName.getText().matches("[a-zA-z]")){
					name = editName.getText();
					nameLabel.setText(name);
					nameLabel.setVisible(true);
					editName.setVisible(false);
					warning.setVisible(false);
				}else{
					warning.setVisible(true);
				}
				
			}});
		pane.getChildren().addAll(nameLabel,deviceNum,button,deleteB,editName,warning);
		return pane;
	}
}