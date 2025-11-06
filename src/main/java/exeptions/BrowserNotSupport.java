package exeptions;

public class BrowserNotSupport extends Exception{
    public BrowserNotSupport(String browser){
        super(String.format("Browser %s is not support", browser));
    }
}
