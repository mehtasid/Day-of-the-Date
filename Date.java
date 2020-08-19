import java.io.*;
class Date
{
    void main() throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String day[]= {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
        String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
        int month[]={1,2,3,4,5,6,7,8,9,10,11,12};
        int mn[]={1,4,4,0,2,5,0,3,6,1,4,6};
        int a=0;
        System.out.println("Enter year");
        int y=Integer.parseInt(br.readLine());
        System.out.println("Enter month number");
        int m=Integer.parseInt(br.readLine());
        System.out.println("Enter day of the date");
        int d=Integer.parseInt(br.readLine());
        for(int i=1;i<13;i++)
        {
            if(isvalid(d,m,y))
            {
              if(m==(month[i-1]))
              {
                if(isleap(y))
                {
                a=d+(((y%100)/4)-1)+(y%100)+ dn(y)+ mon(m);
                a%=7;
                System.out.println(d+" "+months[i-1]+" "+y+" "+"is a " +day[a]);
                }
                else
                {
                a=d+((y%100)/4)+(y%100)+ dn(y)+ mon(m);
                a%=7;
                System.out.println(d+" "+months[i-1]+" "+y+" "+"is a " +day[a]);
                }
              }
            }
            else
            {
            System.out.println("Invalid Date"); 
            break;
            }
        }
    }
    
    
    int dn (int z)
    {
        int b =(z/100)%4; int x=0;
        switch(b)
        {
            case 0:
            x=6;
            break;
            case 1:
            x=4;
            break;
            case 2:
            x=2;
            break;
            case 3:
            x=0;
            break;
        } return x;
    }
    int mon (int z)
    {
        int month[]={1,2,3,4,5,6,7,8,9,10,11,12};
        int mn[]={1,4,4,0,2,5,0,3,6,1,4,6}; int c=0;
        for (int i=1;i<13;i++)
        {
            if(z==(month[i-1]))
            c= mn[i-1];
        } return c;
    } 
    boolean isvalid(int d, int m, int y)
    {
     int md[]={31,28,31,30,31,30,31,31,30,31,30,31};
     if (isleap(y))
     md[1]=29;
     if(d<0 || d>md[m-1])
     return false;
     if(m<0 || m>12)
     return false;
     return true;
    }
    boolean isleap(int y)
    {
      int f=0;
      if(y%100==0)
     {
         if(y%400==0)
         f=1;
         else
         f=0;
     }
     else
     {
         if (y%4==0)
         f=1;
         else
         f=0;
     }
     if(f==1)
     return true;
     return false;
    }
}
  