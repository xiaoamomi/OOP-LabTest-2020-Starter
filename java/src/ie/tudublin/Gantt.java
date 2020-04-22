package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	ArrayList<Task> tasks = new ArrayList<Task>();
	ArrayList<Task> starts = new ArrayList<Task>();
	ArrayList<Task> ends = new ArrayList<Task>();
	
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");
		for(TableRow row : table.rows())
		{
			Task t = new Task(row);
			tasks.add(t);
		}
	}

	public void printTasks()
	{
		for(Task t:tasks)
		{
			System.out.println(t);
		}
	}

	public void displayTasks()
	{
		float border = 200;
		float i = 50;
		float z = 100;
		for(float x = 1; x < 32; x++)
		{
			if(x%2 == 1)
			{
				stroke(255,255,255);
				float lx = map(x, 1, 31, border, width);
				line(lx, i, lx, height - i );
				text((int)x, lx, 30);
			}
			else
			{
				stroke(255,0,255);
				float lx = map(x, 1, 31, border, width);
				line(lx, i, lx, height - i );
				text((int)x, lx, 30);
			}
		}

		for(int n = 0; n < tasks.size(); n++)
		{
			Task t = tasks.get(n);
			
			stroke(255,255,255);
			float y = map(n, 0, tasks.size(), z, height - i);
			
			textAlign(LEFT, CENTER);
			text(t.getName(), z , y);
		}

		

	}
	
	public void mousePressed()
	{
		
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{		
		background(0);
		displayTasks();
	}
}
