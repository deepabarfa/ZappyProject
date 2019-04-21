package mockitotest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import connect.Addtocartconnect;
import connect.CustomerConnect;
import connect.LoginConnect;
import connect.OrderConnect;
import connect.RegistrationConnect;
import zappyinfo.Zeppy;

public class CustomerTest 
{
LoginConnect loginc;
RegistrationConnect rs;
OrderConnect oc;
CustomerConnect cc;
Addtocartconnect atc;

	@Before
	public void setUp()
	{
		
		loginc=mock(LoginConnect.class);
		rs=mock(RegistrationConnect.class);
		oc=mock(OrderConnect.class);
		cc=mock(CustomerConnect.class);
		atc=mock(Addtocartconnect.class);
		
		
	}

	@Test
	public void logincustomer()
	{
		when(loginc.Ccheck("deepabarfa30595@gmail.com", "11")).thenReturn(0);
	    Assert.assertEquals(loginc.Ccheck("deepabarfa30595@gmail.com", "11"), 0);
	}
	
	@Test
	public void forgetpassword()
	{
		when(loginc.forgetpassword( "11","deepabarfa30595@gmail.com")).thenReturn(0);
	    Assert.assertEquals(loginc.forgetpassword("11","deepabarfa30595@gmail.com"), 0);
	}
	
	@Test
	public void updateCustomerPassword()
	{
		when(loginc.updateCustomerPassword( "deepabarfa30595@gmail.com","123","11","11")).thenReturn(0);
	    Assert.assertEquals(loginc.updateCustomerPassword( "deepabarfa30595@gmail.com","123","11","11"), 0);
	}
	
	@Test
	public void checkmail()
	{
		Zeppy z=new Zeppy();
		when(loginc.checkemailexist("deepabarfa30595@gmail.com")).thenReturn(z);
	    Assert.assertEquals(loginc.checkemailexist("deepabarfa30595@gmail.com"), z);
	}

	@Test
	public void registration()
	{
		Zeppy ps=new Zeppy(); 
		ps.setEmail("deepa@gmail.com");//set value
		ps.setName("deepa");
		ps.setLastname("barfa");
		ps.setCity("dewas");
		ps.setState("mp");
		ps.setPin("452001");
		ps.setAddress("sindhi colony"); 
		ps.setMobile("787999");
		ps.setPassword("123");
		when(rs.insert("deepa@gmail.com","deepa","barfa","dewas","mp","452001","sindhi colony","787999","123")).thenReturn(0);
	    Assert.assertEquals(rs.insert("deepa@gmail.com","deepa","barfa","dewas","mp","452001","sindhi colony","787999","123"), 0);
	}
	
	@Test
	public void registrationview()
	{
		when(rs.registrationview("deepabarfa30595@gmail.com") ).thenReturn(new ArrayList<Zeppy>());
	    Assert.assertEquals(rs.registrationview("deepabarfa30595@gmail.com"), new ArrayList<Zeppy>());
	}
	
	@Test
	public void viewaddcart()
	{
		when(rs.viewaddcart() ).thenReturn(new ArrayList<Zeppy>());
	    Assert.assertEquals(rs.viewaddcart(), new ArrayList<Zeppy>());
	}
	
	@Test
	public void updateprofile()
	{
		Zeppy ps=new Zeppy(); 
		ps.setName("deepab");
		ps.setCity("dewass");
		ps.setState("mprdesh");
		ps.setPin("452001");
		ps.setAddress("sindhi colony"); 
		ps.setMobile("78799");
		ps.setPassword("123");
		when(rs.updateprofile("deepa","dewas","mp","452001","sindhi colony","787999","123")).thenReturn(0);
	    Assert.assertEquals(rs.updateprofile("deepa","dewas","mp","452001","sindhi colony","787999","123"), 0);
	}
	
	@Test
	public void buyproduct()
	{
		when(oc.buyproduct("deepabarfa30595@gmail.com",8, "172.16.0.60")).thenReturn(0);
	    Assert.assertEquals(oc.buyproduct("deepabarfa30595@gmail.com",8, "172.16.0.60"), 0);
	}
	
	@Test
	public void orderview()
	{
		when(oc.orderview("deepabarfa30595@gmail.com") ).thenReturn(new ArrayList<Zeppy>());
	    Assert.assertEquals(oc.orderview("deepabarfa30595@gmail.com"), new ArrayList<Zeppy>());
	}
	
	@Test
	public void CustomerViewStatus()
	{
		when(oc.CustomerViewStatus("deepabarfa30595@gmail.com") ).thenReturn(new ArrayList<Zeppy>());
	    Assert.assertEquals(oc.CustomerViewStatus("deepabarfa30595@gmail.com"), new ArrayList<Zeppy>());
	}
	
