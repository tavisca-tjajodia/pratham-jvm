package com.tavisca.workshops.pratham.rover;
import javafx.geometry.Pos;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MarsRoboRoverTest {
    private MarsRoboRover robot;
    private Position initialPosition;

    @BeforeEach
    void initialize(){
        robot = new MarsRoboRover("3 3 N");
        initialPosition = this.robot.getCurrentPosition();
    }

    @Test
    void hasInitialPosition(){
        assertTrue(this.robot.getCurrentPosition() instanceof Position);
    }

    @Test
    void throwsExceptionWhenFormatIsNotAcceptable(){
        assertThrows(Exception.class,()->{
            new MarsRoboRover("3 N");
        });
    }

    @Test
    void canResetCurrentPositionWithStringParameter(){
        robot.setCurrentPosition("5 5 N");
        Position expectedPosition = new Position(5,5,Direction.NORTH);
        assertEquals(expectedPosition,this.robot.getCurrentPosition());
    }

    @Test
    void canResetCurrentPositionWithPositionParameter(){
        Position expectedPosition = new Position(5,5,Direction.NORTH);
        robot.setCurrentPosition(expectedPosition);
        assertEquals(expectedPosition,this.robot.getCurrentPosition());
    }


    @Test
    void canGoLeft(){
        this.robot.command("L");
        initialPosition.setDirection(Direction.WEST);
        assertEquals(initialPosition,this.robot.getCurrentPosition());
    }

    @Test
    void canGoRight(){
        this.robot.command("R");
        initialPosition.setDirection(Direction.EAST);
        assertEquals(initialPosition,this.robot.getCurrentPosition());
    }

    @Test
    void canGoLeftAndRight(){
        this.robot.command("LR");
        assertEquals(initialPosition,this.robot.getCurrentPosition());
    }

    @Test
    void canMove(){
        this.robot.command("M");
        initialPosition.setY(initialPosition.getX() + 1);
        assertEquals(initialPosition,this.robot.getCurrentPosition());
    }

    @Test
    void canGoLeftOrRightOrMove(){
        this.robot.command("MLRMMLRLWLM");
        initialPosition.setX(3);
        initialPosition.setY(5);
        initialPosition.setDirection(Direction.SOUTH);
        assertEquals(initialPosition,this.robot.getCurrentPosition());
    }





}
