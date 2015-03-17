package model.robot;

import model.virtualmap.OccupancyMap;

import java.io.PipedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.PipedOutputStream;
import java.io.IOException;

import java.util.StringTokenizer;

/**
 * Title    :   The Mobile Robot Explorer Simulation Environment v2.0
 * Copyright:   GNU General Public License as published by the Free Software Foundation
 * Company  :   Hanze University of Applied Sciences
 *
 * @author Dustin Meijer        (2012)
 * @author Alexander Jeurissen  (2012)
 * @author Davide Brugali       (2002)
 * @version 2.0
 */

public class MobileRobotAI implements Runnable {

	private final OccupancyMap map;
	private final MobileRobot robot;

	private boolean running;

	public MobileRobotAI(MobileRobot robot, OccupancyMap map) {
		this.map = map;
		this.robot = robot;

	}

	/**
	 * In this method the gui.controller sends commands to the robot and its devices.
	 * At the moment all the commands are hardcoded.
	 * The exercise is to let the gui.controller make intelligent decisions based on
	 * what has been discovered so far. This information is contained in the OccupancyMap.
	 */
	public void run() {
		String result;
		this.running = true;
        boolean secondRun = false;
		double position[] = new double[3];
		double measures[] = new double[360];
        double dist = 0;
		while (running) {
			try {

                if((map.isWallComplete() && secondRun)) {
                    running = false;
                    System.out.println("Done.");
                    continue;
                }

                secondRun = true;

				PipedInputStream pipeIn = new PipedInputStream();
				BufferedReader input = new BufferedReader(new InputStreamReader(pipeIn));
				PrintWriter output = new PrintWriter(new PipedOutputStream(pipeIn), true);

				robot.setOutput(output);

//      ases where a variable value is never used after its assignment, i.e.:
				//System.out.println("intelligence running");

				robot.sendCommand("R1.GETPOS");
				result = input.readLine();
				parsePosition(result, position);

				robot.sendCommand("L1.SCAN");
				result = input.readLine();
				parseMeasures(result, measures);
				map.drawLaserScan(position, measures);

                for(int i = 21; i < 180; i++) {
                    dist = measures[i];
                    if(dist != 100) {
                        break;
                    }
                }

                if(measures[0] >= 70) {
                    System.out.println("iets");
                    System.out.println(dist);
                    System.out.println(Math.pow(dist,2));
                    System.out.println(Math.pow(35,2));

                    double dfw = ((Math.sqrt(Math.pow(dist,2) - Math.pow(35,2))) + 55);
                    System.out.println("anders " + dfw);
                    //result = input.readLine();
                    robot.sendCommand("P1.MOVEFW" + dfw);
                    result = input.readLine();
                    robot.sendCommand("P1.ROTATERIGHT 90");
                    result = input.readLine();
                    continue;
                }

//                if(measures[90] > 50 && measures[120] > 50 && measures[85] > 50) {
//                    robot.sendCommand("P1.ROTATERIGHT 90");
//                    //System.out.println("right");
//                    result = input.readLine();
//                    robot.sendCommand("P1.MOVEFW 30");
//                    result = input.readLine();
//                    continue;
//                }

                if(measures[0] <= 15) {
                    robot.sendCommand("P1.ROTATELEFT 90");
                    //System.out.println("left");
                    result = input.readLine();
                    continue;
                }

                if(measures[0] > 15 && (measures[0] < 100)) {
                    double distance = (measures[0] - 15);
                    String toMove = "P1.MOVEFW " + Double.toString(distance);
                    robot.sendCommand(toMove);
                    //System.out.println("tot obj");
                    result = input.readLine();
                } else {
                    robot.sendCommand("P1.MOVEFW 40");
                    //System.out.println("fwd 30");
                    result = input.readLine();
                }

			} catch (IOException ioe) {
				System.err.println("execution stopped");
				running = false;
			}
		}

	}

	private void parsePosition(String value, double position[]) {
		int indexInit;
		int indexEnd;
		String parameter;

		indexInit = value.indexOf("X=");
		parameter = value.substring(indexInit + 2);
		indexEnd = parameter.indexOf(' ');
		position[0] = Double.parseDouble(parameter.substring(0, indexEnd));

		indexInit = value.indexOf("Y=");
		parameter = value.substring(indexInit + 2);
		indexEnd = parameter.indexOf(' ');
		position[1] = Double.parseDouble(parameter.substring(0, indexEnd));

		indexInit = value.indexOf("DIR=");
		parameter = value.substring(indexInit + 4);
		position[2] = Double.parseDouble(parameter);
	}

	private void parseMeasures(String value, double measures[]) {
        //System.out.println(value);
		for (int i = 0; i < 360; i++) {
			measures[i] = 100.0;
		}
		if (value.length() >= 5) {
			value = value.substring(5);  // removes the "SCAN " keyword

			StringTokenizer tokenizer = new StringTokenizer(value, " ");

			double distance;
			int direction;
			while (tokenizer.hasMoreTokens()) {
				distance = Double.parseDouble(tokenizer.nextToken().substring(2));
				direction = (int) Math.round(Math.toDegrees(Double.parseDouble(tokenizer.nextToken().substring(2))));
				if (direction == 360) {
					direction = 0;
				}
				measures[direction] = distance;
				// Printing out all the degrees and what it encountered.
				System.out.println("direction = " + direction + " distance = " + distance);
			}
		}
	}


}
