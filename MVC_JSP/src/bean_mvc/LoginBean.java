package bean_mvc;
//Model Layer
public class LoginBean {
	private String uname=null;;
	private String password=null;
	public void setName(String name)
	{
		uname=name;
	}
	public void setPassword(String x)
	{
		password=x;
	}
	public String getName()
	{
		return uname;
	}
	public String getPassword()
	{
		return password;
	}
	public boolean validate()
	{
		if(uname.equals("Sahitya") && password.equals("Chinni"))
		{
			return true;
		}
		return false;
	}
}
