//Cracking the Coding Interview
//Chapter 8: Recursion and Dynamic Programming
//Problem-8.2: Robot in a Grid
//Description: A robot is sitting on the upper left corner of a grid, and it only can 
//move to its right or down. Some of the cells are "obstacle" such that the robot cannot 
//step on them. Design an algorithm to find a path for the robot from the top left to the 
//bottom right cell.

import java.util.*;
import java.awt.Point;

class RobotInGrid{
	public static void main(String[] args){
		int[][] maze = {{1,1,1,0},
				{1,0,1,1},
				{1,1,0,1}};
		ArrayList<Point> path = getPath(maze);
		for(Point p : path){
			System.out.println(p.toString());
		}
	}

	public static ArrayList<Point> getPath(int[][] maze){
		if(maze == null || maze.length == 0){
			return null;
		}
		ArrayList<Point> path = new ArrayList<>();
		HashSet<Point> failedPoints = new HashSet<>();

		if(getPath(maze, maze.length-1, maze[0].length-1, path, failedPoints)){
			return path;
		}

		//no path found?
		return null;
	}
	
	public static boolean getPath(int[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints){
		//if out of bounds or not available
		if(row < 0 || col < 0 || maze[row][col] == 0){
			return false;
		}

		Point p = new Point(row, col);
		//if we have already visited the cell, return
		if(failedPoints.contains(p)){
			return false;
		}
		
		boolean isAtOrigin = (row == 0) && (col == 0);

		if(isAtOrigin || getPath(maze, row-1, col, path, failedPoints) || getPath(maze, row, col-1, path, failedPoints)){
			path.add(p);
			return true;
		}

		failedPoints.add(p); //cache result 
		return false;
	}	
}


