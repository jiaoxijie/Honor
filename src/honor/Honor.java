package honor;
/**
 * @author jiaoxijie
 * @version 1.0
 * @date 2018.10.28
 */
import java.util.Scanner;
import java.util.Random;
/**
战场控制模块
*/
class BattleField{
	/**
	 * 战场构造二维数组。
	 */
	static char [][] A = new char [100][100];
	/**
	 * 初始化战场
	 */
	public void Initiate() {
		Random rand = new Random();
		int i, j, n, m, k;
		for(i = 0 ;i < 20; i++)
			for(j = 0 ; j < 20; j++)
				A[i][j] = '0';
		n = rand.nextInt(100);
		for(i = 0; i < n; i++)
		{
			m = rand.nextInt(20);
			k = rand.nextInt(20);
			A[m][k] = '*';
		}
	}
	/**
	 * 类方法，用于打印战场
	 */
	public static void Print() {
		
		int i, j;
		for(i = 0; i < 100; i++)
		{
			for(j = 0; j < 100; j++)
			{
				System.out.print(BattleField.A[i][j]);
				System.out.print(' ');
			}
			System.out.println(' ');
		}
	}
}
/**
人物角色模块
*/
class Character{

	public char Name;
	public int Hp = 100, Mp = 100, Exp = 0, level = 0;
	public int x,y;
	/**
	 控制人物移动。
	 @param num 控制英雄选择。
	 @param direction 控制英雄移动方向。
	 */
	public void move(int num, char direction) {
		
		switch(direction)
		{
		case 'a':
			System.out.println("You want to move left");
			x--;
			if(BattleField.A[y][x] != '0')
			{
				Hp -= 10;
				x++;
				System.out.println("You have run into a barrier! ");
			}
			else
			{
				System.out.println(x);
	    		System.out.println(y);
				BattleField.A[y][x+1] = '0';
				BattleField.A[y][x] = (char)(num + 64);
				BattleField.Print();
			}
			break;
			
		case 's':
			System.out.println("You want to move downward");
			y++;
			if(BattleField.A[y][x] != '0')
			{
				Hp -= 10;
				y--;
				System.out.println("You have run into a barrier! ");
			}
			else
			{
				System.out.println(x);
	    		System.out.println(y);
	    		BattleField.A[y-1][x] = '0';
	    		BattleField.A[y][x] = (char)(num + 64);
	    		BattleField.Print();
			}
			break;
			
		case 'd':
			System.out.println("You want to move right");
			x++;
			if(BattleField.A[y][x] != '0')
			{
				Hp -= 10;
				x--;
				System.out.println("You have run into a barrier! ");
			}
			else
			{
				System.out.println(x);
	    		System.out.println(y);
	    		BattleField.A[y][x-1] = '0';
	    		BattleField.A[y][x] = (char)(num + 64);
	    		BattleField.Print();
			}
			break;
			
		case 'w':
			System.out.println("You want to move forward");
			y--;
			if(BattleField.A[y][x] != '0')
			{
				Hp -= 10;
				y++;
				System.out.println("You have run into a barrier! ");
			}
			else
			{
				System.out.println(x);
	    		System.out.println(y);
	    		BattleField.A[y+1][x] = '0';
	    		BattleField.A[y][x] = (char)(num + 64);
				BattleField.Print();
			}
			break;
		}
	}
	public int ret_x(){
		return x;
	}
	public int ret_y(){
		return y;
	}
	public int ret_Hp()
	{
		return Hp;
	}
	public int ret_Mp()
	{
		return Mp;
	}
	public int ret_Exp()
	{
		return Exp;
	}
}
/**
 * 继承Character类，第一个类别英雄
 */
class typeone extends Character{
	
