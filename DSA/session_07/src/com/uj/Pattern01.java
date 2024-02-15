package com.uj;

import java.util.Scanner;

public class Pattern01 {

	public static void main(String[] args) {

		/*Online Stationery Store Project Overview
It is a multi-role application project i.e. Admin and User, where Admin will have the main control over the system.

Admin can manage the database of the Stationery shop. Admin will be responsible for maintaining the system and also, keeping a check on the availability of Stationery, updating any details related to the shop, managing users, managing payments, etc. Admin can categorize and set the price range of Stationery accordingly.

The overall project is designed using the MVC pattern (MVC i.e. Model, View, and Controller). In the Backend, it is using Spring Boot, at the data access layer the project is using Hibernate Framework, and at the front end, we are using HTML, CSS, and Bootstrap. The Database used here is MYSQL.

Online Stationery Store Project Abstract
Manually managing stores can sometimes be time-consuming. An application with simple functionality and compatibility should be available for Stationery Store owners. An online application will allow the store owner to add/remove/update Stationery products, generate bills, and view sale history.

Therefore, Codebun has developed Online Stationery Store Project in spring boot and hibernate to handle all the processes of adding products, viewing sales, etc. This application is a multi-user i.e. admin and user, where the admin will manage the overall application. The important objective is to have an application where the Stationery shop owner can add products, and stocks, and view total sales.

Admin can add/remove/update any details related to the shop, update prices of the Stationery items, View/Confirm/Cancel booking orders placed by users, and so on. Admin can Add/Remove/Update Stationery items from the system and manage product categories, details, and their availability.

On the other hand, Users can register themselves and can log in to the system to do online shopping and make payments online.

The following are the major objective of this application:

To provide a bug-free application to the admin.
The main objective is to build a secured, robust Online Stationery Store Project where the information on retail is managed properly.
It maintains the record of Stationery products, stocks, payments, and sales details efficiently so that it would be easy to access at any time 24*7.
Modules of Online Stationery Store Project
Admin Module: This module will allow Admin to log in to the system and manage the system and its functions. Admin can Add/Remove/Update Stationery, manage categories, details, and availability, can manage users, payments, etc.

User: The user can log in/ log out to the system using the registered name and password. Users can manage their profiles and purchase history.

Order: All the order-related operations can be managed in this module. Users can order the Stationery with the help of this module.

Category: In this module, Stationery items can be categorized accordingly.

Sales & Stocks Module: This module will allow the admin to keep records of the number of items that have been sold and track all the sales activities. Admin can Add/Remove/Update stocks with the help of this module.

Details of User: Details of a User like a Name, Contact Number, and Purchase history can be managed with this module.

Payment Module: All the operations related to payments can be managed in this module.

User Roles of Online Stationery Store Project
Admin:

Can Log in/Log out of the system.
Admin can View/Edit/Delete Stationery items and their details.
Can View/Edit/Delete categories into the system.
Admin can track sales activity.
Can check payments.
Can change prices of products.
Can manage user details.
Can change password.
Can manage “My Profiles”.
User:


Can Log In/Log Out of the system.
Can Manage “My profile”.
Can search for Stationery items.
Can search for specific products using their brand names, types, etc.
Users can Place/Cancel an order.
Can make payments online.
Can change password.
Flow Diagram of Online Stationery Store Project





Tools and Technologies Used
Front-End: JSP, Html, CSS, JS.
Server-side: Spring Boot.
Back-end: MYSQL, Hibernate.
Server: Tomcat 8.5.*
		 n=4
		 ****
		 ****
		 ****
		 ****
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n value::");
		int n = sc.nextInt();
		
		for(int r=1;r<=n;r++) {
			for(int c=1;c<=4;c++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
