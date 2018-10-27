package sample;

import java.util.ArrayList;

public class Servicebook {
    private ArrayList<Service> services;

    public Servicebook(ArrayList<Service> services) {
        this.services = services;
    }

    public void addService(Service service){
        services.add(service);
    }

    public int getNumberOfServices(){
        return services.size();
    }

    public Service getService(int index){
        return (services.get(index));

    }
    public ArrayList getAllServices(){

        return services;

    }

    public int[] getAllServiceMileages(){

        int length = getNumberOfServices();
        int[] test = new int[length];

        for (int i=0; i<length; i++){
            Service service = services.get(i);
            int mileage = service.getMileage();
            test[i] = mileage;
        }

        return test;

    }

    public boolean hasServiceOnDate(Date checkDate) {
        Boolean hasDate = false;

        for (int i = 0; i < services.size(); i++) {
            Service service = services.get(i);
            Date date = service.getDate();
            hasDate = date.equals(checkDate);
            if(hasDate)
            {
                break;

            }
        }
        return hasDate;
    }


    public Date getDateOfLastService() {
        int size = getNumberOfServices() - 1;
        Service lastService = services.get(size);
        Date lastDate = lastService.getDate();
        return lastDate;
    }

    @Override
    public String toString() {
        return
                "services=" + services +
                "} ";
    }


}