	public int flag = 1;
	/**
	 * 技能：发射子弹。
	 * @param num 控制英雄选择。
	 * @param direction 控制子弹发射方向。
	 */
	public void skill(int num, char direction){
		int x1 = x;
		int y1 = y;
		int t = 1;
		if(Mp < 10) 
			return;
		else
			Mp -= 10;
		switch(direction)
		{
		case 'a':
			while(x1 > 0)
			{
				if(t > 1)
					BattleField.A[y][x1] = '0';
				if(BattleField.A[y][x1-1] == '*')
				{
					Exp += 10;
					if(Exp >= 100)
					{
						level++;
						Hp = 100;
						Mp = 100;
						Exp = 0;
					}
				}
				BattleField.A[y][--x1] = '-';
				BattleField.Print();
				t++;
			}
			break;
			
		case 's':
			while(y1 <= 18)
			{
				if(t > 1)
					BattleField.A[y1][x] = '0';
				if(BattleField.A[y1+1][x] == '*')
				{
					Exp += 10;
					if(Exp >= 100)
					{
						level++;
						Hp = 100;
						Mp = 100;
						Exp = 0;
					}
				}
				BattleField.A[++y1][x] = '-';
				BattleField.Print();
				t++;
			}
			break;
		case 'w':
			while(y1 > 0)
			{
				if(t > 1)
					BattleField.A[y1][x] = '0';
				if(BattleField.A[y1-1][x] == '*')
				{
					Exp += 10;
					if(Exp >= 100)
					{
						level++;
						Hp = 100;
						Mp = 100;
						Exp = 0;
					}
				}
				BattleField.A[--y1][x] = '-';
				BattleField.Print();
				t++;
			}
			break;
			
		case 'd':
			while(x1 <= 18)
			{
				if(t > 1)
					BattleField.A[y][x1] = '0';
				if(BattleField.A[y][x1+1] == '*')
				{
					Exp += 10;
					if(Exp >= 100)
					{
						level++;
						Hp = 100;
						Mp = 100;
						Exp = 0;
					}
				}
				BattleField.A[y][++x1] = '-';
				BattleField.Print();
				t++;
			}
			break;
		}
	}
}
/**
 * 继承Character类，第二个类别英雄
 */
class typetwo extends Character{
	
	public int flag = 2;
	/**
	 * 技能：清除障碍物。
	 * @param num 控制英雄选择。
	 * @param direction 控制技能使用方向。
	 */
	public void skill(int num, char direction){
		switch(direction)
		{
		case 'a':
			if(BattleField.A[y][x-1] == '*')
			{
				BattleField.A[y][x-1] = '0';
				Exp += 10;
				if(Exp >= 100)
				{
					level++;
					Hp = 100;
					Mp = 100;
					Exp = 0;
				}
				BattleField.Print();
			}
			else 
				System.out.println("Sorry, you miss the target! ");
			break;
		case 's':
			if(BattleField.A[y+1][x-1] == '*')
			{
				BattleField.A[y+1][x-1] = '0';
				Exp += 10;
				if(Exp >= 100)
				{
					level++;
					Hp = 100;
					Mp = 100;
					Exp = 0;
				}
				BattleField.Print();
			}
			else 
				System.out.println("Sorry, you miss the target! ");
			break;
		case 'w':
			if(BattleField.A[y-1][x] == '*')
			{
				BattleField.A[y-1][x] = '0';
				Exp += 10;
				if(Exp >= 100)
				{
					level++;
					Hp = 100;
					Mp = 100;
					Exp = 0;
				}
				BattleField.Print();
			}
			else 
				System.out.println("Sorry, you miss the target! ");
			break;
		case 'd':
			if(BattleField.A[y][x+1] == '*')
			{
				BattleField.A[y][x+1] = '0';
				Exp += 10;
				if(Exp >= 100)
				{
					level++;
					Hp = 100;
					Mp = 100;
					Exp = 0;
				}
				BattleField.Print();
			}			
			else 
				System.out.println("Sorry, you miss the target! ");
			break;
		}
	}
}

public class Honor {
    static Character [] Role = new Character [10];
    static BattleField Field = new BattleField();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		int i, j;
		int n ,m ,k;
		Field.Initiate();
		BattleField.Print();
		
		for(i = 0; i < 10; i++)
		{
			k = rand.nextInt(1) + 1;
			if(k == 1)
				Role[i] = new typeone();
			else 
				Role[i] = new typetwo();
			Role[i].Name = (char)(i + 65);
		}
		for(i = 0; i < 10; i++)
		{
			do
			{
				m = rand.nextInt(5);
				k = rand.nextInt(5);
			} while(BattleField.A[k][m] != '0');
			Role[i].x = m;
			Role[i].y = k;
			BattleField.A[k][m] = Role[i].Name;
		}
		BattleField.Print();
		System.out.println("Enter 'a' to move left");
		System.out.println("Enter 's' to move down");
		System.out.println("Enter 'd' to move right");
		System.out.println("Enter 'w' to move forward");
		System.out.println("Enter 'Q' to quit");
		char c;
		int num, l;
		while((c = in.next().charAt(0)) != 'Q')
		{
			num = in.nextInt();
			System.out.println("You are controling Hero " + (char)(num + 64));
			System.out.println("Do you want to move or use the skill? 1 or 2");
			l = in.nextInt();
			if(l == 1)
				Role[num-1].move(num, c);
			else
				if(l == 2)
					((typeone) Role[num-1]).skill(num, c);
				else
					((typetwo) Role[num-1]).skill(num, c);
		}
		for(i = 0; i < 10; i++)
			System.out.println("The level of Hero " + (char)(i + 65) + " is " + Role[i].level);
		in.close();
	}
}
