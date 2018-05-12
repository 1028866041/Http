package com.HttpPost.httppost;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.spi.LoginModule;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet implements LoginModule {
	private static final long serialVersionUID = 1L;
	
	private LoginService service;
	public void init() throws ServletException{
		service = new LoginService();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
     * @see LoginModule#abort()
     */
    public boolean abort() throws javax.security.auth.login.LoginException { 
         // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see LoginModule#login()
     */
    public boolean login() throws javax.security.auth.login.LoginException { 
         // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see LoginModule#initialize(Subject, CallbackHandler, Map<java.lang.String,?>, Map<java.lang.String,?>)
     */
    public void initialize(Subject arg0, CallbackHandler arg1, Map<java.lang.String,?> arg2, Map<java.lang.String,?> arg3)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see LoginModule#commit()
     */
    public boolean commit() throws javax.security.auth.login.LoginException { 
         // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see LoginModule#logout()
     */
    public boolean logout() throws javax.security.auth.login.LoginException { 
         // TODO Auto-generated method stub
			return false;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		params.add(passwd);
		boolean rv = service.isUsreLogin(params);

		Map<String, Object> map = new HashMap<String, Object>();
		if(rv)
		{
			map.put("result","true");
		}else{
			map.put("result","false");
		}		
		String jsonString = JSONSerializer.toJSON(map).toString();
		writer.println(jsonString);
		
		writer.flush();
		writer.close();
	}
}
