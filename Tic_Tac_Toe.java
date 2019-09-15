import java.util.*;
class Tic_Tac_Toe
{
    Scanner sc=new Scanner(System.in);
    String n1,n2,n;
    Tic_Tac_Toe()
    {
        n1="";
        n2="";
        n="";
    }
    void welcome()
    {
        System.out.println("**********************************************************");
        System.out.println("~~~~~~~~~~~~WELCOME TO SANKALPA'S TIC TAC TOE~~~~~~~~~~~~~");
        System.out.println("The Fourth World War would be fought with sticks and stones, prophesed Albert Einstein.");
        System.out.println("In our eternal quest to fulfil Einstein's prophecy, we have sought far and near for out sticks and stones.");
        System.out.println("You would think we have drawn a blank but be prepared to be mistaken, for we have unearthed a whole new arena.");
        System.out.println("We looked far and wide and found a triad: a triad of our very own, desperately seeking conjugation.");
        System.out.println("We thought we would leave it to you, to help them unite in a rendition of bliss.");
        System.out.println("And hence, we unearth before you: Sankalpa's Tic Tac Toe.");
        System.out.println("Are you ready to roll into a quest of your own to unearth the secrets that lie beneath the maze?");
        n=sc.next(); 
        System.out.println();
        System.out.println();
        System.out.println();
        int p=1;
        if(!n.equalsIgnoreCase("Yes"))
        {
            System.out.println("The secrets lie unearthed for the Knight's Templar sought shelter in the luxury of the castle.");
            System.exit(0);
        }
        else if(n.equalsIgnoreCase("Yes"))
        {
            System.out.println("The hurdles are afew, the challenge has been set anew.");
            System.out.println("Be it the twinkling stars or the glaring Sun, the world is but a regulated caucus of rules and regulations.");
            System.out.println("Order is paramount, discipline is expeditious. Control is but a remnant of rules and regulations.");
            System.out.println();
            System.out.println();
            System.out.println();
            do
            {
                System.out.println("*************************RULES AND REGULATIONS************************************");
                System.out.println("1. We dance in duets and sing in pairs: Only two players are allowed to play this game at a time.");
                System.out.println("2. The game is started by the player assigned with X, which will be assigned randomly.");
                System.out.println("3. The game ends when there are 3 consecutive X's or O's horizontally, vertically or diagonally.");
                System.out.println("4. The player with the alignment check wins the game.");
                System.out.println();
                System.out.println("Press 0 to re-read the rules. Press any other numeric key to move on.");
                p=sc.nextInt();
            }while(p==0);
            System.out.println("The warriors were prepared. The battle lines were drawn. The flags were flying aloft the chariots.");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.print("Player 1 Name: ");
            String gr=sc.next();
            System.out.print("Player 2 Name: ");
            String br=sc.next();
            System.out.println("The trumpets blare. The clinch of swords and armours echo across.");
            int x=(int)Math.random();
            System.out.println("The coin flips in mid-air, as with bated air the warriors wait in eagerness to know their fate.");
            System.out.println();
            System.out.println();
            System.out.println();
            if(x==1)
            {
                n1=gr;
                n2=br;
            }
            else
            {
                n1=br;
                n2=gr;
            }
            System.out.println(n1+" will be initating proceedings with X while "+n2+" will be competing with O.");
            System.out.println("The clarinet rings in the distance, the church bells toll. The game, my friends, is on.");
        }
    }

    void play()
    {
        String a[][]=new String [3][3];
       int b[][]=new int[3][3];
       for(int i=0;i<3;i++)
       {
            for(int j=0;j<3;j++)
                a[i][j]=" ";
       }
       int m=0; int flag=0;
       while(true)
       {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Recording board position at move "+m+":");
            System.out.println();
            display(a);
            if(m%2==0)
            {
                System.out.println();
                System.out.println("MOVE "+m+": X");
                System.out.println(n1+" ,please enter your cell position: row and column");
                int x=sc.nextInt();
                int y=sc.nextInt();
                if(x>2||y>2||x<0||y<0)
                {
                    System.out.println();
                    System.out.println("ERROR: Oops! That is a few too many. Please input position again");
                    continue;
                }
                else if(b[x][y]>0)
                {
                    System.out.println();
                    System.out.println("ERROR: The position has already been occupied. Please try again");
                    continue;
                }
                else
                {
                    a[x][y]="X";
                    b[x][y]=1;
                    m++;
                }
                if (full(b)&& check(b)==false)
                {
                    System.out.println();
                    System.out.println();
                    display(a);
                    System.out.println("Oh holy night! The battle is at a stalemate. For thee shalt enuniciate a tie. ");
                    break;
                }
                if(check(b))
                {
                    System.out.println();
                    System.out.println();
                    display(a);
                    victory("X");
                    break;
                }
            }
            else if (m%2==1)
            {
                System.out.println();
                System.out.println ("MOVE "+m+": O");
                System.out.println(n2+" ,please enter your cell position: row and column");
                int x=sc.nextInt();
                int y=sc.nextInt();
                if(x>2||y>2||x<0||y<0)
                {
                    System.out.println();
                    System.out.println("ERROR: Oops! That is a few too many. Please input position again");
                    continue;
                }
                else if(b[x][y]>0)
                {
                    System.out.println();
                    System.out.println("ERROR: The position has already been occupied. Please try again");
                    continue;
                }
                else
                {
                    a[x][y]="O";
                    b[x][y]=2;
                    m++;
                }
                if (full(b) && check(b)==false)
                {
                    System.out.println();
                    System.out.println();
                    display(a);
                    System.out.println("Oh holy night! The battle is at a stalemate. For thee shalt enuniciate a tie. ");
                    break;
                }
                if(check(b))
                {
                    System.out.println();
                    System.out.println();
                    display(a);
                    victory("O");
                    break;
                }
            }
       }
    }

