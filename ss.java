package test;
import java.util.Random;
import java.util.Scanner;
interface CanPlay
{
	void attack(Actor a);
	void defense();
}
class Actor
{
	String name;
	int blood;
	boolean state;
	int []attacknum;
	int []defensefactor;
	int id;
	Actor(){};
	Actor(int b,int i,int []a,int []d,String n)
	{
		blood=b;
		id=i;
		attacknum=a;
		defensefactor=d;
		name=n;
	}
	void generalattack(Actor a) 
	{
		 Random random=new Random();
	   	 int attack=attacknum[Math.abs(random.nextInt()%3)];
   	     if(a.state)
   	     {
   	    	 blood=blood-attack;
   	     }
   	     else
   	     {
   	    	Random r=new Random();
  	        int defense=defensefactor[Math.abs(r.nextInt()%3)];
      	    blood=blood-attack+defense;
   	     }
	};
	void doubleattack(Actor a)
	{
		 Random random=new Random();
	   	 int attack=2*attacknum[Math.abs(random.nextInt()%3)];
  	     if(a.state)
  	     {
  	    	 blood=blood-attack;
  	     }
  	     else
  	     {
  	    	Random r=new Random();
 	        int defense=defensefactor[Math.abs(r.nextInt()%3)];
     	    blood=blood-attack+defense;
  	     }
	};
	void attack()
    {
  	  state=true;
    }
	boolean judgefailure()
    {
  	  return blood>0;
    }
	public void defense() 
    {
  	  state=false;
    }
	void Denfense(Actor a)
	{
		Random random=new Random();
   	    int attack=defensefactor[Math.abs(random.nextInt()%3)];
   	    if(a.state)
   	    {
   	    	blood=blood-attack;
   	    }
   	    else
   	    {
   	        Random r=new Random();
	        int denfense=defensefactor[Math.abs(r.nextInt()%3)];
   	    	blood=blood-attack+denfense;
   	    }
	}
	int getblood()
    {
  	  return blood;
    }
}
class Game
{
	int actortypenum;
	Actor a1;
	Actor a2;
	int []Attacknum1= {20,18,16};
    int []Defensefactor1={5,4,3};
    int []Attacknum2= {10,9,8};
    int []Defensefactor2={10,9,8};
	class Master extends Actor
	{
		Master()
     	{
     		 super(100,1,Attacknum1,Defensefactor1,"Master");
     	}
	}
	class Warrior extends Actor
    {
	   	 Warrior()
	   	 {
	   		 super(100,2,Attacknum2,Defensefactor2,"Warrior");
	   	 }
    }
	void  randomActor()
	{
		Random random=new Random();
  	    int which=Math.abs(random.nextInt()%2);
  	    switch(which)
  	    {
  	       case(0):a2=new Master();
  	       break;
  	       case(1):a2=new Warrior();
  	       break;
	    }
	}
	void setActor(String type)//人
    {
	  	  switch(type)
	  	  {
	  	  case"Master":a1=new Master();
	  	  break;
	  	  case"Warrior":a1=new Warrior();
	  	  break;
  	      }
    }
}

public class ss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner so=new Scanner(System.in);
		System.out.println("游戏开始");
		Game1 game=new Game1();
	    game.play();
	}

}
