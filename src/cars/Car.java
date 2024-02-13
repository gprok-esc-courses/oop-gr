package cars;

public class Car {

    private int id;
    private String plate;
    private double km;
    private boolean rented;

    public Car() {
        this(-1, "N/A", 0);
    }
    public Car(int id, String plate, double km) {
        setId(id);
        setPlate(plate);
        setKm(km);
        setRented(false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKm(double km) {
        if(km > 0 && km > this.km) {
            this.km = km;
        }
    }

    public double getKm() {
        return km;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String toString() {
        return this.id + " " + this.plate + ", km:" + this.km;
    }
}
