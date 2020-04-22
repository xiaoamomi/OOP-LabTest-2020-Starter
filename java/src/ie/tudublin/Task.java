package ie.tudublin;

import processing.data.TableRow;

public class Task
{
    private String task;
    private int start;
    private int end;

    public Task(String task, int start, int end)
    {
        this.task = task;
        this.start = start;
        this.end = end;
    }

    public Task(TableRow tr)
    {
        this(tr.getString("Task"), tr.getInt("Start"), tr.getInt("End"));
    }

    public String getName()
    {
        return task;
    }

    public void setName(String task)
    {
        this.task = task;
    }

    public int getStart()
    {
        return start;
    }

    public void setStart(int start)
    {
        this.start = start;
    }

    public int getEnd()
    {
        return end;
    }

    public void setEnd(int end)
    {
        this.end = end;
    }

    public String toString()
    {
        return "Task[task=" + task +", start="+ start +",end ="+ end +"]";
    }
}