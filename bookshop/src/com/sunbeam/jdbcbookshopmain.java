package com.sunbeam;

import java.util.List;
import java.util.Scanner;

public class jdbcbookshopmain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Book b = new Book (43,"UNIX INTERNALS v2","URESH","UNIX",544.20);
		try(BookDao bookdao = new BookDao()){
			int count =  bookdao.update(b);
			System.out.println("Upadated books " + count);
		}catch (Exception e) {
			e.printStackTrace();
		}
		try(BookDao bookDao1 = new BookDao()){
			List<Book> list = bookDao1.findall();
			for (Book book : list) {
				System.out.println(book);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Book bk = new Book (45,"marathi ","vishal","marathi",400.20);
		try(BookDao bkdao = new BookDao()){
			int cnt = bkdao.save(bk);
			System.out.println("added books ...");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try(BookDao bkd =new BookDao()){
		int id;
		System.out.println("Enter id to search book : ");
		id = sc.nextInt();
		Book c = bkd.findBYId(id);
		System.out.println(c.toString());
}catch (Exception e ) {
e.printStackTrace();
}
}
}


