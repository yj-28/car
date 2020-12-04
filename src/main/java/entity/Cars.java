package entity;

public class Cars {
    private int id;
    private String brand;
    private String color;
    private int seats;
    private String consum;
    private String productdate;
    private String rentmoney;
    private String createdate;
    private String username;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getConsum() {
        return consum;
    }

    public void setConsum(String consum) {
        this.consum = consum;
    }

    public String getProductdate() {
        return productdate;
    }

    public void setProductdate(String productdate) {
        this.productdate = productdate;
    }

    public String getRentmoney() {
        return rentmoney;
    }

    public void setRentmoney(String rentmoney) {
        this.rentmoney = rentmoney;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", seats=" + seats +
                ", consum='" + consum + '\'' +
                ", productdate='" + productdate + '\'' +
                ", rentmoney='" + rentmoney + '\'' +
                ", createdate='" + createdate + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
