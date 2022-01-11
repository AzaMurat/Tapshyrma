package methoder;

import set.DriverSet;

import doa.AutoBase;

import java.util.List;


public interface Methods {
    void changeDriver(List<AutoBase> list1, List<DriverSet> list2, int id);

    void startDriving(List<AutoBase> list1, List<DriverSet> list2, int id);

    void startRepair(List<AutoBase> list1, List<DriverSet> list2, int id);
}