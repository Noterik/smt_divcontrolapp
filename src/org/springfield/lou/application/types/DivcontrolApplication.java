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
import java.util.Iterator;

import org.springfield.fs.FSList;
import org.springfield.fs.FsNode;
import org.springfield.lou.application.*;
import org.springfield.lou.screen.*;
import org.springfield.mojo.interfaces.ServiceInterface;
import org.springfield.mojo.interfaces.ServiceManager;

public class DivcontrolApplication extends Html5Application {
	
 	public DivcontrolApplication(String id) {
		super(id); 

	}
 	
	public void searchdone(Screen s,String content) {
		contentToProperties(s,content);
		s.setContent("divone",(String)s.getProperty("searchkey.value"));
	}
 	
	public void testeuropeana(Screen s,String id) {		
		
		ServiceInterface albright = ServiceManager.getService("albright");
		System.out.println("HTML5 ALBRIGHT2="+albright);
		String result = albright.get("/domain/euscreenxl/user/luce/video/123455/ep_images/",null,"text/xml");
		
		result ="<fsxml>";
		result +="<ep_images id=\"1\">";
		result +="<properties>";
		result +="<title>bla die bla</title>";
		result +="</properties>";
		result +="</ep_images>";	
		result +="<ep_images id=\"2\">";
		result +="<properties>";
		result +="<title>bla die bla2</title>";
		result +="</properties>";
		result +="</ep_images>";
		result +="</fsxml>";	
		FSList nodes = new FSList().parseNodes(result);
		System.out.println("NDOE SIZE DIVCODE="+nodes.size());
		
		for(Iterator<FsNode> iter = nodes.getNodes().iterator() ; iter.hasNext(); ) {
			FsNode n = (FsNode)iter.next();	
	 			System.out.println("TITLE="+n.getProperty("title"));
	 			System.out.println("ID="+n.getId());
		}
		
		// do something fun with the nodes, like load them in a div file�
		String body = result;
		setContent("divthree", body);
	}
	
	public void contentToProperties(Screen s,String content) {
		String[] cmd=content.split(",");
		for (int i=0;i<cmd.length;i++) {
			String[] param = cmd[i].split("=");
			s.setProperty(param[0],param[1]);
		}
		
	}
	
}
