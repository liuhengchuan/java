package test;
import java.util.Scanner;
import java.util.Random;
public class Game1 extends Game{
	Game1()
	{};
	void play()
	{
		Scanner so=new Scanner(System.in);
		System.out.println("��ѡ���ɫ��Warrior,Master");
		String name=so.next();
		super.setActor(name);
		super.randomActor();
		while(super.a1.judgefailure()&&super.a2.judgefailure())
		{
			System.out.println("��ѡ�������Defense����Attack");
			String actor=so.next();
			Random random=new Random();
			int IF=Math.abs(random.nextInt()%2);
			if(IF==0)
			{
				super.a2.defense();
				if(actor.equals("Defense"))	
					
				  {
					super.a1.defense();
					super.a2.Denfense(a1);
					super.a1.Denfense(a2);
				  }
				else
				{
					super.a1.attack();
					super.a2.Denfense(a1);
					super.a1.generalattack(a2);
				}
			}
			else
			{
				super.a2.attack();
				if(actor.equals("Attack"))
				{
					super.a1.attack();
					super.a2.generalattack(a1);
					super.a1.doubleattack(a2);
				}
				else
				{
					super.a1.defense();
					super.a1.Denfense(a2);
					super.a2.doubleattack(a1);
				}
			}
			System.out.println("�ҵ�Ѫ����"+super.a1.getblood()+"���Ե�Ѫ����"+super.a2.getblood());
		}
		if(!super.a1.judgefailure()&&!super.a2.judgefailure())
			System.out.println("ƽ��");
		else
			if(!super.a1.judgefailure())
				System.out.println("������");
				else
					if(!super.a2.judgefailure())
						System.out.println("��Ӯ��");
		
	}
}
