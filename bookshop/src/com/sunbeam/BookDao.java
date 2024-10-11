package com.sunbeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements AutoCloseable {
	private Connection con;
	
	public BookDao() throws Exception {
	con= Dbutil.getConnection();
}
public void close() throws Exception {
	if(con !=null)
		con.close();
}
public int save(Book b) throws Exception {
	String sql = "insert into books (id,name,author,subject,price) values(?,?,?,?,?)";
	try(PreparedStatement stmt = con.prepareStatement(sql)){
		stmt.setInt(1, b.getId());
		stmt.setString(2, b.getName());
		stmt.setString(3, b.getAuthor());
		stmt.setString(4, b.getSubject());
		stmt.setDouble(5, b.getPrice());
		int cnt = stmt.executeUpdate();
		return cnt;
	}
	
	
}
public int update(Book b) throws  Exception {
	String sql ="UPDATE books SET name=?,author=?,subject=?,price=? where id=?";
			try(PreparedStatement stmt=con.prepareCall(sql)){
				stmt.setString(1, b.getName());
				stmt.setString(2, b.getAuthor());
				stmt.setString(3,b.getSubject());
				stmt.setDouble(4, b.getPrice());
				stmt.setInt(5, b.getId());
				int count = stmt.executeUpdate();
				return count;
			}
}
public int deleteBYID(int id) {
	
	return 0;
}
public List<Book> findall() throws Exception {
	List <Book> list=new ArrayList<Book>();
	String sql= "select *from Books";
			try(PreparedStatement stmt =con.prepareStatement(sql)){
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						int id= rs.getInt("Id");
						String name=rs.getString("name");
						String author=rs.getString("author");
						String Subject=rs.getString("subject");
					   double price =rs.getDouble("price");
							Book b =new Book(id ,name,author,Subject,price);
							list.add(b);
					}
				}
			}
	return list;
}
public Book findBYId(int id) throws Exception {
	String sql="select * from Books where id = ?";
	try(PreparedStatement stmt =con.prepareStatement(sql)){
		stmt.setInt(1, id);
		
		try(ResultSet rs=stmt.executeQuery()){
			if(rs.next()) {
				int id1=rs.getInt("id");
				String name=rs.getString("name");
				String author=rs.getString("author");
				String Subject=rs.getString("Subject");
				double price=rs.getDouble("price");
				Book bk=new Book(id,name,author,Subject,price);
				return bk;
				
			}
		}
		
	}
	return null;	
}
public List<Book> findBysubject(String subject) throws Exception {
	List<Book> list1 = new ArrayList<Book>();
	String sql = "select * from books where subject = ?";
	try(PreparedStatement stmt = con.prepareStatement(sql)){
		stmt.setString(1, subject);
		try(ResultSet rs = stmt.executeQuery()){
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String author = rs.getString("author");
				String subjec = rs.getString("subject");
				double pric = rs.getDouble("price");
				
				Book bk = new Book(id,name,author,subjec,pric);
				
				list1.add(bk);
			}
		}
	}
	return list1;
	
}
public Book findAllSubject () {
	return null;
}

}