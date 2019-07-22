package com.tavisca.workshops.pratham.rover;

import javafx.scene.transform.MatrixType;

public class MarsRoboRover {

	private Position currentPosition;

	public MarsRoboRover(String currentPosition){
		try{
			String[] positions = currentPosition.split(" ");
			int x = Integer.parseInt(positions[0]);
			int y = Integer.parseInt(positions[1]);
			String direction = positions[2];

			this.currentPosition = new Position(x,y,direction);
		}
		catch (Exception e){
			throw e;
		}
	}

	public Position getCurrentPosition(){
		return this.currentPosition;
	}

	public void command(String commands){

		for (char command : commands.toCharArray()) {
			rove(command);
		}
	}

	private void rove(char command) {

		if (this.currentPosition.getDirection().equalsIgnoreCase("N")) {
			switch (command){
			case 'L':
				this.currentPosition.setDirection("W");
				break;
			case 'R':
				this.currentPosition.setDirection("E");
				break;
			case 'M':
				this.currentPosition.setY(this.currentPosition.getY()+1);
				break;
			}
		} else if (this.currentPosition.getDirection().equalsIgnoreCase("E")) {
			switch (command) {
			case 'L':
				this.currentPosition.setDirection("N");
				break;
			case 'R':
				this.currentPosition.setDirection("S");
				break;
			case 'M':
				this.currentPosition.setX(this.currentPosition.getX()+1);
				break;
			}
		} else if (this.currentPosition.getDirection().equalsIgnoreCase("S")) {
			switch (command) {
			case 'L':
				this.currentPosition.setDirection("E");
				break;
			case 'R':
				this.currentPosition.setDirection("W");
				break;
			case 'M':
				this.currentPosition.setY(this.currentPosition.getY()-1);
				break;
			}
		} else if (this.currentPosition.getDirection().equalsIgnoreCase("W")) {
			switch (command) {
			case 'L':
				this.currentPosition.setDirection("S");
				break;
			case 'R':
				this.currentPosition.setDirection("N");
				break;
			case 'M':
				this.currentPosition.setX(this.currentPosition.getX()-1);
				break;
			}
		}
	}

}
