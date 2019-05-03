package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mapping.Bank;
import mapping.User;

public class Success extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
        public Success() {
        super();    
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String action=request.getParameter("action");
		
		if("ShowUsers".equals(action)) {
			
			String sql="from User";

			SessionFactory sf = new Configuration().configure().addAnnotatedClass(Bank.class).addAnnotatedClass(User.class).buildSessionFactory();
			Session session = sf.openSession();
			Query q=session.createQuery(sql);
			Iterator it = q.iterate();

			pw.append("<table border=1\">");
			pw.append("<th>ID</th> <th>NAME</th> <th>EMAIL</th> <th>MOBILENO</th>");
			
			while(it.hasNext()) {
				
				User ui = (User) it.next();
				pw.append("<tr><td>"+ui.getId()+"</td>");
				pw.append("<td>"+ui.getName()+"</td>");
				pw.append("<td>"+ui.getEmail()+"</td>");
				pw.append("<td>"+ui.getMobileno()+"</td> </tr>");		
			}
			 pw.print("</table>");
		}
		
		else if("ShowBankers".equals(action)) {
			
			String sql1="from Bank";

			SessionFactory sf = new Configuration().configure().addAnnotatedClass(Bank.class).buildSessionFactory();
			Session session = sf.openSession();
			Query q=session.createQuery(sql1);
			Iterator it = q.iterate();
			
			pw.append("<table border=1\">");
			pw.append("<th>ID</th> <th>BANKNAME</th> <th>ACCOUNT</th>");

		  while(it.hasNext()) {
				
			Bank bi = (Bank) it.next();
			pw.append("<tr><td>"+bi.getId()+"</td>");
			pw.append("<td>"+bi.getBankname()+"</td>");
			pw.append("<td>"+bi.getAccount()+"</td> </tr>");
		
			}
		pw.print("</table>");
		}		
    	pw.println("<a href='index.jsp'>GoToMain</a>");
	}

 }
