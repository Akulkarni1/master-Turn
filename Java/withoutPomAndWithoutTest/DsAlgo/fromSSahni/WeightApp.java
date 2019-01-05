package Algorithm.fromSSahni;
class Weight{
    long ounces;
    long pounds;
    long tons;
    Weight(){
        ounces =0;
        pounds =0;
        tons =0;
    }

    public long getOunces() {
        return ounces;
    }

    public void setOunces(long ounces) {
        this.ounces = ounces;
    }

    public long getPounds() {
        return pounds;
    }

    public void setPounds(long pounds) {
        this.pounds = pounds;
    }

    public long getTons() {
        return tons;
    }

    public void setTons(long tons) {
        this.tons = tons;
    }
    public long addOunce(int ounces){
        return this.ounces+ounces;
    }
    public long sub(int ounces){
        return this.ounces - ounces;
    }
    public long multiple(int ounces){

        return this.ounces*ounces;
    }
    public long addTon(int ton){
        return this.tons+ton;
    }
    public long addPound(int pound){
        return this.pounds+pound;
    }
    public void convert(int weight){
        if(weight>2240) {
            while (weight > 2240) {
                weight = weight - 2240;
                addTon(1);
            }
            if (weight > 16) {
                convertPoundOunce(weight);
            }
        }
        convertPoundOunce(weight);
        if(weight<=16){
            addOunce(weight);
        }
    }

    private void convertPoundOunce(int weight) {
        if(weight>16){
        while(weight>16)
            weight = weight-16;
        addPound(1);
    }
            else {
        addOunce(weight);
    }
    }
}
public class WeightApp {
}
