package com.rakovets.course.java.core.practice.concurrency.thread_synchronization.skynet;

import com.rakovets.course.java.core.util.AnsiColorCode;
import com.rakovets.course.java.core.util.StandardOutputUtil;

public class FractionThread extends Thread {
    private final FactoryThread factoryThread;
    public Detail detail;
    protected int NUMBER_OF_CONSUMED_DETAILS = 5;
    private final FractionDetailStorage fractionDetailStorage = new FractionDetailStorage();
    public FractionRobot fractionRobot = new FractionRobot();
    public String fraction;

    public FractionThread(FactoryThread factoryThread) {
        this.factoryThread = factoryThread;
    }

    public void run() {
        for (int i = 0; i < NUMBER_OF_CONSUMED_DETAILS; i++) {
            while ((detail = factoryThread.consume()) != null) {
                switch (detail) {
                    case HEAD:
                        fractionDetailStorage.changeDetailQuantity(Detail.HEAD,
                            fractionDetailStorage.getDetailQuantity(Detail.HEAD) + 1);
                        break;
                    case TORSO:
                        fractionDetailStorage.changeDetailQuantity(Detail.TORSO,
                            fractionDetailStorage.getDetailQuantity(Detail.TORSO) + 1);
                        break;
                    case HAND:
                        fractionDetailStorage.changeDetailQuantity(Detail.HAND,
                            fractionDetailStorage.getDetailQuantity(Detail.HAND) + 1);
                        break;
                    case FEET:
                        fractionDetailStorage.changeDetailQuantity(Detail.FEET,
                            fractionDetailStorage.getDetailQuantity(Detail.FEET) + 1);
                        break;
                }
            }
        }

        StandardOutputUtil.println("Fraction " + fraction + " consumed: " +
                fractionDetailStorage.getDetailQuantity(Detail.HEAD) + " heads, " +
                fractionDetailStorage.getDetailQuantity(Detail.TORSO) + " torsos, " +
                fractionDetailStorage.getDetailQuantity(Detail.HAND) + " hands, " +
                fractionDetailStorage.getDetailQuantity(Detail.FEET) + " feet", AnsiColorCode.FG_BLUE_BOLD);

        while (fractionDetailStorage.getDetailQuantity(Detail.HEAD) >= 1 &&
                fractionDetailStorage.getDetailQuantity(Detail.TORSO) >= 1 &&
                fractionDetailStorage.getDetailQuantity(Detail.HAND) >= 2 &&
                fractionDetailStorage.getDetailQuantity(Detail.FEET) >= 2) {
            fractionRobot.robot.add(1);
            fractionDetailStorage.changeDetailQuantity(Detail.HEAD,
                    fractionDetailStorage.getDetailQuantity(Detail.HEAD) - 1);
            fractionDetailStorage.changeDetailQuantity(Detail.TORSO,
                    fractionDetailStorage.getDetailQuantity(Detail.TORSO) - 1);
            fractionDetailStorage.changeDetailQuantity(Detail.HAND,
                    fractionDetailStorage.getDetailQuantity(Detail.HAND) - 2);
            fractionDetailStorage.changeDetailQuantity(Detail.FEET,
                    fractionDetailStorage.getDetailQuantity(Detail.FEET) - 2);

            StandardOutputUtil.println("Fraction " + fraction + " created " +
                    +fractionRobot.robot.size() + " robots", AnsiColorCode.FG_RED_BRIGHT);
        }
    }
}
