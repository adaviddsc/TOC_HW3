import org.json.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Object;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;

public class TocHw3 {

	public static void main(String[] args) {
		String json = new String();
		String line = new String();
		int price = 0;
		int amount = 0;
        try {  
            URL url = new URL(args[0]);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));	
            while ((line = br.readLine()) != null) {
            	json += line;              
            }
            
            JSONTokener jsonParser = new JSONTokener(json);                
            JSONArray arr = new JSONArray(jsonParser);    
            
            for ( int c=0;c<=9999999;c++ ){
            	/*if ( !arr.getJSONObject(c).has("鄉鎮市區") ){
            		System.out.println("123");
            		break;
            	}*/
            	if ( arr.getJSONObject(c).getString("鄉鎮市區").equals(args[1]) ){
            		if ( arr.getJSONObject(c).getString("土地區段位置或建物區門牌").indexOf(args[2]) != -1 && Integer.toString( arr.getJSONObject(c).getInt("交易年月") ).indexOf(args[3]) != -1 ){
            			price += arr.getJSONObject(c).getInt("總價元");
            			amount++;
            			System.out.println(arr.getJSONObject(c).getString("鄉鎮市區") + '\t' + arr.getJSONObject(c).getString("土地區段位置或建物區門牌") + '\t' + arr.getJSONObject(c).getInt("交易年月") + '\t' + arr.getJSONObject(c).getInt("總價元") );           	
            		}
            	}
            }
            
            /*InputStreamReader InputStrRead = new InputStreamReader(url.openStream());        
            char[] getDataBuff = new char[10]; 
       		while(InputStrRead.read(getDataBuff)!=-1){  
	        	InputStrRead.read(getDataBuff);
	        	DataString.append(getDataBuff);  
	        }  
	                 
           	File fileDir = new File("json1.txt");
           
   			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));
           
           	while (br.ready()) {
	           	br.readLine();
	           	System.out.println(br.readLine());          	
           	}
        	
           	FileReader fr = new FileReader("json.txt");
         	System.out.println(message);	
           	json = DataString.toString();  
           	System.out.println(json);    
         	System.out.println(jsonParser);*/
              
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (JSONException e) {
        	System.out.println( "Output:\n\t" + price/amount );
        	//e.printStackTrace();  
        }

        
        
	}

}
