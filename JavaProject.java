



import java.util.Random;


class Aeroplane{
    private int capacity;
    private String Title;
    private PassengerCompartment A[];
    private String Description;
    private EquipmentCompartment XorosE3oplismou[]=new EquipmentCompartment[3] ;
    private CargoBay XorosEmporeumatwn;
    
    public Aeroplane(int capacity,String Title,String Description)
    {
        this.Description=Description;
        this.Title=Title;
        this.capacity=capacity;
        Random randomGenerator = new Random();
        int randomInt=randomGenerator.nextInt(capacity);
        A=new PassengerCompartment[randomInt];
        for(int i=0;i<randomInt;i++)
         {
            A[i]=new PassengerCompartment("Passenger Compartment"+i);
         }
        for(int i=0;i<3;i++)
        {
            
            XorosE3oplismou[i]=new EquipmentCompartment("Equipment Compartment"+i);
        }
        XorosEmporeumatwn=new CargoBay("CargoBay");
    }
    public void ready_check()
    {
        XorosEmporeumatwn.ready_check();
        for(int i=0;i<3;i++)
        {
            XorosE3oplismou[i].ready_check();
        }
        for(int i=0;i<A.length;i++)
         {
            A[i].ready_check();
         }
         System.out.println("Plane ready to take off");
    }
    public void process(SecurityEmployee Ergazomenos)
    {
        XorosEmporeumatwn.process(Ergazomenos);
        for(int i=0;i<3;i++)
        {
           XorosE3oplismou[i].process(Ergazomenos);
        }
        for(int i=0;i<A.length;i++)
        {
            A[i].process(Ergazomenos);
        }
        Ergazomenos.report();
    }
    public void process(CleaningEmployee B)
    {
         for(int i=0;i<A.length;i++)
        {
            A[i].process(B);
        }
         XorosEmporeumatwn.process(B);
         B.report();
    }
    public void process(MaintenanceEmployee G)
    {
        for(int i=0;i<3;i++)
        {
           XorosE3oplismou[i].process(G);
        }
        XorosEmporeumatwn.process(G);
        G.report();
    }
    
    public String get_title()
    {
        return this.Title;
    }
    public int get_capacity()
    {
        return this.capacity;
    }
    public String get_Description()
    {
        return this.Description;
    }
}
abstract class PlaneComponent{
    private String Description;
    public PlaneComponent(String Titlos)
    {
        this.Description=Titlos;
    }
    String get_Description()
    {
        return this.Description;
    }
    public abstract  void process(Employee Atomo);
}
class PassengerCompartment extends PlaneComponent {
    private PassengerCompartment Xoros;
    private int control;
    public PassengerCompartment(String Titlos)
    {
         super(Titlos);
        Random randomGenerator = new Random();
        int randomInt=randomGenerator.nextInt(1);
        if(randomInt==1)
        {
            Xoros=new PassengerCompartment(Titlos);
            this.control=1;
        }
            
    }
    public void process(Employee Atomo)
    {
        Atomo.workOn(this);
    }
    public void ready_check()
    {
        System.out.println(this.get_Description()+"PassengerCompartment OK");
        if(this.control==1)
        {
            System.out.println(this.get_Description()+"Internal PassengerCompartment OK");
        }
    }
}
class PrivateCompartment extends PlaneComponent{
    public PrivateCompartment(String Titlos)
    {
        super(Titlos);
    }
    public void process(Employee Atomo){
        
    }
}
class EquipmentCompartment extends PrivateCompartment
{
    public EquipmentCompartment(String Titlos)
    {
        super(Titlos);
    }
    public void ready_check()
    {
        System.out.println(this.get_Description()+"EquipmentCompartment OK");
    }
    @Override
    public void process(Employee Atomo)
    {
        Atomo.workOn(this);
    }
}
class CargoBay extends PrivateCompartment
{
    private EquipmentCompartment Place;
    public CargoBay(String Titlos)
    {
        super(Titlos);
        Place =new EquipmentCompartment(Titlos);
    }
    public void ready_check()
    {
        System.out.println(this.get_Description()+"CargoBay OK");
    }
    @Override
    public void process(Employee Atomo)
    {
        Atomo.workOn(this);
    }
}
abstract class Employee{
    private String Name;
    public Employee(String Name)
    {
        this.Name=Name;
    } 
   public abstract void report();
   public abstract void workOn(PlaneComponent Sinistwsa);
}

class CleaningEmployee extends Employee {
   public  CleaningEmployee (String Name){
       super(Name);
   }
   @Override
   public void report()
   {
       System.out.println("CleaningEmployee report: Just finished working");
       System.out.println("OK");
       
   }
   @Override
   public void workOn(PlaneComponent Sinistwsa)
   {
     System.out.println("Cleaning Employee works on "+Sinistwsa.get_Description());  
   }
}
class SecurityEmployee extends Employee{

    public SecurityEmployee(String Name) {
        super(Name);
    }
    @Override
    public void report()
    {
        System.out.println("SecurityEmployee report: Just finished working");
        System.out.println("OK");
    }
    @Override
    public void workOn(PlaneComponent Sinistwsa)
   {
     System.out.println("Security Employee works on "+Sinistwsa.get_Description());  
   }
}
class MaintenanceEmployee extends Employee {

    public MaintenanceEmployee(String Name) {
        super(Name);
    }
    @Override
    public void report()
    {
        System.out.println("MaintenanceEmployee report: Just finished working");
        System.out.println("OK");
    }
    @Override
    public void workOn(PlaneComponent Sinistwsa)
   {
     System.out.println("Maintenance Employee works on "+Sinistwsa.get_Description());  
   }
}
public class  JavaProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        int randomInt=randomGenerator.nextInt(200);
        Aeroplane Aegean=new Aeroplane(randomInt,"Hermes 20","Travel to Paris from Athens with safety,sir");
        CleaningEmployee A=new CleaningEmployee("Vaggelis");
        MaintenanceEmployee B=new MaintenanceEmployee("Kostantinos");
        SecurityEmployee C=new SecurityEmployee("Prokopis");
        Aegean.process(A);
        Aegean.process(B);
        Aegean.process(C);
        Aegean.ready_check();
    }
    
}

