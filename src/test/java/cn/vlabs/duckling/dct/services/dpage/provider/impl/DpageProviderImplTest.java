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

package cn.vlabs.duckling.dct.services.dpage.provider.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.vlabs.duckling.vwb.service.dpage.data.DPagePo;
import cn.vlabs.duckling.vwb.service.dpage.provider.DPageProviderImpl;
import cn.vlabs.duckling.vwb.services.TestService;

/**
 * Introduction Here.
 * @date Feb 23, 2010
 * @author xiejj@cnic.cn
 */
public class DpageProviderImplTest extends TestService {
	private  DPageProviderImpl provider;
	@Before
	public void setUp() throws Exception {
		super.setUp();
		provider = (DPageProviderImpl) manager.getFactory().getBean("dpageProvider");
	}

	@After
	public void tearDown() throws Exception {
		provider=null;
		super.tearDown();
	}

	@Test
	public void testGetLatestByResourceId() {
		DPagePo dpage= provider.getLatestByResourceId(1,1);
		assertNotNull(dpage);
	}

}
