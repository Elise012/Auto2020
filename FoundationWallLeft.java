package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "FoundationWallLeft" , group = "LeftTurn")
public class FoundationWallLeft extends OpMode {
    ImportantStuff robot = new ImportantStuff();

    private enum State {
        STATE_BACK,
        STATE_PAUSE,
        STATE_LATCH,
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
        robot.robotStuff.leftHook.setPosition(.1);
        robot.robotStuff.rightHook.setPosition(.8);
    }

    @Override
    public void start() {
        super.start();
        Runtime.reset();
        newState(State.STATE_BACK);
    }

    @Override
    public void loop() {
        telemetry.addData("state", CurrentState);

        switch (CurrentState) {
            case STATE_BACK:
                if (Runtime.milliseconds() > 500) {
                    robot.robotStuff.FLeft.setPower(-.3);
                    robot.robotStuff.FRight.setPower(-.3);
                    robot.robotStuff.BLeft.setPower(-.3);
                    robot.robotStuff.BRight.setPower(-.3);
                    newState(State.STATE_PAUSE);
                }
                break;

            case STATE_PAUSE:
                if (Runtime.milliseconds() > 1000) {
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
                    robot.robotStuff.rightHook.setPosition(.3);
                    robot.robotStuff.leftHook.setPosition(.67);
                    newState(State.STATE_TURN);
                }
                break;

            case STATE_TURN:
                if (Runtime.milliseconds() > 1000) {
                    robot.robotStuff.FLeft.setPower(-1);
                    robot.robotStuff.FRight.setPower(1);
                    robot.robotStuff.BLeft.setPower(-1);
                    robot.robotStuff.BRight.setPower(1);
                    newState(State.STATE_PAUSE2);
                }
                break;

            case STATE_PAUSE2:
                if (Runtime.milliseconds() > 100) {
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
                    robot.robotStuff.rightHook.setPosition(.8);
                    robot.robotStuff.leftHook.setPosition(.1);
                    newState(State.STATE_HALT);
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
                if (Runtime.milliseconds() > 50) {
                    robot.robotStuff.FLeft.setPower(-.5);
                    robot.robotStuff.FRight.setPower(.5);
                    robot.robotStuff.BLeft.setPower(.5);
                    robot.robotStuff.BRight.setPower(-.5);
                    newState(State.STATE_HALT);
                }
                break;

            case STATE_HALT:
                if (Runtime.milliseconds() > 200) {
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