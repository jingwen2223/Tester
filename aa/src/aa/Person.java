package aa;

public class Person {

    
    private String name;
    private boolean hasDriverLicense;
    private int age; // in years
    private int height; // in inches
    
    public Person(String name, boolean hasDriverLicense, int age, int height) {
            this.name = name;
            this.age = age;
            this.hasDriverLicense = hasDriverLicense;
            this.height = height;
    }
    
    public String getName() {
            return name;
    }
    
    public boolean hasDriverLicense() {
            return hasDriverLicense;
    }
    
    public int getAge() {
            return age;
    }
    
    public int getHeight() {
            return height;
    }
    
    @Override
    public Person clone() {
            Person clone = new Person (name, hasDriverLicense, age, height);
            return clone;
    }
    
    @Override
    public boolean equals(Object obj) {
            if (obj instanceof Person) {
                    Person a = (Person)obj;
                    if (name == a.getName() && hasDriverLicense == a.hasDriverLicense() && age == a.getAge() && height == a.getHeight()) {
                            return true;
                    }
                    else {
                            return false;
                    }
            }
            else {
                    return false;
            }
    }
    
    @Override
    public String toString() {
            
            if (hasDriverLicense) {
                    String a = String.format("Person [name= %10s | age= %02d | height= %02d | has license]", name, age, height);
                    return a;
            }
            else {
                    String a = String.format("Person [name= %10s | age= %02d | height= %02d | no license]", name, age, height);
                    return a;
            }

    }
}