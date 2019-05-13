/*
 * File name: CMVector.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: May 11, 2019
 */
package reyesProjects;

/**
 * This is the Youtube tutorial Vector class created by Coding Math on Youtube. I will be learning about vectors from this 
 * sample code, of which I will be upgrading as I find useful for my programs.
 *
 * @author Michael Jesus Reyes
 *
 */
public class CMVector
{
	private double xValue;
	private double yValue;
	
	public CMVector(double xValue, double yValue)
	{
		this.xValue = xValue;
		this.yValue = yValue;
	}
	
	public void setXValue(int newXValue)
	{
		this.xValue = newXValue;
	}
	
	public void setYValue(int newYValue)
	{
		this.yValue = newYValue;
	}
	
	public double getXValue()
	{
		return xValue;
	}
	
	public double getYValue()
	{
		return yValue;
	}
	
	public void setAngle(double angle)
	{
		double length = this.getLength();
		this.xValue = Math.cos(angle) * length;
		this.yValue = Math.sin(angle) * length;
	}
	
	public double getAngle()
	{
		return Math.atan2(yValue, xValue);
	}
	
	public void setLength(double length)
	{
		double angle = this.getAngle();
		this.xValue = Math.cos(angle) * length;
		this.yValue = Math.sin(angle) * length;
	}
	
	public double getLength()
	{
		return Math.sqrt(xValue * xValue + yValue * yValue);
	}
	
	public CMVector add(CMVector otherVector)
	{
		return new CMVector((this.xValue + otherVector.getXValue()), (this.yValue + otherVector.getYValue()));
	}
	
	public CMVector subtract(CMVector otherVector)
	{
		return new CMVector((this.xValue - otherVector.getXValue()), (this.yValue - otherVector.getYValue()));
	}
	
	public CMVector multiply(double value)
	{
		return new CMVector(this.xValue * value, this.yValue * value);
	}
	
	public CMVector divide(double value)
	{
		return new CMVector(this.xValue / value, this.yValue / value);
	}
	
	public void addTo(CMVector otherVector)
	{
		this.xValue += otherVector.getXValue();
		this.yValue += otherVector.getYValue();
	}
	
	public void subtractFrom(CMVector otherVector)
	{
		this.xValue -= otherVector.getXValue();
		this.yValue -= otherVector.getYValue();
	}
	
	public void multiplyBy(double value)
	{
		this.xValue *= value;
		this.yValue *= value;
	}
	
	public void divideBy(double value)
	{
		this.xValue /= value;
		this.yValue /= value;
	}
}
