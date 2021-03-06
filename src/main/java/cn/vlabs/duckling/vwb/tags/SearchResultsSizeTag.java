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
/* 
    JSPWiki - a JSP-based WikiWiki clone.

    Copyright (C) 2001-2004 Janne Jalkanen (Janne.Jalkanen@iki.fi)

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation; either version 2.1 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package cn.vlabs.duckling.vwb.tags;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.PageContext;

/**
 * Outputs the size of the search results list, if it contains any items.
 * Otherwise outputs an empty string.
 * 
 * @author Janne Jalkanen
 * @since 2.0
 */
public class SearchResultsSizeTag extends VWBBaseTag {
	private static final long serialVersionUID = 0L;

	public final int doVWBStart() throws IOException {
		Collection<?> list = (Collection<?>) pageContext.getAttribute(
				"searchresults", PageContext.REQUEST_SCOPE);
		if (list != null) {
			pageContext.getOut().print(list.size());
		}

		return SKIP_BODY;
	}
}
