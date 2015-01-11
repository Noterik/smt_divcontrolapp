/* 
* DivcontrolApplication.java
* 
* Copyright (c) 2012 Noterik B.V.
* 
* This file is part of Lou, related to the Noterik Springfield project.
* It was created as a example of how to use the multiscreen toolkit
*
* Helloworld app is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* Helloworld app is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with Helloworld app.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.springfield.lou.application.types;
import org.springfield.fs.FSList;
import org.springfield.lou.application.*;
import org.springfield.lou.screen.*;
import org.springfield.mojo.interfaces.ServiceInterface;
import org.springfield.mojo.interfaces.ServiceManager;

public class DivcontrolApplication extends Html5Application {
	
 	public DivcontrolApplication(String id) {
		super(id); 

	}
 	
	public void testeuropeana(Screen s,String id) {
		System.out.println("TEST ALBRIGHT CALL3");	
		
		
		ServiceInterface albright = ServiceManager.getService("albright");
		System.out.println("HTML5 ALBRIGHT="+albright);
		String result = albright.get("/domain/euscreenxl/user/luce/video/123455/ep_images/",null,"text/xml");
		
		//FSList nodes = new FSList.parseNodes(result);
		
		// do something fun with the nodes, like load them in a div file 
		String body = result;
		setContent("divthree", body);
		

	}
}
