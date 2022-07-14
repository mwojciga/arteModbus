package com.artetechnic.artemodbus;

import java.net.*;
import java.io.*;
import gnu.io.*;
import net.wimpi.modbus.ModbusCoupler;
import net.wimpi.modbus.io.ModbusSerialTransaction;
import net.wimpi.modbus.msg.ReadInputRegistersRequest;
import net.wimpi.modbus.msg.ReadInputRegistersResponse;
import net.wimpi.modbus.net.SerialConnection;
import net.wimpi.modbus.util.SerialParameters;

public class ArteModbus {

	public static void main(String[] args) {
		try {
/*
			// The important instances of the classes mentioned before 
			SerialConnection con = null; // the connection
			ModbusSerialTransaction trans = null; // the transaction
			ReadInputRegistersRequest req = null; // the request
			ReadInputRegistersResponse res = null; // the response

			// Variables for storing the parameters 
			String portname = null; // the name of the serial port to be used
			int unitid = 0; // the unit identifier we will be talking to
			int ref = 0; // the reference, where to start reading from
			int count = 0; // the count of IR's to read
			int repeat = 1; // a loop for repeating the transaction

			// 1. Setup the parameters
			if (args.length < 4) {
				System.out.println("Less then 4 params.");
				System.exit(1);
			} else {
				try {
					portname = args[0];
					System.out.println(portname);
					unitid = Integer.parseInt(args[1]);
					System.out.println(unitid);
					ref = Integer.parseInt(args[2]);
					System.out.println(ref);
					count = Integer.parseInt(args[3]);
					System.out.println(count);
					if (args.length == 5) {
						repeat = Integer.parseInt(args[4]);
						System.out.println(repeat);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					System.exit(1);
				}
			}

			// 2. Set master identifier
			// ModbusCoupler.createModbusCoupler(null);
			ModbusCoupler.getReference().setUnitID(1);

			// 3. Setup serial parameters
			SerialParameters params = new SerialParameters();
			params.setPortName(portname);
			params.setBaudRate(9600);
			params.setDatabits(8);
			params.setParity("None");
			params.setStopbits(1);
			//params.setEncoding("ascii");
			params.setEncoding("RTU");
			params.setEcho(false);

			// 4. Open the connection
			con = new SerialConnection(params);
			con.open();

			// 5. Prepare a request
			req = new ReadInputRegistersRequest(ref, count);
			req.setUnitID(unitid);
			req.setHeadless();

			// 6. Prepare a transaction
			trans = new ModbusSerialTransaction(con);
			trans.setRequest(req);

			// 7. Execute the transaction repeat times
			int k = 0;
			do {
				trans.execute();
				res = (ReadInputRegistersResponse) trans.getResponse();
				for (int n = 0; n < res.getWordCount(); n++) {
					System.out.println("Word " + n + "="
							+ res.getRegisterValue(n));
				}
				k++;
			} while (k < repeat);

			// 8. Close the connection
			con.close();
			*/
			
			
			
			System.out.println("Serial Port Connection");
		    /* The important instances of the classes mentioned before */
		    SerialConnection con = null; //the connection
		    ModbusSerialTransaction trans = null; //the transaction
		    ReadInputRegistersRequest req = null; //the request
		    ReadInputRegistersResponse res = null; //the response

		     // **1 Variables for storing the parameters** 
		     String portname= "COM1"; //the name of the serial port to be used
		     int unitid = 1; //the unit identifier we will be talking to
		     int ref = 1000; //the reference, where to start reading from
		     int count = 5; //the count of IR's to read
		     int repeat = 1; //a loop for repeating the transaction  
		     boolean isopen = false;

		    // 2. Set master identifier**
		    // ModbusCoupler.createModbusCoupler(null);
		    // ModbusCoupler.getReference().setMaster(master); I added this in
		    // ModbusCoupler.getReference().setMaster(true);
		    // ModbusCoupler.getReference().setUnitID(1); 

		    // 3. Setup serial parameters**
		    SerialParameters params = new SerialParameters();
		    params.setPortName("COM2");
		    params.setBaudRate(38400);
		    params.setDatabits(8);
		    params.setParity("None");
		    params.setStopbits(1);
		    params.setEncoding("RTU");
		    params.setEcho(false);

		    //System.setProperty("net.wimpi.modbus.debug", "true");
		    // 4. Open the connection**
		    con = new SerialConnection(params);
		    System.out.println("Connection..." + con.toString());
		    con.open();

		     isopen = con.isOpen();
		     System.out.println("Serial port status..." + isopen);

		    // 5. Prepare a request**
		    req = new ReadInputRegistersRequest(ref, count);
		    req.setUnitID(unitid);
		    req.setHeadless();

		    // 6. Prepare a transaction**
		    trans = new ModbusSerialTransaction(con);
		    trans.setRequest(req);

		    // 7. Execute the transaction repeat times**
		    int k = 0;
		    do { 
		    trans.execute();
		    res = (ReadInputRegistersResponse) trans.getResponse();
		    for (int n = 0; n < res.getWordCount(); n++) {
		    System.out.println("Word " + n + "=" + res.getRegisterValue(n));
		    }
		    k++;
		    } while (k < repeat);

		    // 8. Close the connection**
		    con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}// main

}// class SerialAITest

