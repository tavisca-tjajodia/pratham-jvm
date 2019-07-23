package com.tavisca.workshops.pratham.rover;


import javafx.geometry.Pos;

public class MarsRoboRover {

	private Position currentPosition;

	public MarsRoboRover(String currentPosition){
		try{
			Position position = new Position();
			String[] positions = currentPosition.split(" ");
			position.setX(Integer.parseInt(positions[0]));
			position.setY(Integer.parseInt(positions[1]));
			switch(positions[2]){
				case "N":
					position.setDirection(Direction.NORTH);
					break;
				case "E":
					position.setDirection(Direction.EAST);
					break;
				case "S":
					position.setDirection(Direction.SOUTH);
					break;
				case "W":
					position.setDirection(Direction.WEST);
					break;
			}
			this.currentPosition = position;
		}
		catch (Exception e){
			throw e;
		}
	}

	public Position getCurrentPosition(){
		return this.currentPosition;
	}

	public void setCurrentPosition(Position position){ this.currentPosition = position; }

	public void setCurrentPosition(String currentPosition){
		try{
			Position position = new Position();
			String[] positions = currentPosition.split(" ");
			position.setX(Integer.parseInt(positions[0]));
			position.setY(Integer.parseInt(positions[1]));
			switch(positions[2]) {
				case "N":
					position.setDirection(Direction.NORTH);
					break;
				case "E":
					position.setDirection(Direction.EAST);
					break;
				case "S":
					position.setDirection(Direction.SOUTH);
					break;
				case "W":
					position.setDirection(Direction.WEST);
					break;
			}
			this.currentPosition = position;
		}
		catch (Exception e){
			throw e;
		}
	}

	public void command(String commands){
		Position currentPosition = new Position(this.currentPosition.getX(),
				this.getCurrentPosition().getY(),this.currentPosition.getDirection());
		for (char command : commands.toCharArray()) {
			rove(command);
		}

		System.out.println("currentPosition..."+currentPosition);
		System.out.println("commands..."+commands);
		System.out.println("newPosition..."+this.getCurrentPosition());
	}

	private void rove(char command) {
		switch(command){
			case 'L':
				turnLeft();
				break;

			case 'R':
				turnRight();
				break;

			case 'M':
				move();
				break;
		}
	}

	private void move() {

		switch(this.getCurrentPosition().getDirection()){
			case NORTH:
				this.getCurrentPosition().setY(this.getCurrentPosition().getY() + 1);
				break;

			case EAST:
				this.getCurrentPosition().setX(this.getCurrentPosition().getX() + 1);
				break;

			case WEST:
				this.getCurrentPosition().setX(this.getCurrentPosition().getX() - 1);
				break;

			case SOUTH:
				this.getCurrentPosition().setY(this.getCurrentPosition().getY() - 1);
				break;
		}
	}

	private void turnLeft() {

		switch(this.getCurrentPosition().getDirection()){
			case NORTH:
				this.getCurrentPosition().setDirection(Direction.WEST);
				break;

			case EAST:
				this.getCurrentPosition().setDirection(Direction.NORTH);
				break;

			case WEST:
				this.getCurrentPosition().setDirection(Direction.SOUTH);
				break;

			case SOUTH:
				this.getCurrentPosition().setDirection(Direction.EAST);
				break;
		}
	}

	private void turnRight() {

		switch(this.getCurrentPosition().getDirection()){
			case NORTH:
				this.getCurrentPosition().setDirection(Direction.EAST);
				break;

			case EAST:
				this.getCurrentPosition().setDirection(Direction.SOUTH);
				break;

			case WEST:
				this.getCurrentPosition().setDirection(Direction.NORTH);
				break;

			case SOUTH:
				this.getCurrentPosition().setDirection(Direction.WEST);
				break;
		}
	}



}
