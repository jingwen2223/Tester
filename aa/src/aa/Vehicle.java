package aa;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Vehicle {

        protected Person[][] personsOnBoard;
        protected int numberOfRows;
        protected int maxSeatsPerRow;
        protected int[] numSeatsPerRow;
        
        public Vehicle(int numRows, int numSeatPerRow) {
                numberOfRows = numRows;
                maxSeatsPerRow = numSeatPerRow;
                numSeatsPerRow = new int[numSeatPerRow];
                for (int i = 0; i< numberOfRows; i++) {
                        numSeatsPerRow[i] = numSeatPerRow;
                }
                personsOnBoard = new Person[numberOfRows][numSeatPerRow];
        }
        
        public Vehicle(int[] numSeatPerRow) {
                numSeatsPerRow = numSeatPerRow;
                numberOfRows = numSeatsPerRow.length;
                maxSeatsPerRow = 0;
                for (int i = 0; i<numberOfRows; i++) {
                        if (maxSeatsPerRow < numSeatsPerRow[i]) {
                                maxSeatsPerRow = numSeatsPerRow[i];
                        }
                }
                
                personsOnBoard = new Person[numberOfRows][maxSeatsPerRow];
        }
        
        public Vehicle(Person driver, int[] numSeatsPerRow) {
                this.numSeatsPerRow = numSeatsPerRow;
                numberOfRows = numSeatsPerRow.length;
                maxSeatsPerRow = 0;
                for (int i = 0; i<numberOfRows; i++) {
                        if (maxSeatsPerRow < numSeatsPerRow[i]) {
                                maxSeatsPerRow = numSeatsPerRow[i];
                        }
                }
                
                personsOnBoard = new Person[numberOfRows][maxSeatsPerRow];
                if (driver.hasDriverLicense()) {
                        personsOnBoard[0][0] = driver;
                }
        }
        
        public abstract boolean loadPassenger(Person p);
        
        public abstract int loadPassengers(Person[] peeps);
        
        public void setDriver(Person p) throws InvalidDriverException{
                if (!(p.hasDriverLicense())) {
                        throw new InvalidDriverException();
                }
                else {
                        personsOnBoard[0][0] = p;
                }
        }
        
        public Person getDriver() {
                if (personsOnBoard[0][0] instanceof Person) {
                        return personsOnBoard[0][0];
                }
                else {
                        return null;
                }
        }
        
        public boolean hasDriver() {
                if (personsOnBoard[0][0] instanceof Person ) {
                        return true;
                }
                else {
                        return false;
                }
        }
        
        public int getNumberOfAvailableSeats() {
                int count = 0;
                
                for (int i = 0; i<numberOfRows; i++) {
                        for (int j = 0; j<numSeatsPerRow[i]; j++) {
                                
                                if (personsOnBoard[i][j]  == null){
                                        count++;
                                }
                        }
                }
                
                return count;
        }
        
        public int getNumberOfAvailableSeatsInRow(int row) {
                int count = 0;
                
                if (row <0 || row> numberOfRows-1) {
                        count = -1;
                }
                else {
                        for (int i= 0; i<numSeatsPerRow[row]; i++) {
                                if (personsOnBoard[row][i]  == null) {
                                        count++;
                                }
                        }
                }
                return count;
        }
        
        public int getNumberOfPeopleOnBoard() {
                int count = 0;
                
                for (int i = 0; i<numberOfRows; i++) {
                        for (int j = 0; j<numSeatsPerRow[i]; j++) {
                                if (personsOnBoard[i][j] instanceof Person) {
                                        count++;
                                }
                        }
                }
                
                return count;
        }
        
        public int getNumberOfPeopleInRow(int row) {
                int count = 0;
                
                for (int i = 0; i<numSeatsPerRow[row]; i++) {
                        if (personsOnBoard[row][i] instanceof Person) {
                                count++;
                        }
                }
                
                return count;
        }
        
        public Person getPersonInSeat(int row, int col) {
                if (row >= 0 && row<numberOfRows && col>= 0 && col< numSeatsPerRow[row]) {
                        return personsOnBoard[row][col];
                }
                else {
                        return null;
                }
        }
        
        public int[] getLocationOfPersonInVehicle(Person p) {
                
                int[] b = {-1, 1};
                
                for (int i = 0; i<numberOfRows; i++) {
                        for (int j = 0; j<numSeatsPerRow[i]; j++) {
                                
                                if (personsOnBoard[i][j] != null) {
                                        if (personsOnBoard[i][j].equals(p)){
                                        b[0] = i;
                                        b[1] = j;
                                        }
                                }
                        }
                }
                return b;
        }
        
        public Person[] getPeopleInRow(int row) {
                ArrayList<Person> list = new ArrayList<Person>();

                if (row < 0 || row > numberOfRows-1) {
                        return null;
                }
                
                for (int i = 0; i<numSeatsPerRow[row]; i++) {
                        if (personsOnBoard[row][i] instanceof Person) {
                                Person b = personsOnBoard[row][i].clone();
                                list.add(b);
                        }
                }
                
                if (list.size() < 1) {
                        return null;
                }
                
                Person[] cloneList = list.toArray(new Person[0]);
                
                return cloneList;
                
        }
        
        public Person[][] getPeopleOnBoard() {
                Person[][] result = new Person[personsOnBoard.length][];
                for (int i = 0; i<personsOnBoard.length; i++) {
                        result[i] = personsOnBoard[i].clone();
                                
                }
                return result;
        }
        
        public boolean isPersonInVehicle(Person p) {
                int[] orig = getLocationOfPersonInVehicle(p);

                return (orig[0] != -1);
        }
        
        public boolean isPersonDriver(Person p) {
                
                return (personsOnBoard[0][0].equals(p));
                
        }
        
}