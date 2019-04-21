package mockitotest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import connect.CustomerView;
import connect.LoginConnect;
import connect.OrderConnect;
import connect.ProductViewConnect;
import connect.UpdateConnect;
import zappyinfo.Zeppy;
import zappyinfo.admin;

public class AdminTest 
{
	LoginConnect lc;
	UpdateConnect uc;
	ProductViewConnect pvc;
	OrderConnect oc;
	CustomerView cv;
	
	@Before
	public void setUp()
	{
		lc=mock(LoginConnect.class);
		uc=mock(UpdateConnect.class);
		pvc=mock(ProductViewConnect.class);
		oc=mock(OrderConnect.class);
		cv=mock(CustomerView.class);
	}

	@Test
	public void loginAdmin()
	{
		when(lc.check("deepa", "1212")).thenReturn(0);
	    Assert.assertEquals(lc.check("deepa", "1212"), 0);
	}
	
	@Test
	public void updateap()
	{
		when(lc.updateap("deepa", "12","1212","1212")).thenReturn(0);
	    Assert.assertEquals(lc.updateap("deepa", "12","1212","1212"), 0);
	}
	
	@Test
	public void delete()
	{
		when(uc.delete(7)).thenReturn(0);
	    Assert.assertEquals(uc.delete(7), 0);
	}
	
	@Test
	public void update()
	{
		Zeppy z=new Zeppy();
		when(uc.update(7)).thenReturn(z);
	    Assert.assertEquals(uc.update(7),z);
	}
	
	@Test
	public void updateimage()
	{
		Zeppy z=new Zeppy();
		when(uc.updateimage(7)).thenReturn(z);
	    Assert.assertEquals(uc.updateimage(7), z);
	}
	
	@Test
	public void adminupdate()
	{
		admin a=new admin();
		when(uc.adminupdate("deepa")).thenReturn(a);
	    Assert.assertEquals(uc.adminupdate("deepa"), a);
	}

	@Test
	public void productview()
	{
		when(pvc.productview() ).thenReturn(new ArrayList<Zeppy>());
	    Assert.assertEquals(pvc.productview(), new ArrayList<Zeppy>());
	}
	
	@Test
	public void productDetailsview()
	{
		when(pvc.productDetailsview(9) ).thenReturn(new ArrayList<Zeppy>());
	    Assert.assertEquals(pvc.productDetailsview(9), new ArrayList<Zeppy>());
	}
	
	@Test
	public void orderallview()
	{
		when(oc.orderallview() ).thenReturn(new ArrayList<Zeppy>());
	    Assert.assertEquals(oc.orderallview(), new ArrayList<Zeppy>());
	}
	
	@Test
	public void orderDispatchecancelview()
	{
		when(oc.orderDispatchecancelview(1) ).thenReturn(new ArrayList<Zeppy>());
	    Assert.assertEquals(oc.orderDispatchecancelview(1), new ArrayList<Zeppy>());
	}
	
	@Test
	public void dispatchProduct()
	{
		when(oc.dispatchProduct(7,2)).thenReturn(0);
	    Assert.assertEquals(oc.dispatchProduct(7,2), 0);
	}
	
	@Test
	public void cancelProduct()
	{
		when(oc.cancelProduct(7,2)).thenReturn(0);
	    Assert.assertEquals(oc.cancelProduct(7,2), 0);
	}
	
	@Test
	public void Dispatchallview()
	{
		when(oc.Dispatchallview() ).thenReturn(new ArrayList<Zeppy>());
	    Assert.assertEquals(oc.Dispatchallview(), new ArrayList<Zeppy>());
	}
	
	@Test
	public void customerview()
	{
		when(cv.customerview() ).thenReturn(new ArrayList<Zeppy>());
	    Assert.assertEquals(cv.customerview(), new ArrayList<Zeppy>());
	}
	
}
