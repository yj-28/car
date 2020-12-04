package dao;

import entity.Cars;
import entity.PageBusiness;

import java.util.List;

public interface CarDao {
    List<Cars> getCarsByPage(PageBusiness var1);

    int getCounts();

    Cars getCarsById(int var1);

    List<Cars> getCarsByPage(String var1, double var2, double var4, PageBusiness var6);

    boolean deleteCar(int id);

    Cars selectCarById(int id);

    void addCar(Cars cars);
}

