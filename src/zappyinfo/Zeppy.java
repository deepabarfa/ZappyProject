package zappyinfo;
//getter setter function
public class Zeppy 
{
	String uid;
	String email;
    String name;
    String lastname;
    String city;
    String state;
    String pin;
    String address;
    String mobile;
    Double tamount;
    String password;
    String date;
    int status;
    int orderID;
    
	int productID;
	String productname;
	Double price;
	String weight;
	String details;
	String images;
	String ipaddress;
	int quantity;
	
	
	
	@Override
	public String toString() {
		return "Zeppy [orderID=" + orderID +",uid=" + uid + ", email=" + email + ", name=" + name + ", lastname=" + lastname + ", city=" + city
				+ ", state=" + state + ", pin=" + pin + ", address=" + address + ", mobile=" + mobile + ", tamount="
				+ tamount + ", password=" + password + ", date=" + date + ", productID=" + productID + ", productname="
				+ productname + ", price=" + price + ", weight=" + weight + ", details=" + details + ", images="
				+ images + ", ipaddress=" + ipaddress + ", quantity=" + quantity + "]";
	}
	public Zeppy() {
		super();
	}
	public Zeppy(String uid,String email, String name, String lastname, String city, String state, String pin, String address,
			String mobile, Double tamount,String password,String date,int status,int orderID, int productID, String productname, Double price, String weight, String details,
			String images, String ipaddress, int quantity) {
		super();

		this.uid = uid;
		this.email = email;
		this.name = name;
		this.lastname = lastname;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.address = address;
		this.mobile = mobile;
		this.tamount = tamount;
		this.password = password;
		this.date = date;
		this.status = status;
		this.orderID = orderID;
		
		this.productID = productID;
		this.productname = productname;
		this.price = price;
		this.weight = weight;
		this.details = details;
		this.images = images;
		this.ipaddress = ipaddress;
		this.quantity = quantity;
	}
	public String getUid() 
	{
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getOrderID() 
	{
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Double getTamount() {
		return tamount;
	}
	public void setTamount(Double tamount) {
		this.tamount = tamount;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