    void display(String a[][])
    {
        System.out.println(a[0][0]+"   |     "+a[0][1]+"   |     "+a[0][2]);
        System.out.println("__________________________");
        System.out.println(a[1][0]+"   |     "+a[1][1]+"   |     "+a[1][2]);
        System.out.println("__________________________");
        System.out.println(a[2][0]+"   |     "+a[2][1]+"   |     "+a[2][2]);
    }

    boolean check(int a[][])
    {
        int f=0;
        /*for(int i=0;i<3;i++)
        {
        for(int j=0;j<2;j++)
        {
        if(a[i][j]!=a[i][j+1])
        {
        f=1;
        break;
        }
        }
        }
        for(int i=0;i<2;i++)
        {
        for(int j=0;j<3;j++)
        {
        if(a[i][j]!=a[i+1][j])
        {
        f=1;
        break;
        }
        }
        }*/
        if(a[0][0]==a[0][1]&&a[0][0]==a[0][2]&&a[0][1]==a[0][2]&&a[0][0]>0)//top row
            f=1;
        else if(a[2][0]==a[2][1]&&a[2][1]==a[2][2]&&a[2][2]==a[2][0]&&a[2][0]>0)//bottom row
            f=1;
        else if(a[0][0]==a[1][0]&&a[1][0]==a[2][0]&&a[2][0]==a[0][0]&&a[0][0]>0)//Left column
            f=1;
        else if(a[0][2]==a[1][2]&&a[1][2]==a[2][2]&&a[2][2]==a[0][2]&&a[2][2]>0)//Right column
            f=1;
        else if(a[0][1]==a[1][1]&&a[1][1]==a[2][1]&&a[2][1]==a[0][1]&&a[0][1]>0)//Middle column
            f=1;
        else if(a[1][0]==a[1][1]&&a[1][1]==a[1][2]&&a[1][2]==a[1][0]&&a[1][0]>0)//Middle row
            f=1;
        else if(a[0][0]==a[1][1]&&a[1][1]==a[2][2]&&a[1][1]>0)//left diagonal
            f=1;
        else if(a[0][2]==a[1][1]&&a[1][1]==a[2][0]&&a[2][0]>0)//right diagonal
            f=1;
        else
            f=0;
        if (f==1)
            return true;
        else
            return false;
    }

    boolean full (int b[][])
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(b[i][j]==0)
                    return false;
            }
        }
        return true;
    }

    void victory(String b)
    {
        String win="";String lose="";
        if(b=="X")
        {
            win=n1;
            lose=n2;
        }
        else if(b=="O")
        {
            win=n2;
            lose=n1;
        }
        System.out.println();
        System.out.println();
        System.out.println("The Mystic Rheordan crowns "+win+" with the Crown of the Thousand Realms");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    }

    void hello()
    {
        Tic_Tac_Toe obj=new Tic_Tac_Toe();
        int p=0;
        obj.welcome();
        obj.play();
        while(true)
        {
            System.out.println();
            System.out.println();
            System.out.println("Shalt thy knight endeavour on quest to redeem his spirit?");
            System.out.println("Press 1 to redraw your faith; 0 to renegade the fortunes.");
            System.out.println();
            System.out.println();
            int l=sc.nextInt();
            if(l==1)
            {
                obj.welcome();
                obj.play();
            }
            else
            {
                System.out.println();
                System.out.println();
                System.out.println("The Knight's Templar rests in peace. Validation is sought as the clouds clear.");
                System.out.println("Enter your rating from 0 to 10, 10 being the best and 0 the worst");
                int rate=sc.nextInt();
                System.out.println("Merci bien");
                System.out.println("***************************************THE SWORD HAS BEEN LAID TO REST*******************************");
                break;
            }
        }
    }
}