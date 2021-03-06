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

package cn.vlabs.duckling.vwb.service.dpage.impl;

import cn.vlabs.duckling.vwb.service.cache.VWBCacheService;
import cn.vlabs.duckling.vwb.service.dpage.PageLock;

/**
 * @date 2013-5-22
 * @author xiejj@cnic.cn
 */
public class PageLockService {
	public void setCacheService(VWBCacheService cacheService){
		this.cacheService = cacheService;
		this.cacheService.setModulePrefix("lock");
	}
	private VWBCacheService cacheService;

	public PageLock lockPage(int siteId, int pageid,
			String pagelocker, int pageVersion, String sessionId, String usrIp) {
		PageLock mypagelock = (PageLock)cacheService.getFromCache(siteId, pageid);
		if (mypagelock == null) {
			mypagelock = new PageLock();
			mypagelock.setPageid(pageid);
			mypagelock.setPagelocker(pagelocker);
			mypagelock.setPageVersion(pageVersion);
			mypagelock.setSessionId(sessionId);
			mypagelock.setUsrIp(usrIp);
			cacheService.putInCache(siteId,pageid, mypagelock);
		}
		return mypagelock;
	}

	/**
	 * 得到当前页面锁
	 */
	public PageLock getCurrentLock(int siteId, int pageid) {
		return (PageLock)cacheService.getFromCache(siteId, pageid);
	}

	/**
	 * 关闭当前页面锁
	 */
	public void unlockPage(int siteId, int pageid) {
		cacheService.removeEntry(siteId, pageid);
	}
}
