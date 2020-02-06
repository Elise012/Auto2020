package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "NameNumberLeft" , group = "LeftTurn")
public class NameNumberLeft extends OpMode {
    ImportantStuff robot = new ImportantStuff();

    private enum State {
        STATE_SKYSTONE,
        STATE_COLLECT,
        STATE_TURN,
        STATE_BACK,
        STATE_ACROSS,
        STATE_UP2,
        STATE_SPIN,
        STATE_PAUSE,
        STATE_SKYSTONE2,
        STATE_PAUSE4,
        STATE_OUT,
        STATE_REAR,
        STATE_PAUSE3,
        STATE_PLOP,
        STATE_RETRACT,
        STATE_PAUSE5,
        STATE_SPIN2,
        STATE_HOOK,
        STATE_CLOSER,
        STATE_UP,
        STATE_DRAG,
        STATE_RELEASE,
        STATE_FLEE,
        STATE_HALT
    }

    private State CurrentState;
    ElapsedTime Runtime = new ElapsedTime();

    @Override
    public void init() {
        robot.init(hardwareMap, telemetry);
    }

    @Override
    public void start() {
        super.start();
        Runtime.reset();
        newState(State.STATE_SKYSTONE);
    }

    @Override
    public void loop() {
        telemetry.addData("state", CurrentState);

        switch (CurrentState) {
            case STATE_SKYSTONE:
                if (Runtime.milliseconds() > 250) {
                    robot.robotStuff.RIntake.setPower(1);
                    robot.robotStuff.LIntake.setPower(1);
                    robot.robotStuff.FLeft.setPower(.25);
                    robot.robotStuff.FRight.setPower(.25);
                    robot.robotStuff.BLeft.setPower(.25);
                    robot.robotStuff.BRight.setPower(.25);
                    newState(State.STATE_SKYSTONE2);
                }
                break;

            case STATE_SKYSTONE2:
                if (Runtime.milliseconds() > 2500) {
                    robot.robotStuff.FLeft.setPower(0);
                    robot.robotStuff.FRight.setPower(0);
                    robot.robotStuff.BLeft.setPower(0);
                    robot.robotStuff.BRight.setPower(0);
                    robot.robotStuff.RIntake.setPower(1);
                    robot.robotStuff.LIntake.setPower(1);
                    newState(State.STATE_COLLECT);
                }
                break;

            case STATE_COLLECT:
                if (Runtime.milliseconds() > 1000) {
                    robot.robotStuff.RIntake.setPower(0);
                    robot.robotStuff.LIntake.setPower(0);
                    robot.robotStuff.FLeft.setPower(0);
                    robot.robotStuff.FRight.setPower(0);
                    robot.robotStuff.BLeft.setPower(0);
                    robot.robotStuff.BRight.setPower(0);
                    robot.robotStuff.liftUp.setPower(-1);
                    newState(State.STATE_BACK);
                }
                break;

            case STATE_BACK:
                if (Runtime.milliseconds() > 230) {
                    robot.robotStuff.liftUp.setPower(0);
                    robot.robotStuff.FLeft.setPower(-.5);
                    robot.robotStuff.FRight.setPower(-.5);
                    robot.robotStuff.BLeft.setPower(-.5);
                    robot.robotStuff.BRight.setPower(-.5);
                    newState(State.STATE_SPIN);
                }
                break;

            case STATE_SPIN:
                if (Runtime.milliseconds() > 520) {
                    robot.robotStuff.FLeft.setPower(-1);
                    robot.robotStuff.FRight.setPower(1);
                    robot.robotStuff.BLeft.setPower(-1);
                    robot.robotStuff.BRight.setPower(1);
                    robot.robotStuff.grabServo.setPosition(robot.robotStuff.SERVO_LATCH_DOWN);
                    newState(State.STATE_UP);
                }
                break;

            case STATE_UP:
                if (Runtime.milliseconds() > 85) {
                    robot.robotStuff.FLeft.setPower(0);
                    robot.robotStuff.FRight.setPower(0);
                    robot.robotStuff.BLeft.setPower(0);
                    robot.robotStuff.BRight.setPower(0);
                    robot.robotStuff.liftUp.setPower(.5);
                    newState(State.STATE_PAUSE);
                }
                break;

            case STATE_PAUSE:
                if (Runtime.milliseconds() > 50) {
                    robot.robotStuff.FLeft.setPower(0);
                    robot.robotStuff.FRight.setPower(0);
                    robot.robotStuff.BLeft.setPower(0);
                    robot.robotStuff.BRight.setPower(0);
                    robot.robotStuff.liftUp.setPower(0);
                    newState(State.STATE_ACROSS);
                }
                break;

            case STATE_ACROSS:
                if (Runtime.milliseconds() > 500) {
                    robot.robotStuff.FLeft.setPower(.50);
                    robot.robotStuff.FRight.setPower(.50);
                    robot.robotStuff.BLeft.setPower(.50);
                    robot.robotStuff.BRight.setPower(.50);
                    newState(State.STATE_UP2);
                }
                break;

            case STATE_UP2:
                if (Runtime.milliseconds() > 1350) {
                    robot.robotStuff.FLeft.setPower(0);
                    robot.robotStuff.FRight.setPower(0);
                    robot.robotStuff.BLeft.setPower(0);
                    robot.robotStuff.BRight.setPower(0);
                    robot.robotStuff.liftUp.setPower(1);
                    newState(State.STATE_TURN);
                }
                break;

            case STATE_TURN:
                if (Runtime.milliseconds() > 85) {
                    robot.robotStuff.FLeft.setPower(-1);
                    robot.robotStuff.FRight.setPower(1);
                    robot.robotStuff.BLeft.setPower(-1);
                    robot.robotStuff.BRight.setPower(1);
                    robot.robotStuff.liftUp.setPower(0);
                    newState(State.STATE_PAUSE4);
                }
                break;

            case STATE_PAUSE4:
                if (Runtime.milliseconds() > 90) {
                    robot.robotStuff.FLeft.setPower(0);
                    robot.robotStuff.FRight.setPower(0);
                    robot.robotStuff.BLeft.setPower(0);
                    robot.robotStuff.BRight.setPower(0);
                    newState(State.STATE_REAR);
                }
                break;

            case STATE_REAR:
                if (Runtime.milliseconds() > 1000) {
                    robot.robotStuff.FLeft.setPower(-.5);
                    robot.robotStuff.FRight.setPower(-.5);
                    robot.robotStuff.BLeft.setPower(-.5);
                    robot.robotStuff.BRight.setPower(-.5);
                    newState(State.STATE_OUT);
                }
                break;

            case STATE_OUT:
                if (Runtime.milliseconds() > 300) {
                    robot.robotStuff.liftOut.setPower(-1);
                    robot.robotStuff.liftUp.setPower(0);
                    robot.robotStuff.FLeft.setPower(0);
                    robot.robotStuff.FRight.setPower(0);
                    robot.robotStuff.BLeft.setPower(0);
                    robot.robotStuff.BRight.setPower(0);
                    newState(State.STATE_PLOP);
                }
                break;

            case STATE_PLOP:
                if (Runtime.milliseconds() > 2300) {
                    robot.robotStuff.liftOut.setPower(0);
                    robot.robotStuff.grabServo.setPosition(robot.robotStuff.SERVO_LATCH_UP);
                    newState(State.STATE_RETRACT);
                }
                break;

            case STATE_RETRACT:
                if (Runtime.milliseconds() > 50) {
                    robot.robotStuff.liftOut.setPower(1);
                    robot.robotStuff.leftHook.setPosition(.3);
                    robot.robotStuff.rightHook.setPosition(.95);
                    newState(State.STATE_SPIN2);
                }
                break;

            case STATE_SPIN2:
                if (Runtime.milliseconds() > 2300) {
                    robot.robotStuff.liftOut.setPower(0);
                    robot.robotStuff.FLeft.setPower(-1);
                    robot.robotStuff.FRight.setPower(1);
                    robot.robotStuff.BLeft.setPower(-1);
                    robot.robotStuff.BRight.setPower(1);
                    newState(State.STATE_PAUSE3);
                }
                break;

            case STATE_PAUSE3:
                if (Runtime.milliseconds() > 215) {
                    robot.robotStuff.FLeft.setPower(0);
                    robot.robotStuff.FRight.setPower(0);
                    robot.robotStuff.BLeft.setPower(0);
                    robot.robotStuff.BRight.setPower(0);
                    newState(State.STATE_CLOSER);
                }
                break;

            case STATE_CLOSER:
                if (Runtime.milliseconds() > 1000) {
                    robot.robotStuff.FLeft.setPower(.5);
                    robot.robotStuff.FRight.setPower(.5);
                    robot.robotStuff.BLeft.setPower(.5);
                    robot.robotStuff.BRight.setPower(.5);
                    newState(State.STATE_HOOK);
                }
                break;

            case STATE_HOOK:
                if (Runtime.milliseconds() > 300) {
                    robot.robotStuff.FLeft.setPower(0);
                    robot.robotStuff.FRight.setPower(0);
                    robot.robotStuff.BLeft.setPower(0);
                    robot.robotStuff.BRight.setPower(0);
                    robot.robotStuff.leftHook.setPosition(.9);
                    robot.robotStuff.rightHook.setPosition(.3);
                    newState(State.STATE_DRAG);
                }
                break;

            case STATE_DRAG:
                if (Runtime.milliseconds() > 1000) {
                    robot.robotStuff.FLeft.setPower(-.5);
                    robot.robotStuff.FRight.setPower(-.5);
                    robot.robotStuff.BLeft.setPower(-.5);
                    robot.robotStuff.BRight.setPower(-.5);
                    newState(State.STATE_PAUSE5);
                }
                break;

            case STATE_PAUSE5:
                if (Runtime.milliseconds() > 750) {
                    robot.robotStuff.FLeft.setPower(0);
                    robot.robotStuff.FRight.setPower(0);
                    robot.robotStuff.BLeft.setPower(0);
                    robot.robotStuff.BRight.setPower(0);
                    newState(State.STATE_RELEASE);
                }
                break;

            case STATE_RELEASE:
                if (Runtime.milliseconds() > 500) {
                    robot.robotStuff.leftHook.setPosition(.3);
                    robot.robotStuff.rightHook.setPosition(.95);
                    newState(State.STATE_FLEE);
                }

            case STATE_FLEE:
                if (Runtime.milliseconds() > 500) {
                    robot.robotStuff.FLeft.setPower(1);
                    robot.robotStuff.FRight.setPower(-1);
                    robot.robotStuff.BLeft.setPower(-1);
                    robot.robotStuff.BRight.setPower(1);
                    newState(State.STATE_HALT);
                }
                break;

            case STATE_HALT:
                if (Runtime.milliseconds() > 800) {
                    robot.stop();
                }
                break;
        }

    }


    @Override
    public void stop() {
        super.stop();
    }

    private void newState(State newState) {
        Runtime.reset();
        CurrentState = newState;
    }
}
