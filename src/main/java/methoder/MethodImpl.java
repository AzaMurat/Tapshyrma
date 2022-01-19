package methoder;

import doa.AutoBase;
import set.DriverSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MethodImpl implements Methods {
    Random random = new Random();
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    List<AutoBase> list1 ;
    List<DriverSet> list2 ;
    private int id;

    public MethodImpl(List<AutoBase> list1, List<DriverSet> list2, int id) {
        this.list1 = list1;
        this.list2 = list2;
        this.id = id;
    }

    @Override
    public void changeDriver(List<AutoBase> list1, List<DriverSet> list2, int id) {
        //если уже в пути
        if (list1.get(id).getState().equals("route")) {
            System.out.println(ANSI_RED + "Мы не можем сменить водителя, потому что он уже в пути!" + ANSI_RESET);
        }

        //назначение нового водителя!
        else if (list1.get(id).getDriver().equals("")) {
            for (int i = 0; i < list1.size(); i++) {
                if (list2.get(i).getBus().equals("")) {
                    list1.get(id).setDriver(list2.get(i).getName());
                    list2.get(i).setBus(list1.get(id).getName());
                    System.out.println(ANSI_PURPLE + "Водитель успешно назначен!" + ANSI_RESET);
                    break;
                    //
                }
            }
        }
        //замена драйвера, если он уже есть!
        else if (!list1.get(id).getDriver().equals("")) {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(id).getDriver().equals(list2.get(i).getName())) {
                    list2.get(i).setBus("");
                    continue;
                }
                if (list2.get(i).getBus().equals("")) {
                    list1.get(id).setDriver(list2.get(i).getName());
                    list2.get(i).setBus(list1.get(id).getName());
                    System.out.println(ANSI_PURPLE + "Водитель успешно назначен!" + ANSI_RESET);
                    break;
                    //

                }
            }
        } else if (list1.get(id).getState().equals("repair")) {
            System.out.println(ANSI_RED + "Мы не можем назначить или изменить водителя!" + ANSI_RESET);
        }
    }

    @Override
    public void startDriving(List<AutoBase> list1, List<DriverSet> list2, int id) {

        int k = random.nextInt(3 - 1) + 1;
        //если уже в пути!
        if (list1.get(id).getState().equals("route")) {
            System.out.println(ANSI_RED + "Грузовик уже на дороге!" + ANSI_RESET);
        }
        //если в ремонте и нужно изменить состояние!
        else if (list1.get(id).getState().equals("repair") && !list1.get(id).getDriver().equals("")) {
            if (k == 1) {
                list1.get(id).setState("route");
                System.out.println(ANSI_PURPLE + "Отремонтировали и выехал на маршрут!" + ANSI_RESET);
            } else {
                list1.get(id).setState("base");
                System.out.println(ANSI_PURPLE + "С ремонта выехал!" + ANSI_RESET);
            }
        } else if (list1.get(id).getState().equals("repair") && list1.get(id).getDriver().equals("")) {
            if (k == 2) {
                list1.get(id).setState("base");
                System.out.println(ANSI_PURPLE + "С ремонта в базу приехал" + ANSI_RESET);

            }
        }
        // нельзя ездить без водителя!
        else if (list1.get(id).getState().equals("base") && list1.get(id).getDriver().equals("")) {
            System.out.println(ANSI_RED + "Вы не можете начать движение без водителя!" + ANSI_RESET);
        }
        //вождение грузовика!
        else if (!list1.get(id).getDriver().equals("")) {
            list1.get(id).setState("route");
            System.out.println(ANSI_PURPLE + "Выехал из базы!" + ANSI_RESET);
        }

    }

    @Override
    public void startRepair(List<AutoBase> list1, List<DriverSet> list2, int id) {
        //если в базе или маршруте назначать ремонт
        switch (list1.get(id).getState()) {
            case "route" -> {
                list1.get(id).setState("repair");
                System.out.println(ANSI_PURPLE + "С маршрута приехал в ремонт!" + ANSI_PURPLE);
            }
            case "base" -> {
                list1.get(id).setState("repair");
                System.out.println(ANSI_PURPLE + "Из базы приехал на ремонт!" + ANSI_PURPLE);
            }
            //если уже в ремонте
            case "repair" -> System.out.println(ANSI_RED + "Этот грузовик уже в ремонте!" + ANSI_RESET);
        }
    }

    public List<AutoBase> getList1() {
        return list1;
    }

    public List<DriverSet> getList2() {
        return list2;
    }
}