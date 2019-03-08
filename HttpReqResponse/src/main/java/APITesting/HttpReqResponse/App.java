package APITesting.HttpReqResponse;


public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	HttpConnection handler = new HttpConnection();
    	handler.SeleniumSetup();
    	handler.ConvertLanguageFrom("English");
    	handler.ConvertLanguageTo("Hindi");
    	handler.EnterWord("Hello");
    	Thread.sleep(1000);
    	String data = handler.getConvertedOutput();
    	System.out.println("Converted Output : "+data);
    	handler.CloseConnection();
    	
    }
}

