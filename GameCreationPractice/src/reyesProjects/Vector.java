/*
 * File name: Vector.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Sep 29, 2018
 */
package reyesProjects;

/**
 * This is the class I created to represent physics vectors. This class was designed as an upgrade to the vector 
 * class from the Coding Math Youtube tutorial. This class' functionality was tested compared to the tutorial 
 * class and it works the same.
 *
 * @author Michael Jesus Reyes
 *
 */
public class Vector
{
	private double xPos, yPos, angle, length;
	
	public Vector(double xPosOrAngle, double yPosOrLength, boolean isAngleAndLength) //Is this boolean is true, it means you want to create a vector with an Angle and Length parameters.
	{
		if(isAngleAndLength == false)
		{
			this.xPos = xPosOrAngle;
			this.yPos = yPosOrLength;
			//Calculate rest of Vector
			calculateAngle();
			calculateLength();
		}
		else
		{
			this.angle = xPosOrAngle;
			this.length = yPosOrLength;
			setAngle(this.angle);
			setLength(this.length);
		}
	}

	public double getxPos()
	{
		return xPos;
	}

	public void setxPos(double xPos)
	{
		this.xPos = xPos;
	}

	public double getyPos()
	{
		return yPos;
	}

	public void setyPos(double yPos)
	{
		this.yPos = yPos;
	}

	public double getAngle()
	{
		return angle;
	}
	
	public void setAngle(double angle)
	{
		this.angle = angle;
		this.xPos = Math.cos(angle) * length;
		this.yPos = Math.sin(angle) * length;
	}
	
	private void calculateAngle()
	{
		this.angle = Math.atan2(this.yPos, this.xPos);
	}

	public double getLength()
	{
		return length;
	}
	
	public void setLength(double length)
	{
		this.length = length;
		this.xPos = Math.cos(angle) * length;
		this.yPos = Math.sin(angle) * length;
	}
	
	private void calculateLength()
	{
		this.length = Math.sqrt(Math.pow(this.xPos,2)+Math.pow(this.yPos, 2));
	}
	
	public Vector add(Vector otherVector)
	{
		return new Vector(this.xPos + otherVector.getxPos(), this.yPos + otherVector.getyPos(), false);
	}
	
	public Vector subtract(Vector otherVector)
	{
		return new Vector(this.xPos - otherVector.getxPos(), this.yPos - otherVector.getyPos(), false);
	}
	
	public Vector multiply(double value) //Scalar multiplication
	{
		return new Vector(this.xPos * value, this.yPos * value, false);
	}
	
	public Vector divide(double value) //Scalar division
	{
		return new Vector(this.xPos / value, this.yPos / value, false);
	}
	
	public void addTo(Vector otherVector)
	{
		this.xPos += otherVector.getxPos();
		this.yPos += otherVector.getyPos();
	}
	
	public void subtractFrom(Vector otherVector)
	{
		this.xPos -= otherVector.getxPos();
		this.yPos -= otherVector.getyPos();
	}
	
	public void multiplyBy(double value)
	{
		this.xPos *= value;
		this.yPos *= value;
	}
	
	public void divideBy(double value)
	{
		this.xPos /= value;
		this.yPos /= value;
	}
}