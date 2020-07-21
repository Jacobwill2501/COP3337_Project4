package analyze;

import app.ExecutionInfo;
import static java.lang.Math.log;
import java.util.ArrayList;

public class DataAnalyzer {
    
    private ArrayList<ExecutionInfo> data; 

    public DataAnalyzer() {
        
        data = new ArrayList<>();
    }

    public ArrayList<ExecutionInfo> getData() {
        return data;
    }
    
    public void findGrowthRate(){
          System.out.println("");
          
         System.out.println("-------------------------------------------------");
         System.out.println("Data Analyzer Growth Rate");
         System.out.println("-------------------------------------------------");
         
         // your output format must match mine
         // look at the video for see the out format
         // the exponent value is e^x = total method class   
         // you need to find the x... do not over think it use the Math class 
         // YOU PUT YOUR CODE HERE
        for(ExecutionInfo counter : data){
        System.out.printf("Index:  %-3d FibValue:  %-10d Calls: %-10.00f Exponent: %.03f \n",
                counter.getFibIndex(),counter.getFibValue(),counter.getTotalMethodCalls(),log(counter.getTotalMethodCalls()));
        }
    }
    
}// end class
