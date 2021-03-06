/*
 * Copyright (c) 2008-2016 Computer Network Information Center (CNIC), Chinese Academy of Sciences.
 * 
 * This file is part of Duckling project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 *
 */

package cn.vlabs.duckling.vwb.service.dml.html2dml;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.jdom.Element;
import org.jdom.JDOMException;

/**
 * Introduction Here.
 * 
 * @date 2010-3-8
 * @author 狄 diyanliang@cnic.cn
 */
public class ParseHtmlTable extends AbstractParseHtmlElement {
	@Override
	public void printAttribute(Element e, Html2DmlEngine html2dmlengine) {
		Map<String, String> map = new ForgetNullValuesLinkedHashMap();
		map.put("width", e.getAttributeValue("width"));
		map.put("height", e.getAttributeValue("height"));
		map.put("border", e.getAttributeValue("border"));
		map.put("cellspacing", e.getAttributeValue("cellspacing"));
		map.put("cellpadding", e.getAttributeValue("cellpadding"));
		map.put("align", e.getAttributeValue("align"));
		map.put("bgcolor", e.getAttributeValue("bgcolor"));
		map.put("class", e.getAttributeValue("class"));
		map.put("style", e.getAttributeValue("style"));
		if (map.size() > 0) {
			for (Iterator<Map.Entry<String, String>> ito = map.entrySet()
					.iterator(); ito.hasNext();) {
				Map.Entry<String, String> entry = ito.next();
				if (!entry.getValue().equals("")) {
					html2dmlengine.getM_out().print(
							" " + entry.getKey() + "=\"" + entry.getValue()
									+ "\"");
				}
			}
		}
	}

	@Override
	public void printElement(Element e, Html2DmlEngine html2dmlengine) {
		html2dmlengine.getM_out().print("<table");
		printAttribute(e, html2dmlengine);
		if (html2dmlengine.getPreType() > 0) {
			html2dmlengine.getM_out().print(">");
		} else {
			html2dmlengine.getM_out().println(">");
		}
		try {
			h2d.getChildren(e, html2dmlengine);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (JDOMException e1) {
			e1.printStackTrace();
		}
		if (html2dmlengine.getPreType() > 0) {
			html2dmlengine.getM_out().print("</table>");
		} else {
			html2dmlengine.getM_out().println("</table>");
		}
	}

}
