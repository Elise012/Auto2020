package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "RightFoundationWall" , group = "RightTurn")
public class RightFoundationWall extends OpMode {
    ImportantStuff robot = new ImportantStuff();

    private enum State {
        STATE_RIGHT,
        STATE_BACK,
        STATE_PAUSE,
        STATE_LATCH,
        STATE_BACKUP,
        STATE_STRAFELEFT,
        STATE_TURN,
        STATE_PAUSE2,
        STATE_RELEASE,
        STATE_PARK,
        STATE_WALL,
        STATE_HALT
    }

    private State CurrentState;
    ElapsedTime Runtime = new ElapsedTime();

    @Override
    public void init() {robot.init(hardwareMap, telemetry);
        robot.robotStuff.leftHook.setPosition(robot.robotStuff.SERVO_LATCH_DOWN);
        robot.robotStuff.rightHook.setPosition(robot.robotStuff.SERVO_LATCH_UP);
    }

    @Override
    public void start() {
        super.start();
        Runtime.reset();
        newState(State.STATE_RIGHT);
    }

    @Override
    public void loop() {
        telemetry.addData("state", CurrentState);

        switch (CurrentState) {
            case STATE_RIGHT:
                if (Runtime.milliseconds() > 500) {
                    robot.robotStuff.FLeft.setPower(-.3);
                    robot.robotStuff.FRight.setPower(.3);
                    robot.robotStuff.BLeft.setPower(.3);
                    robot.robotStuff.BRight.setPower(-.3);
                    newState(State.STATE_BACK);
                }
                break;
            case STATE_BACK:
                if (Runtime.milliseconds() > 1100) {
                    robot.robotStuff.FLeft.setPower(-.25);
                    robot.robotStuff.FRight.setPower(-.25);
                    robot.robotStuff.BLeft.setPower(-.25);
                    robot.robotStuff.BRight.setPower(-.25);
                    newState(State.STATE_PAUSE);
                }
                break;

            case STATE_PAUSE:
                if (Runtime.milliseconds() > 1200) {
                    robot.robotStuff.FLeft.setPower(0);
                    robot.robotStuff.FRight.setPower(0);
                    robot.robotStuff.BLeft.setPower(0);
                    robot.robotStuff.BRight.setPower(0);
                    newState(State.STATE_LATCH);
                }
                break;

            case STATE_LATCH:
                if (Runtime.milliseconds() > 500) {
                    robot.robotStuff.FLeft.setPower(0);
                    robot.robotStuff.FRight.setPower(0);
                    robot.robotStuff.BLeft.setPower(0);
                    robot.robotStuff.BRight.setPower(0);
                    robot.robotStuff.rightHook.setPosition(robot.robotStuff.SERVO_LATCH_DOWN);
                    robot.robotStuff.leftHook.setPosition(robot.robotStuff.SERVO_LATCH_UP);
                    newState(State.STATE_BACKUP);
                }
                break;

            case STATE_BACKUP:
                if (Runtime.milliseconds() > 1000) {
                    robot.robotStuff.FLeft.setPower(.25);
                    robot.robotStuff.FRight.setPower(.25);
                    robot.robotStuff.BLeft.setPower(.25);
                    robot.robotStuff.BRight.setPower(.25);
                    newState(State.STATE_PAUSE2);
                }
                break;

//            case STATE_STRAFELEFT:
//                if (Runtime.milliseconds() > 2000) {
//                    robot.robotStuff.FLeft.setPower(.75);
//                    robot.robotStuff.FRight.setPower(-.75);
//                    robot.robotStuff.BLeft.setPower(-.75);
//                    robot.robotStuff.BRight.setPower(.75);
//                    newState(State.STATE_TURN);
//                }
//                break;
//
//            case STATE_TURN:
//                if (Runtime.milliseconds() > 1300) {
//                    robot.robotStuff.FLeft.setPower(.5);
//                    robot.robotStuff.FRight.setPower(-.5);
//                    robot.robotStuff.BLeft.setPower(.5);
//                    robot.robotStuff.BRight.setPower(-.5);
//                    newState(State.STATE_PAUSE2);
//                }
//                break;


            case STATE_PAUSE2:
                if (Runtime.milliseconds() > 7750) {
                    robot.robotStuff.FLeft.setPower(0);
                    robot.robotStuff.FRight.setPower(0);
                    robot.robotStuff.BLeft.setPower(0);
                    robot.robotStuff.BRight.setPower(0);
                    newState(State.STATE_RELEASE);
                }
                break;

            case STATE_RELEASE:
                if (Runtime.milliseconds() > 500) {
                    robot.robotStuff.FLeft.setPower(0);
                    robot.robotStuff.FRight.setPower(0);
                    robot.robotStuff.BLeft.setPower(0);
                    robot.robotStuff.BRight.setPower(0);
                    robot.robotStuff.rightHook.setPosition(robot.robotStuff.SERVO_LATCH_UP);
                    robot.robotStuff.leftHook.setPosition(robot.robotStuff.SERVO_LATCH_DOWN);
                    newState(State.STATE_WALL);
                }
                break;

            case STATE_PARK:
                if (Runtime.milliseconds() > 50) {
                    robot.robotStuff.FLeft.setPower(.5);
                    robot.robotStuff.FRight.setPower(.5);
                    robot.robotStuff.BLeft.setPower(.5);
                    robot.robotStuff.BRight.setPower(.5);
                    newState(State.STATE_WALL);
                }
                break;

            case STATE_WALL:
                if (Runtime.milliseconds() > 200) {
                    robot.robotStuff.FLeft.setPower(.5);
                    robot.robotStuff.FRight.setPower(-.5);
                    robot.robotStuff.BLeft.setPower(-.5);
                    robot.robotStuff.BRight.setPower(.5);
                    newState(State.STATE_HALT);
                }
                break;

            case STATE_HALT:
                if (Runtime.milliseconds() > 2000) {
                    robot.robotStuff.stop();
                }
                break;
        }
    }

    private void newState(State newState) {
        Runtime.reset();
        CurrentState = newState;
    }
}