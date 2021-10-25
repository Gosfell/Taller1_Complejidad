package taller1comp;


/**
 *
 * @author Mendoza-Diego_Muñoz-Tomas_Torres-Sebastian
 */
public class Info {

    long AveragePrice;
    long Volume;
    long smallHass;
    long largeHass;
    long extraLargeHass;
    long TotalBags;

    public Info(long AveragePrice, long Volume, long smallHass, long largeHass, long extraLargeHass, long TotalBags) {
        this.AveragePrice = AveragePrice;
        this.Volume = Volume;
        this.smallHass = smallHass;
        this.largeHass = largeHass;
        this.extraLargeHass = extraLargeHass;
        this.TotalBags = TotalBags;
    }
    
    //numero,Date,AveragePrice,Total Volume,4046,4225,4770,Total Bags,Small Bags,Large Bags,XLarge Bags,type,year,region

    @Override
    public String toString() {
        return "Info{" + "AveragePrice=" + AveragePrice + ", Volume=" + Volume + ", smallHass=" + smallHass + ", largeHass=" + largeHass + ", extraLargeHass=" + extraLargeHass + ", TotalBags=" + TotalBags + '}';
    }

    public long getVolume() {
        return Volume;
    }

    public long getTotalBags() {
        return TotalBags;
    }
    
    
    
    
    
}
