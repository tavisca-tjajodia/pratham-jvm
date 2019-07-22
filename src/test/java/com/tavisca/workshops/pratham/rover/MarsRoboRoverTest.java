package com.tavisca.workshops.pratham.rover;
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
    void canGoLeft(){
        this.robot.command("L");
        initialPosition.setDirection("W");
        assertEquals(initialPosition,this.robot.getCurrentPosition());
    }

    @Test
    void canGoRight(){
        this.robot.command("R");
        initialPosition.setDirection("E");
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
        initialPosition.setDirection("S");
        assertEquals(initialPosition,this.robot.getCurrentPosition());
    }





}