	@Test
	public void viewProfileUpdate()
	{
		Zeppy z=new Zeppy();
		when(cc.viewProfileUpdate("deepabarfa30595@gmail.com")).thenReturn(z);
	    Assert.assertEquals(cc.viewProfileUpdate("deepabarfa30595@gmail.com"),z);
	}
	
	@Test
	public void addtocart()
	{
		when(atc.addtocart(8, "172.16.0.60",1,20)).thenReturn(0);
	    Assert.assertEquals(atc.addtocart(8, "172.16.0.60",1,20), 0);
	}
	
	@Test
	public void viewaddcartt()
	{
		when(atc.viewaddcart("172.16.0.60") ).thenReturn(new ArrayList<Zeppy>());
	    Assert.assertEquals(atc.viewaddcart("172.16.0.60"), new ArrayList<Zeppy>());
	}
	
	@Test
	public void removeProduct()
	{
		when(atc.removeProduct(11, "172.16.0.60")).thenReturn(0);
	    Assert.assertEquals(atc.removeProduct(11, "172.16.0.60"), 0);
	}
	
	@Test
	public void countProduct()
	{
		when(atc.countProduct("172.16.0.60")).thenReturn(0);
	    Assert.assertEquals(atc.countProduct("172.16.0.60"), 0);
	}
	
	@Test
	public void countProductemail()
	{
		when(atc.countProductemail("deepabarfa30595@gmail.com")).thenReturn(0);
	    Assert.assertEquals(atc.countProductemail("deepabarfa30595@gmail.com"), 0);
	}
	
	@Test
	public void countamount()
	{
		when(atc.countamount(1,8)).thenReturn(0);
	    Assert.assertEquals(atc.countamount(1,8), 0);
	}
	
	@Test
	public void addtocartemail()
	{
		when(atc.addtocartemail(8,"deepabarfa30595@gmail.com",1,20)).thenReturn(0);
	    Assert.assertEquals(atc.addtocartemail(8,"deepabarfa30595@gmail.com",1,20), 0);
	}
	
	@Test
	public void viewaddcartemail()
	{
		when(atc.viewaddcartemail("deepabarfa30595@gmail.com") ).thenReturn(new ArrayList<Zeppy>());
	    Assert.assertEquals(atc.viewaddcartemail("deepabarfa30595@gmail.com"), new ArrayList<Zeppy>());
	}
	
	@Test
	public void updatecart()
	{
		when(atc.updatecart("deepabarfa30595@gmail.com","172.16.0.60")).thenReturn(0);
	    Assert.assertEquals(atc.updatecart("deepabarfa30595@gmail.com","172.16.0.60"), 0);
	}
	
	@Test
	public void removeProductemail()
	{
		when(atc.removeProductemail(8,"deepabarfa30595@gmail.com")).thenReturn(0);
	    Assert.assertEquals(atc.removeProductemail(8,"deepabarfa30595@gmail.com"), 0);
	}
	
	@Test
	public void checkpidexist()
	{
		when(atc.checkpidexist(8,1,"172.16.0.60")).thenReturn(0);
	    Assert.assertEquals(atc.checkpidexist(8,1,"172.16.0.60"), 0);
	}

	@Test
	public void updateCartquantity()
	{
		when(atc.updateCartquantity(8,1)).thenReturn(0);
	    Assert.assertEquals(atc.updateCartquantity(8,1), 0);
	}

	@Test
	public void checkpidexistEmail()
	{
		when(atc.checkpidexistEmail(1,8,"deepabarfa30595@gmail.com")).thenReturn(0);
	    Assert.assertEquals(atc.checkpidexistEmail(8,1,"deepabarfa30595@gmail.com"), 0);
	}

	@Test
	public void updateCartquantityEmail()
	{
		when(atc.updateCartquantityEmail(8,1)).thenReturn(0);
	    Assert.assertEquals(atc.updateCartquantityEmail(8,1), 0);
	}

	@Test
	public void updatequntityafteradd()
	{
		when(atc.updatequntityafteradd(8,1)).thenReturn(0);
	    Assert.assertEquals(atc.updatequntityafteradd(8,1), 0);
	}

	@Test
	public void checkwhenpidexist()
	{
		when(atc.checkwhenpidexist("deepabarfa30595@gmail.com","172.16.0.60")).thenReturn(0);
	    Assert.assertEquals(atc.checkwhenpidexist("deepabarfa30595@gmail.com","172.16.0.60"), 0);
	}
	
	
}
