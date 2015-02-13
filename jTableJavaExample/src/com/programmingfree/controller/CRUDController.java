package com.programmingfree.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.programmingfree.dao.DataManipulation;
import com.programmingfree.model.Customers;


@WebServlet("/CRUDController")
public class CRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public CRUDController() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null){
			String action=(String)request.getParameter("action");
			if(action.equals("list")){
				try{
				List<Customers> lstCustomer=new ArrayList<Customers>();
			
				//Fetch Data from CSV file
				lstCustomer=DataManipulation.getAllCustomers();
				
				//Convert Java Object to Json
				Gson gson = new Gson();
				JsonElement element = gson.toJsonTree(lstCustomer, new TypeToken<List<Customers>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();
				
				//Return Json in the format required by jTable plugin
				listData="{\"Result\":\"OK\",\"Records\":"+listData+"}";					
				response.setContentType("application/json");
				response.setHeader("Cache-control", "no-cache, no-store");
		        response.setHeader("Pragma", "no-cache");
		        response.setHeader("Expires", "-1");
				response.getWriter().print(listData);
				System.out.println(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace()+"}";
					response.getWriter().print(error);
					System.out.println(error);
				}
				
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
