//=============================================================================
// PROGRAMMER: Jacob Williams
// PANTHER ID: 6182345
//
// CLASS: COP3337
// SECTION: RVDC
// SEMESTER: Summer 2020
// CLASSTIME: Online
//
// Project: Project 4
// Due: July 26th, 2020 @ 11:59 p.m.
//
// CERTIFICATION: I understand FIU’s academic policies, and I certify that this work is my 
//                own and that none of it is the work of any other person.
//=============================================================================

/*
Remember, I will not except late assignments. So please check the due date of the assignment.
IMPORTANT, you must have the File Header shown below with your information entered on the 
file at contains the project main method. If you do not have this header with your 
information, I will take 40% off your assignment grade.
*/

package app;

import analyze.DataAnalyzer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import util.StopWatch;

public class Controller {

    
    public static void main(String[] args) {
       
        
        // IMPORTANT WATCH THE PROJECT VIDEO BEFORE YOU START
        // IT WILL SAVE YOU A LOT OF TIME
        
        // create a DataAnalyzer object named dataAnalyzer
        // YOUR CODE HERE
        DataAnalyzer dataAnalyzer = new DataAnalyzer();

        // find the first 35 fibonacci numbers
        // until you get it all working set the for-loop to loop 8 times to save time
        
        for(int n = 1; n<=35; n++){
            
            // create a Stack object named stack
            // YOUR CODE HERE
            Stack<Integer> stack = new Stack<>();
            // create a StopWatch object named stopWatch
            // YOUR CODE HERE
            StopWatch stopWatch = new StopWatch();

            // start the stopWatch
            // YOUR CODE HERE
            stopWatch.start();
            // find the fibonacci index at n and save the value in fibValue
            // also pass the stack object so it can record the recursive method calls
            // HINT
            int fibValue = fib(n,stack);
            // create a map object <String, Integer> name map that is
            // constructed using a TreeMap constructor
            // HINT
            Map<String, Integer> map = new TreeMap();
            
            // figure out here how  many times a fib(n) was called and store this 
            // information in the map with fib(m) as the key and the times it was called 
            // as the value for this key
            // example
            // map("fib(5)", 2832);
            // map("fib(6)", 1230);
            //....
            // hint use
            ArrayList<Integer> counterArray = new ArrayList<>();
            
            for(int i=1; i<=n; i++){
            // YOU NEED SOME CODE HERE
                Iterator<Integer> stackIterator = stack.iterator();
                
                while(stackIterator.hasNext()){
                   // YOU NEED SOME CODE HERE
                   // if statement would be helpful 
                   int nextElement = stackIterator.next();
                   if(nextElement == i){
                       counterArray.add(nextElement);
                   }
                }   //end while
                // YOU NEED SOME CODE HERE
              
               map.put("fib(" + i + ")",counterArray.size());
               
               counterArray.clear();
           }    //end for
            // stop the stopWatch object
            //YOUR CODE HERE
            stopWatch.stop();
            
            // create an ExecutionInfo object name executionInfo
            // with correct inputs for the constructor
            // hint use stopWatch.getElapsedTime() for the last input
            
            // ExecutionInfo executionInfo OYUR CODE HERE
            ExecutionInfo executionInfo = new ExecutionInfo(map, n, fibValue, stopWatch.getElapsedTime());
            
            // add the executionInfo object to the dataAnalyzer arraylist
            // YOUR CODE HERE
         
            dataAnalyzer.getData().add(executionInfo);
            
        }//end for
        
   
        //----------------------------------
        
        
        // run the displayInfo method on each executionInfo object
        // within the dataAnalyzer arraylist using an enhanced for-loop
        // YOUR CODE HERE
     for(ExecutionInfo executionType : dataAnalyzer.getData()){
          executionType.displayInfo();
      }
       
        // call the dataAnalyzer findGrowthRate method
        // YOUR CODE HERE
        dataAnalyzer.findGrowthRate();
    }
    
    public static int fib(int n, Stack stack){
        
        // update the stack with the needed information
        // YOUR CODE HERE
        stack.push(n);
        
        //System.out.println(stack);
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        
        return fib(n-1,stack) +  fib(n-2,stack);
    }
    
}