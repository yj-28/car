package biz;

import entity.Cars;
import entity.PageBusiness;

import java.util.List;

public interface CarBiz {
    List<Cars> listByPage(PageBusiness var1);

    Cars searchById(int var1);

    List<Cars> listByPage(String var1, double var2, double var4, PageBusiness var6);

    boolean deleteCar(Integer id);

    Cars selectById(int id);

    void addCar(Cars cars);
}
