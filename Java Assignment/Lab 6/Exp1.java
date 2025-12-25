abstract class Thermostat {
    abstract void adjustTemperature(int newTemp);
    abstract int getCurrentTemp();
}

class RoomThermostat extends Thermostat {
    private String room;
    private int temp;
    RoomThermostat(String room, int temp) {
        this.room = room;
        this.temp = temp;
    }

    public void adjustTemperature(int temp) {
        if(temp < 15 || temp > 30) {
            System.out.println("Cannot set temperature for " + room + ". Range is 15 to 30");
            return;
        }
        this.temp = temp;
        System.out.println(room + " temperature set to " + temp + "°C");
    }

    public int getCurrentTemp() {
        return temp;
    }
    public String getRoom() {
        return room;
    }
}

public class Exp1{
     public static void main(String[] args) {
        RoomThermostat t1 = new RoomThermostat("Lobby", 22);
        RoomThermostat t2 = new RoomThermostat("Bedroom", 19);
        RoomThermostat t3 = new RoomThermostat("Kitchen", 23);
        t1.adjustTemperature(26);
        t2.adjustTemperature(20);
        t3.adjustTemperature(27);    
        System.out.println("Updated Temperatures:");
        System.out.println(t1.getRoom() + ": " + t1.getCurrentTemp() + "°C");
        System.out.println(t2.getRoom() + ": " + t2.getCurrentTemp() + "°C");
        System.out.println(t3.getRoom() + ": " + t3.getCurrentTemp() + "°C");
    }
}
