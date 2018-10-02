
public class Helping
{
	int a;
	int b;
	int c;
	
	public Helping(int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public void print()
	{
		String aS = "x^2";
		String bS = "x";
		String cS = "";
		
		if(a > 0 && a != 1)
		{
			aS = a + aS;
		}
		if(a < 0 && a != -1)
		{
			a = Math.abs(a);
			aS = " - " + a + aS;
		}
		if(a == 0)
		{
			aS = "";
		}
		
		if(b > 0 && b != 1 && a != 0)
		{
			bS = " + " + b + bS;
		}
		if(a == 0 && b != 1 && b != -1)
		{
			bS = b + bS;
		}
		if(b < 0 && b != -1)
		{
			b = Math.abs(b);
			bS = " - " + b + bS;
		}
		else if (b == -1)
		{
			bS = " - " + bS;
		}
		if(b == 0)
		{
			bS = "";
		}
		
		if(c > 0 && b!= 0)
		{
			cS = " + " + c + cS;
		}
		if(b == 0 && a!=0)
		{
			cS = " + "  + c + cS;
		}
		else if(a == 0 && b == 0)
		{
			cS = c + cS;
		}
		if(c < 0)
		{
			c = Math.abs(c);
			cS = " - " + c;
		}
		if(c == 0)
		{
			cS = "";
		}
		
		if(a == 0 && b == 0 && c == 0)
		{
			System.out.print(0);
		}
		System.out.print( aS + bS + cS);
	}
	
	
	
	public static void main(String[] args)
	{
		Helping name = new Helping(-1, 0, 5);
		name.print();
	}

}
