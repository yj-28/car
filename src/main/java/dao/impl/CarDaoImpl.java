package dao.impl;

import dao.CarDao;
import dao.OracleConnection;
import entity.Cars;
import entity.PageBusiness;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
    OracleConnection oc = new OracleConnection();

    public CarDaoImpl() {
    }

    public List<Cars> getCarsByPage(PageBusiness page) {
        String sql = "SELECT t.* FROM (SELECT rownum no,Id,brand,color,seats,rentmoney,creatdate,username FROM Cars)t WHERE t.no BETWEEN (?-1)*?+1 AND ?*?";
        Object[] parameters = new Object[]{page.getPageIndex(), page.getPageSize(), page.getPageIndex(), page.getPageSize()};
        ResultSet rs = this.oc.getResultSet(sql, parameters);
        ArrayList cars = new ArrayList();

        try {
            while(rs.next()) {
                Cars car=new Cars();
                car.setId(rs.getInt("Id"));
                car .setBrand(rs.getString("brand"));
                car.setColor(rs.getString("color"));
                car.setSeats(rs.getInt("seats"));
                car.setRentmoney(rs.getString("rentmoney"));
                car.setCreatedate(rs.getString("creatdate"));
                car.setUsername(rs.getString("username"));
                cars.add(car);
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        page.setPageCount((int)Math.ceil((double)this.getCounts() * 1.0D / (double)page.getPageSize()));
        return cars;
    }

    public int getCounts() {
        String sql = "SELECT * FROM Cars";
        ResultSet rs = this.oc.getResultSet(sql, (Object[])null);
        int count = 0;

        try {
            while(rs.next()) {
                ++count;
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return count;
    }

    public Cars getCarsById(int id) {
        String sql = "SELECT * FROM cars WHERE Id=?";
        Object[] parameters = new Object[]{id};
        ResultSet rs = this.oc.getResultSet(sql, parameters);
        Cars car = null;

        try {
            if (rs.next()) {
                car = new Cars();
                car.setId(rs.getInt("Id"));
                car.setBrand(rs.getString("brand"));
                car.setColor(rs.getString("color"));
                car.setSeats(rs.getInt("seats"));
                car.setConsum(rs.getString("consum"));
                car.setProductdate(rs.getString("productdate"));
                car.setRentmoney(rs.getString("rentmoney"));
                car.setCreatedate(rs.getString("creatdate"));
                car.setUsername(rs.getString("username"));
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        return car;
    }

    public List<Cars> getCarsByPage(String brand, double lowseats, double highseats, PageBusiness page) {
        String where = "WHERE 1=1";
        if (brand != null && !brand.equals("")) {
            where = where + " AND brand LIKE '%" + brand + "%'";
        }

        if (lowseats > 0.0D && highseats > 0.0D) {
            where = where + " AND seats BETWEEN " + lowseats + " AND " + highseats;
        } else if (lowseats > 0.0D && highseats <= 0.0D) {
            where = where + " AND seats>" + lowseats;
        } else if (lowseats <= 0.0D && highseats > 0.0D) {
            where = where + " AND seats<" + highseats;
        }

        System.out.println(where);
        String sql = "SELECT t.* FROM (SELECT rownum no,Id,brand,color,seats,rentmoney,creatdate,username FROM cars " + where + ")t " + "WHERE t.no BETWEEN (?-1)*?+1 AND ?*?";
        System.out.println(sql);
        Object[] parameters = new Object[]{page.getPageIndex(), page.getPageSize(), page.getPageIndex(), page.getPageSize()};
        ResultSet rs = this.oc.getResultSet(sql, parameters);
        ArrayList cars = new ArrayList();

        try {
            while(rs.next()) {
                Cars car = new Cars();
                car.setId(rs.getInt("Id"));
                car .setBrand(rs.getString("brand"));
                car.setColor(rs.getString("color"));
                car.setSeats(rs.getInt("seats"));
                car.setRentmoney(rs.getString("rentmoney"));
                car.setCreatedate(rs.getString("creatdate"));
                car.setUsername(rs.getString("username"));
                cars.add(car);
            }
        } catch (SQLException var13) {
            var13.printStackTrace();
        }

        page.setPageCount((int)Math.ceil((double)this.getCounts(brand, lowseats, highseats) * 1.0D / (double)page.getPageSize()));
        System.out.println((double)this.getCounts(brand, lowseats, highseats));
        return cars;
    }

    public int getCounts(String brand, double lowseats, double highseats) {

        String where = "SELECT * FROM Cars WHERE 1=1";
        if (brand != null && !brand.equals("")) {
            where = where + " AND brand LIKE '%" + brand + "%'";
        }

        if (lowseats > 0.0D && highseats > 0.0D) {
            where = where + " AND seats BETWEEN " + lowseats + " AND " + highseats;
        } else if (lowseats > 0.0D && highseats <= 0.0D) {
            where = where + " AND seats>" + lowseats;
        } else if (lowseats <= 0.0D && highseats > 0.0D) {
            where = where + " AND seats<" + highseats;
        }

        ResultSet rs = this.oc.getResultSet(where, (Object[])null);
        int count = 0;

        try {
            while(rs.next()) {
                ++count;
            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        }

        return count;
    }

    @Override
    public boolean deleteCar(int id) {
        String sqlOrder = "delete from cars where id = ?";
        Object[] parameters1 = new String[]{id+""};
        boolean flag = this.oc.execute(sqlOrder, parameters1);
        return flag;
    }

    @Override
    public Cars selectCarById(int id) {
        String sql="select * from cars where id =?";
        Object[] parameters1 = new String[]{id+""};
        ResultSet rs = this.oc.getResultSet(sql, parameters1);
        Cars car=new Cars();
        try {
            while(rs.next()) {
                car.setId(rs.getInt("id"));
                car.setBrand(rs.getString("brand"));
                car.setColor(rs.getString("color"));
                car.setSeats(rs.getInt("seats"));
                car.setConsum(rs.getString("consum"));
                car.setProductdate(rs.getString("productdate"));
                car.setRentmoney(rs.getString("rentmoney"));
                car.setCreatedate(rs.getString("createdate"));
                car.setUsername(rs.getString("username"));
            }
        }
        catch (SQLException var7) {
            var7.printStackTrace();
        }
        return car;
    }

    @Override
    public void addCar(Cars cars) {
        String sql="INSERT INTO Cars(Id,brand, color,seats,consum, productdate, rentmoney,creatdate,username) VALUES(?,?,?,?,?,?,?,?,?)";
        Object[] parameters1 = new Object[]{cars.getId(), cars.getBrand(), cars.getColor(), cars.getSeats(), cars.getConsum(), cars.getProductdate(), cars.getRentmoney(), cars.getCreatedate(), cars.getUsername()};
        this.oc.execute(sql, parameters1);
    }
}
