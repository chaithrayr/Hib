package mapping;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class hbdetails {
	
	
	
		      	public void saveUser(String name, String email, long no, String account, String bankname) {
		
		      	  Session session = HibernateUtil.getSessionFactory();
			        Transaction trans = null;
			        try {
			            trans = session.beginTransaction();
			        	
				       List<Bank> l1 = new ArrayList<Bank>();
				 
			        	User u = new User();
			        	u.setName(name);
	                    u.setEmail(email);
	                    u.setMobileno(no);
	                  
          if(u.getEmail()==email  || u.getMobileno()==no) {
	                    	System.out.println("Error Occured");
	                    }
	              
			        	Bank b = new Bank();
			        	b.setAccount(account);
			        	b.setBankname(bankname);
	                    b.setUser(u);
	                    l1.add(b);
	                    u.setBank(l1);
	                   
	                    session.save(b);
			        	session.save(u);
			         	trans.commit();
			        	
			            System.out.println("mapping completed");
			        
			        } catch (HibernateException e) {
			           trans.rollback();
			            e.printStackTrace();
			        } finally {
			            session.close();
			        }
			 
			    }


	}


	
