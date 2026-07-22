package Control.Interfaces;

public interface ITypeCasting {
    public default double stringToScore(String str){
        return Double.parseDouble(str);
    }
    public default int stringToInt(String str){
        return Integer.parseInt(str);
    }
}
