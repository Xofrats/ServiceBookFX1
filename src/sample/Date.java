package sample;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year){
        this.day=day;
        this.month = month;
        this.year = year;
    }

    public Date(){

    }

    public  void setDate(int day, int month, int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public Date copy(){
        Date date = new Date(this.day, this.month, this.year);
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Date date = (Date) o;

        if (day != date.day) return false;
        if (month != date.month) return false;
        return year == date.year;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
