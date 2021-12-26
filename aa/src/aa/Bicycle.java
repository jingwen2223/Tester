package aa;

public class Bicycle extends Vehicle implements Comparable<Bicycle> {

    private double weight;
    static int[] seats = {1};
  final static double ACCURACY_RANGE = 0.5;
    
    public Bicycle() {
            super(1, 1);
            weight = 0.0;
    }
    
    public Bicycle(Person driver) {
            super(driver, seats);
            weight = 0.0;
    }
    
    public Bicycle(Person driver, double w) {
            super(driver, seats);
            if (w <0) {
                    weight = 0;
            }
            else {
                    weight = w;
            }
    }
    
    public double getWeight() {
            return weight;
    }
    
    public void setWeight(double w) {
            if (w <0) {
                    weight = 0;
            }
            else {
                    weight = w;
            }
    }               
                    
    
    @Override
    public void setDriver(Person p) throws InvalidDriverException{
            if (p.getAge()<3) {
                    throw new InvalidDriverException();
            }
            else {
                    personsOnBoard[0][0] = p;
            }
    }
    
    @Override
    public boolean equals(Object c) {  //same weight. ACCURACY_RANGE = 0.5 
        //SEE NOTE 4
            if ( c instanceof Bicycle) {
                    Bicycle a = (Bicycle)c;
                    if(Math.abs(weight - a.getWeight()) <= ACCURACY_RANGE) {
                            return true;
                    }
                    else {return false;
                    }
          }
            else {
                    return false;
            }
    }
    

    @Override
    public int compareTo(Bicycle b) {// NOTE 6
            if (this.weight - b.getWeight() <=  ACCURACY_RANGE || this.weight - b.getWeight() >= ACCURACY_RANGE) {
                    return 0;
            }
            else if (this.weight  - b.getWeight() > ACCURACY_RANGE) {
                    return 1;
            }
            else {
                    return -1;
            }
    }

    @Override
    public boolean loadPassenger(Person p) {
            return false;
    }

    @Override
    public int loadPassengers(Person[] peeps) {
            return 0;
    }
    
    @Override
    public String toString() {
            Person driver = getDriver();
            String s = "Bicycle [ rider= " + driver.getName() + " | weight= " + weight + " ]";
            return s;
    }

    
    
}