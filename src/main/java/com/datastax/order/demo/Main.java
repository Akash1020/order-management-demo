package com.datastax.order.demo;


public class Main{

	public static void main(String[] args){
		
		String orderFile = System.getProperty("orderFile");
		if (orderFile == null){
			orderFile = "order_list_final.csv";
		}
				
		String batchSizeStr = System.getProperty("batchSize"); 
		if (batchSizeStr == null){
			batchSizeStr = "3000";
		}
		
		String contactPointsStr = System.getProperty("contactPoints"); 
		if (contactPointsStr == null){
			contactPointsStr = "127.0.0.1";
		}		
		
		StreamProcessor processor = new StreamOrderProcessorImpl(orderFile, contactPointsStr.split(","), Integer.parseInt(batchSizeStr));
		processor.startStreaming();
	}
}
