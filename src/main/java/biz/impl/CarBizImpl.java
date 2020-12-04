package biz.impl;

import biz.CarBiz;
import dao.CarDao;
import dao.impl.CarDaoImpl;
import entity.Cars;
import entity.PageBusiness;

import java.util.Iterator;
import java.util.List;

public class CarBizImpl implements CarBiz {
    CarDao bdao = new CarDaoImpl();

    public CarBizImpl() {
    }

    public List<Cars> listByPage(PageBusiness page) {
        return this.bdao.getCarsByPage(page);
    }

    public Cars searchById(int id) {
        return this.bdao.getCarsById(id);
    }

    public List<Cars> listByPage(String brand, double lowseats, double highseats, PageBusiness page) {
        return this.bdao.getCarsByPage(brand, lowseats, highseats, page);
    }

    public boolean deleteCar(Integer id) {
       return bdao.deleteCar(id);
    }

    @Override
    public Cars selectById(int id) {
        return bdao.selectCarById(id);
    }

    @Override
    public void addCar(Cars cars) {
        bdao.addCar(cars);
    }
}
