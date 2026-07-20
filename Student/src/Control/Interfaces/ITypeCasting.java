package Control.Interfaces;

public interface ITypeCasting {
    public default int stringToInt(String str){
        return Integer.parseInt(str);
    }
}
