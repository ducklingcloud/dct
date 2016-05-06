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

package cn.vlabs.duckling.vwb.tags;

import java.io.IOException;
import java.security.Principal;

/**
 * Introduction Here.
 * @date Feb 25, 2010
 * @author xiejj@cnic.cn
 */
public class UserNameTag extends VWBBaseTag {
	@Override
	public int doVWBStart() throws IOException {
		Principal prin = vwbcontext.getCurrentUser();
		if (prin!=null){
			pageContext.getOut().print(prin.getName());
		}
		return SKIP_BODY;
	}
	
	private static final long serialVersionUID = 1L;
}